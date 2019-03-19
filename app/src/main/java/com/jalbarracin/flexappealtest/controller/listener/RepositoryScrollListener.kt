package com.jalbarracin.flexappealtest.controller.listener

import android.widget.AbsListView
import com.jalbarracin.flexappealtest.controller.MainActivity
import com.jalbarracin.flexappealtest.service.GithubRetrofit


class RepositoryScrollListener: AbsListView.OnScrollListener {

    private var visibleThreshold = 5
    private var currentPage = 0
    private var previousTotal = 0
    private var loading = true
    private var activity: MainActivity
    var disabled = false


    constructor(activity: MainActivity) : this(activity, 5)

    constructor(activity: MainActivity, visibleThreshold: Int) {
        this.activity = activity
        this.visibleThreshold = visibleThreshold
    }

    fun clear() {
        currentPage = 0
        previousTotal = 0
        loading = true
        disabled = false
    }

    override fun onScroll(view: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {
        if (loading) {
            if (totalItemCount > previousTotal) {
                loading = false
                previousTotal = totalItemCount
                currentPage++
            }
        }
        if (!disabled && !loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
            GithubRetrofit.getSearch(activity, false, currentPage + 1, activity.repositoryAdapter.searchText)
            loading = true
        }
    }

    override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {
    }

}