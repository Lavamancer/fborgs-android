/*
 * Created by Juan Albarracin on 19/03/19 14:25
 * Copyright (c) 2019. All right reserved.
 *
 * Last modified 19/03/19 14:25
 */

package com.jalbarracin.flexappealtest.service

import android.view.View
import android.widget.Toast
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jalbarracin.flexappealtest.R
import com.jalbarracin.flexappealtest.controller.MainActivity
import com.jalbarracin.flexappealtest.controller.RepositoryActivity
import com.jalbarracin.flexappealtest.controller.fragment.ContributorsFragment
import com.jalbarracin.flexappealtest.controller.fragment.IssuesFragment
import com.jalbarracin.flexappealtest.service.deserializer.DateTimeDeserializer
import com.jalbarracin.flexappealtest.service.tool.ProgressBarTool
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_contributors.*
import kotlinx.android.synthetic.main.fragment_issues.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.joda.time.DateTime
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object GithubRetrofit {

    private const val PAGINATION_LIMIT = 20
    private const val BASE_URL = "https://api.github.com"
    private const val PARAM_ORG_FACEBOOK = "org:facebook"
    private const val PARAM_IN_NAME = "in:name"


    private var githubApi: GithubApi


    init {
        val builder = Retrofit.Builder().baseUrl(BASE_URL)
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

        val dialog = if (activity.repositoryAdapter.list.isEmpty()) ProgressBarTool.create(activity) else null
        if (dialog != null) dialog.show() else activity.repositoryProgressBar.visibility = View.VISIBLE

        var q = PARAM_ORG_FACEBOOK
        if (searchText != null) {
            q += " $searchText $PARAM_IN_NAME"
        }
        activity.compositeDisposable.add(
            githubApi.getSearchRepositories(q, offset, PAGINATION_LIMIT)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    if (dialog != null) dialog.dismiss() else activity.repositoryProgressBar.visibility = View.GONE
                    activity.updateListView(it.items, it.totalCount, newSearch)
                },{
                    if (dialog != null) dialog.dismiss() else activity.repositoryProgressBar.visibility = View.GONE
                    Toast.makeText(activity, activity.getString(R.string.github_forbidden_response), Toast.LENGTH_SHORT).show()
                    activity.updateListView(ArrayList(), 0, newSearch)
                })
        )
    }

    fun getContributors(fragment: ContributorsFragment, offset: Int = 0) {
        val repositoryActivity = (fragment.activity as RepositoryActivity)
        repositoryActivity.contributorsProgressBar.visibility = View.VISIBLE
        repositoryActivity.compositeDisposable.add(
            githubApi.getContributors(repositoryActivity.repository.name, offset, PAGINATION_LIMIT)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    fragment.updateListView(it)
                    repositoryActivity.contributorsProgressBar.visibility = View.GONE
                },{
                    Toast.makeText(repositoryActivity, fragment.getString(R.string.github_forbidden_response), Toast.LENGTH_SHORT).show()
                    repositoryActivity.contributorsProgressBar.visibility = View.GONE
                })
        )
    }

    fun getIssues(fragment: IssuesFragment, offset: Int = 0) {
        val repositoryActivity = (fragment.activity as RepositoryActivity)
        repositoryActivity.issuesProgressBar.visibility = View.VISIBLE
        repositoryActivity.compositeDisposable.add(
            githubApi.getIssues(repositoryActivity.repository.name, offset, PAGINATION_LIMIT)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    fragment.updateListView(it)
                    repositoryActivity.issuesProgressBar.visibility = View.GONE
                },{
                    Toast.makeText(repositoryActivity, fragment.getString(R.string.github_forbidden_response), Toast.LENGTH_SHORT).show()
                    repositoryActivity.issuesProgressBar.visibility = View.GONE
                })
        )
    }

}