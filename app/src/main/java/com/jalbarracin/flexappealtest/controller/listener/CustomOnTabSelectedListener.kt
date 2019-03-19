/*
 * Created by Juan Albarracin on 19/03/19 14:25
 * Copyright (c) 2019. All right reserved.
 *
 * Last modified 19/03/19 14:25
 */

package com.jalbarracin.flexappealtest.controller.listener

import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class CustomOnTabSelectedListener(
    var viewPager: ViewPager
): TabLayout.OnTabSelectedListener {

    override fun onTabSelected(tab: TabLayout.Tab) {
        viewPager.currentItem = tab.position
    }

    override fun onTabReselected(tab: TabLayout.Tab) { }

    override fun onTabUnselected(tab: TabLayout.Tab) { }

}