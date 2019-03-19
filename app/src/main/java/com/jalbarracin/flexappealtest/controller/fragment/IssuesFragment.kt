package com.jalbarracin.flexappealtest.controller.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jalbarracin.flexappealtest.R
import com.jalbarracin.flexappealtest.controller.adapter.IssuesAdapter
import com.jalbarracin.flexappealtest.controller.listener.PageableScrollListener
import com.jalbarracin.flexappealtest.model.Issue
import com.jalbarracin.flexappealtest.service.GithubRetrofit
import kotlinx.android.synthetic.main.fragment_contributors.*


class IssuesFragment: Fragment() {

    lateinit var issuesAdapter: IssuesAdapter
    lateinit var pageableScrollListener: PageableScrollListener


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_issues, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        issuesAdapter = IssuesAdapter(activity!!, ArrayList())
        listView.adapter = issuesAdapter
        pageableScrollListener = object: PageableScrollListener() {
            override fun loadData(offset: Int) {
                GithubRetrofit.getIssues(this@IssuesFragment, offset)
            }
        }
        listView.setOnScrollListener(pageableScrollListener)
        GithubRetrofit.getIssues(this)
    }

    fun updateListView(list: List<Issue>) {
        if (list.isEmpty()) {
            pageableScrollListener.disabled = true
        }
        issuesAdapter.update(list)
    }
}