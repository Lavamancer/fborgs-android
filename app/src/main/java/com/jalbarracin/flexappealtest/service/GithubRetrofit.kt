package com.jalbarracin.flexappealtest.service

import android.widget.Toast
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jalbarracin.flexappealtest.controller.MainActivity
import com.jalbarracin.flexappealtest.controller.RepositoryActivity
import com.jalbarracin.flexappealtest.controller.fragment.ContributorsFragment
import com.jalbarracin.flexappealtest.controller.fragment.IssuesFragment
import com.jalbarracin.flexappealtest.service.deserializer.DateTimeDeserializer
import com.jalbarracin.flexappealtest.service.tool.ProgressBarTool
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.joda.time.DateTime
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object GithubRetrofit {

    private const val PAGINATION_LIMIT = 20

    private var githubApi: GithubApi


    init {
        val builder = Retrofit.Builder().baseUrl("https://api.github.com")
        builder.client(createHttpClient())
        val retrofit = builder
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(createGson()))
            .build()

        githubApi = retrofit.create<GithubApi>(GithubApi::class.java)
    }

    private fun createGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.registerTypeAdapter(DateTime::class.java,
            DateTimeDeserializer()
        )
        return gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
    }

    private fun createHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(loggingInterceptor)
        return httpClient.build()
    }

    fun getSearch(activity: MainActivity, newSearch: Boolean, offset: Int = 0, searchText: String? = null) {
        activity.countingIdlingResource.increment()
        val dialog = ProgressBarTool.create(activity)
        dialog.show()
        var q = "org:facebook"
        if (searchText != null) {
            q += " $searchText in:name"
        }
        activity.compositeDisposable.add(
            githubApi.getSearchRepositories(q, offset, PAGINATION_LIMIT)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    dialog.dismiss()
                    activity.updateListView(it.items, it.totalCount, newSearch)
                },{
                    dialog.dismiss()
                    Toast.makeText(activity, "Github only allows 10 calls per minute or 60 per hour", Toast.LENGTH_SHORT).show()
                    activity.updateListView(ArrayList(), 0, newSearch)
                })
        )
    }

    fun getContributors(fragment: ContributorsFragment, offset: Int = 0) {
        val repositoryActivity = (fragment.activity as RepositoryActivity)
        repositoryActivity.compositeDisposable.add(
            githubApi.getContributors(repositoryActivity.repository.name, offset, PAGINATION_LIMIT)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    fragment.updateListView(it)
                },{
                    Toast.makeText(repositoryActivity, "Github only allows 10 calls per minute or 60 per hour", Toast.LENGTH_SHORT).show()
                })
        )
    }

    fun getIssues(fragment: IssuesFragment, offset: Int = 0) {
        val repositoryActivity = (fragment.activity as RepositoryActivity)
        repositoryActivity.compositeDisposable.add(
            githubApi.getIssues(repositoryActivity.repository.name, offset, PAGINATION_LIMIT)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    fragment.updateListView(it)
                },{
                    Toast.makeText(repositoryActivity, "Github only allows 10 calls per minute or 60 per hour", Toast.LENGTH_SHORT).show()
                })
        )
    }

}