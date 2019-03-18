package com.jalbarracin.flexappealtest.service

import com.jalbarracin.flexappealtest.model.response.GithubResponse
import com.jalbarracin.flexappealtest.model.Repository
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiRepository {

    @GET("/search/repositories")
    fun getSearchRepositories(
        @Query("q") query: String,
        @Query("page") offset: Int,
        @Query("per_page") limit: Int): Observable<GithubResponse>

    @GET("/orgs/facebook/repos")
    fun getFacebookRepositories(
        @Query("page") offset: Int,
        @Query("per_page") limit: Int): Observable<List<Repository>>

}