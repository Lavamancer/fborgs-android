package com.jalbarracin.flexappealtest.service

import com.jalbarracin.flexappealtest.model.Issue
import com.jalbarracin.flexappealtest.model.Owner
import com.jalbarracin.flexappealtest.model.response.GithubResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface GithubApi {

    @GET("/search/repositories")
    fun getSearchRepositories(
        @Query("q") query: String,
        @Query("page") offset: Int,
        @Query("per_page") limit: Int): Observable<GithubResponse>

    @GET("/repos/facebook/{name}/contributors")
    fun getContributors(
        @Path("name") name: String?,
        @Query("page") offset: Int,
        @Query("per_page") limit: Int): Observable<List<Owner>>

    @GET("/repos/facebook/{name}/issues")
    fun getIssues(@Path("name") name: String?): Observable<List<Issue>>

}