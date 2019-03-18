package com.jalbarracin.flexappealtest.controller

import android.graphics.Typeface
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.jalbarracin.flexappealtest.controller.adapter.CustomPagerAdapter
import com.jalbarracin.flexappealtest.controller.fragment.ContributorsFragment
import com.jalbarracin.flexappealtest.controller.fragment.DetailsFragment
import com.jalbarracin.flexappealtest.controller.fragment.IssuesFragment
import kotlinx.android.synthetic.main.activity_repository.*


class RepositoryActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.jalbarracin.flexappealtest.R.layout.activity_repository)
        configureViews()
    }

    private fun configureViews() {
        typefaceCondensed(tabLayout)
        val fragments = ArrayList<Fragment>()
        fragments.add(DetailsFragment())
        fragments.add(ContributorsFragment())
        fragments.add(IssuesFragment())
        viewPager.adapter = CustomPagerAdapter(supportFragmentManager, fragments)
        tabLayout.addOnTabSelectedListener(CustomOnTabSelectedListener(viewPager))
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
    }

    private fun typefaceCondensed(tabLayout: TabLayout) {
        val vg = tabLayout.getChildAt(0) as ViewGroup
        val tabsCount = vg.childCount
        for (j in 0 until tabsCount) {
            val vgTab = vg.getChildAt(j) as ViewGroup
            val tabChildsCount = vgTab.childCount
            for (i in 0 until tabChildsCount) {
                val tabViewChild = vgTab.getChildAt(i)
                if (tabViewChild is TextView) {
                    tabViewChild.typeface = Typeface.create("sans-serif-condensed", Typeface.NORMAL)
                }
            }
        }
    }
}