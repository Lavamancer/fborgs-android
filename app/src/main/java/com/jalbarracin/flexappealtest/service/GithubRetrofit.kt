package com.jalbarracin.flexappealtest.service

import android.widget.Toast
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jalbarracin.flexappealtest.controller.MainActivity
import com.jalbarracin.flexappealtest.controller.ProgressBarController
import com.jalbarracin.flexappealtest.controller.RepositoryActivity
import com.jalbarracin.flexappealtest.controller.fragment.ContributorsFragment
import com.jalbarracin.flexappealtest.controller.fragment.IssuesFragment
import com.jalbarracin.flexappealtest.service.deserializer.DateTimeDeserializer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.joda.time.DateTime
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object GithubRetrofit {

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
        val dialog = ProgressBarController.create(activity)
        dialog.show()
        var q = "org:facebook"
        if (searchText != null) {
            q += " $searchText in:name"
        }
        activity.compositeDisposable.add(
            githubApi.getSearchRepositories(q, offset, 20)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    dialog.dismiss()
                    activity.updateListView(it.items, it.totalCount, newSearch)
                },{
                    dialog.dismiss()
                    Toast.makeText(activity, "Github only allows 10 calls per minute", Toast.LENGTH_SHORT).show()
                    activity.updateListView(ArrayList(), 0, newSearch)
                })
        )
    }

    fun getContributors(fragment: ContributorsFragment) {
        val repositoryActivity = (fragment.activity as RepositoryActivity)
        repositoryActivity.compositeDisposable.add(
            githubApi.getContributors(repositoryActivity.repository.name)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    fragment.updateListView(it)
                },{
                    Toast.makeText(repositoryActivity, "Github only allows 10 calls per minute", Toast.LENGTH_SHORT).show()
                })
        )
    }

    fun getIssues(fragment: IssuesFragment) {
        val repositoryActivity = (fragment.activity as RepositoryActivity)
        repositoryActivity.compositeDisposable.add(
            githubApi.getIssues(repositoryActivity.repository.name)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    fragment.updateListView(it)
                },{
                    Toast.makeText(repositoryActivity, "Github only allows 10 calls per minute", Toast.LENGTH_SHORT).show()
                })
        )
    }

}