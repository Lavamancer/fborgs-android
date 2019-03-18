package com.jalbarracin.flexappealtest.service

import android.app.Activity
import android.widget.BaseAdapter
import android.widget.Toast
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.jalbarracin.flexappealtest.controller.ProgressBarController
import com.jalbarracin.flexappealtest.model.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory




object GithubRetrofit {

    var apiRepository: ApiRepository


    init {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(loggingInterceptor)

        val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()

        val builder = Retrofit.Builder().baseUrl("https://api.github.com")
        builder.client(httpClient.build())
        val retrofit = builder
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        apiRepository = retrofit.create<ApiRepository>(ApiRepository::class.java)
    }

    fun getRepositories(activity: Activity, adapter: BaseAdapter, list: ArrayList<Repository>, compositeDisposable: CompositeDisposable) {
        val dialog = ProgressBarController.create(activity)
        dialog.show()
        compositeDisposable.add(
            apiRepository.getFacebookRepositories(0, 1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    list.clear()
                    list.addAll(it)
                    adapter.notifyDataSetChanged()
                    dialog.dismiss()
                },{
                    Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()
                })
        )
    }


}