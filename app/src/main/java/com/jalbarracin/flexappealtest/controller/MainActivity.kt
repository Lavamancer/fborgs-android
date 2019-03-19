/*
 * Created by Juan Albarracin on 19/03/19 14:25
 * Copyright (c) 2019. All right reserved.
 *
 * Last modified 19/03/19 14:25
 */

package com.jalbarracin.flexappealtest.controller

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.test.espresso.idling.CountingIdlingResource
import com.jalbarracin.flexappealtest.controller.adapter.RepositoryAdapter
import com.jalbarracin.flexappealtest.controller.listener.PageableScrollListener
import com.jalbarracin.flexappealtest.model.Repository
import com.jalbarracin.flexappealtest.service.GithubRetrofit
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_header.*




class MainActivity : AppCompatActivity() {

    var countingIdlingResource = CountingIdlingResource("DATA_LOADER")
    lateinit var compositeDisposable: CompositeDisposable
    lateinit var repositoryAdapter: RepositoryAdapter
    lateinit var pageableScrollListener: PageableScrollListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.jalbarracin.flexappealtest.R.layout.activity_main)
        compositeDisposable = CompositeDisposable()
        configureViews()
        GithubRetrofit.getSearch(this, true)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }


    private fun configureViews() {
        configureHeader()
        repositoryAdapter = RepositoryAdapter(this, ArrayList())
        listView.adapter = repositoryAdapter
        pageableScrollListener = object: PageableScrollListener() {
            override fun loadData(offset: Int) {
                GithubRetrofit.getSearch(this@MainActivity, false, offset, repositoryAdapter.searchText)
            }
        }
        listView.setOnScrollListener(pageableScrollListener)
    }

    fun configureHeader() {
        sideMenuIconView.setOnClickListener {
            drawerLayout.openDrawer(Gravity.LEFT)
        }

        searchIconView.setOnClickListener {
            if (titleLinearLayout.visibility == View.VISIBLE) {
                titleLinearLayout.visibility = View.GONE
                searchRelativeLayout.visibility = View.VISIBLE
                searchEditText.text.clear()
                repositoryAdapter.searchText = null
                backIconView.visibility = View.VISIBLE
                sideMenuIconView.visibility = View.GONE
                searchEditText.requestFocus()
                val inputMethodService = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodService.showSoftInput(searchEditText, InputMethodManager.SHOW_IMPLICIT)
            } else {
                val searchText: String = searchEditText.text.toString()
                if (searchText.isEmpty()) {
//                    Toast.makeText(this, "Please, insert text", Toast.LENGTH_SHORT).show()
                } else {
                    repositoryAdapter.clear()
                    repositoryAdapter.searchText = searchText
                    pageableScrollListener.clear()
                    GithubRetrofit.getSearch(this, true,0, searchText)
                }
            }
        }

        backIconView.setOnClickListener {
            titleLinearLayout.visibility = View.VISIBLE
            searchRelativeLayout.visibility = View.GONE
            backIconView.visibility = View.GONE
            sideMenuIconView.visibility = View.VISIBLE
            val inputMethodService = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodService.hideSoftInputFromWindow(searchEditText.windowToken, 0)
            if (repositoryAdapter.searchText != null) {
                repositoryAdapter.clear()
                repositoryAdapter.searchText = null
                pageableScrollListener.clear()
                GithubRetrofit.getSearch(this, true)
            }
        }

        searchEditText.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    searchIconView.performClick()
                    return true
                }
                return false
            }
        })
    }

    fun updateListView(result: List<Repository>, totalCount: Int, newSearch: Boolean) {
        noResultsIconView.visibility = if (result.isEmpty()) View.VISIBLE else View.GONE
        listView.visibility = if (result.isEmpty()) View.GONE else View.VISIBLE

        if (newSearch) {
            repositoryAdapter.refresh(result)
        } else {
            repositoryAdapter.update(result)
        }

        if (totalCount == repositoryAdapter.list.size) {
            pageableScrollListener.disabled = true
        }
        countingIdlingResource.decrement()
    }

}