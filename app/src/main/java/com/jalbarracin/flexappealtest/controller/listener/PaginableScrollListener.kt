package com.jalbarracin.flexappealtest.controller.listener

import android.widget.AbsListView


abstract class PaginableScrollListener: AbsListView.OnScrollListener {

    private var visibleThreshold = 5
    private var currentPage = 0
    private var previousTotal = 0
    private var loading = true
    var disabled = false


    constructor() : this(5)

    constructor(visibleThreshold: Int) {
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
            loadData(currentPage + 1)
            loading = true
        }
    }

    override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {
    }

    abstract fun loadData(offset: Int)

}