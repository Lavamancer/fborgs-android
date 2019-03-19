package com.jalbarracin.flexappealtest.controller.listener

import android.widget.AbsListView
import com.jalbarracin.flexappealtest.controller.fragment.ContributorsFragment
import com.jalbarracin.flexappealtest.service.GithubRetrofit


class ContributorsScrollListener: AbsListView.OnScrollListener {

    private var visibleThreshold = 5
    private var currentPage = 0
    private var previousTotal = 0
    private var loading = true
    private var fragment: ContributorsFragment
    var disabled = false


    constructor(fragment: ContributorsFragment) : this(fragment, 5)

    constructor(fragment: ContributorsFragment, visibleThreshold: Int) {
        this.fragment = fragment
        this.visibleThreshold = visibleThreshold
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
            GithubRetrofit.getContributors(fragment, currentPage + 1)
            loading = true
        }
    }

    override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {
    }

}