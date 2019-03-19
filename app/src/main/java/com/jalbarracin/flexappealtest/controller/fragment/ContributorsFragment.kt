package com.jalbarracin.flexappealtest.controller.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jalbarracin.flexappealtest.R
import com.jalbarracin.flexappealtest.controller.adapter.ContributorsAdapter
import com.jalbarracin.flexappealtest.controller.listener.PaginableScrollListener
import com.jalbarracin.flexappealtest.model.Owner
import com.jalbarracin.flexappealtest.service.GithubRetrofit
import kotlinx.android.synthetic.main.fragment_contributors.*


class ContributorsFragment: Fragment() {

    lateinit var contributorsAdapter: ContributorsAdapter
    lateinit var paginableScrollListener: PaginableScrollListener


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_contributors, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        contributorsAdapter = ContributorsAdapter(activity!!, ArrayList())
        listView.adapter = contributorsAdapter
        paginableScrollListener = object : PaginableScrollListener() {
            override fun loadData(offset: Int) {
                GithubRetrofit.getContributors(this@ContributorsFragment, offset)
            }
        }
        listView.setOnScrollListener(paginableScrollListener)
        GithubRetrofit.getContributors(this)
    }

    fun updateListView(list: List<Owner>) {
        if (list.isEmpty()) {
            paginableScrollListener.disabled = true
        }
        contributorsAdapter.update(list)
    }

}