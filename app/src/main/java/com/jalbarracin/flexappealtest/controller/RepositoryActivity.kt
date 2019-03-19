/*
 * Created by Juan Albarracin on 19/03/19 14:25
 * Copyright (c) 2019. All right reserved.
 *
 * Last modified 19/03/19 14:25
 */

package com.jalbarracin.flexappealtest.controller

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.jalbarracin.flexappealtest.controller.adapter.CustomPagerAdapter
import com.jalbarracin.flexappealtest.controller.fragment.ContributorsFragment
import com.jalbarracin.flexappealtest.controller.fragment.DetailsFragment
import com.jalbarracin.flexappealtest.controller.fragment.IssuesFragment
import com.jalbarracin.flexappealtest.controller.listener.CustomOnTabSelectedListener
import com.jalbarracin.flexappealtest.model.Repository
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_repository.*
import kotlinx.android.synthetic.main.include_header.*


class RepositoryActivity: AppCompatActivity() {

    lateinit var compositeDisposable: CompositeDisposable
    lateinit var repository: Repository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.jalbarracin.flexappealtest.R.layout.activity_repository)
        repository = intent.getSerializableExtra(Repository.KEY) as Repository
        compositeDisposable = CompositeDisposable()
        configureViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    private fun configureViews() {
        typefaceCondensed(tabLayout)
        val fragments = ArrayList<Fragment>()
        fragments.add(DetailsFragment())
        fragments.add(ContributorsFragment())
        fragments.add(IssuesFragment())
        viewPager.adapter = CustomPagerAdapter(supportFragmentManager, fragments)
        viewPager.offscreenPageLimit = 2
        tabLayout.addOnTabSelectedListener(
            CustomOnTabSelectedListener(
                viewPager
            )
        )
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        searchIconView.visibility = View.INVISIBLE
        sideMenuIconView.visibility = View.GONE
        backIconView.visibility = View.VISIBLE
        backIconView.setOnClickListener {
            onBackPressed()
        }
    }

    private fun typefaceCondensed(tabLayout: TabLayout) {
        val vg = tabLayout.getChildAt(0) as ViewGroup
        val tabsCount = vg.childCount
        for (j in 0 until tabsCount) {
            val vgTab = vg.getChildAt(j) as ViewGroup
            val tabChildCount = vgTab.childCount
            for (i in 0 until tabChildCount) {
                val tabViewChild = vgTab.getChildAt(i)
                if (tabViewChild is TextView) {
                    tabViewChild.typeface = Typeface.create("sans-serif-condensed", Typeface.NORMAL)
                }
            }
        }
    }
}