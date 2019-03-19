/*
 * Created by Juan Albarracin on 19/03/19 14:25
 * Copyright (c) 2019. All right reserved.
 *
 * Last modified 19/03/19 14:25
 */

package com.jalbarracin.flexappealtest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions.close
import androidx.test.espresso.contrib.DrawerMatchers.isClosed
import androidx.test.espresso.contrib.DrawerMatchers.isOpen
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.jalbarracin.flexappealtest.controller.MainActivity
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityEspressoTest {

    @get:Rule
    val activity = ActivityTestRule(MainActivity::class.java)


    @Test
    fun clickSideMenuButton_opensDrawerLayout() {
        IdlingRegistry.getInstance().register(activity.activity.countingIdlingResource)
        onView(withId(R.id.sideMenuIconView)).perform(click())
        onView(withId(R.id.drawerLayout)).check(matches(isOpen()))
        onView(withId(R.id.drawerLayout)).perform(close()).check(matches(isClosed()))
    }

    @Test
    fun clickSearchButton_showsSearchEditText() {
        IdlingRegistry.getInstance().register(activity.activity.countingIdlingResource)
        onView(withId(R.id.searchIconView)).perform(click())
        onView(withId(R.id.searchEditText)).check(matches(isDisplayed()))
        onView(withId(R.id.backIconView)).perform(click())
        onView(withId(R.id.searchEditText)).check(matches(not(isDisplayed())))
    }

    @Test
    fun insertTextSearchEditText_clickSearchIconButton_showsDataListView() {
        IdlingRegistry.getInstance().register(activity.activity.countingIdlingResource)
        onView(withId(R.id.searchIconView)).perform(click())
        onView(withId(R.id.searchEditText)).perform(replaceText("reas"))
        onView(withId(R.id.searchIconView)).perform(click())
    }

    @Test
    fun swipeUpListView_showsMoreDataPageable() {
        IdlingRegistry.getInstance().register(activity.activity.countingIdlingResource)
        onView(withId(R.id.listView)).perform(swipeUp())
        onView(withId(R.id.listView)).perform(swipeUp())
        onView(withId(R.id.listView)).perform(swipeUp())
        onView(withId(R.id.listView)).perform(swipeUp())
        onView(withId(R.id.listView)).perform(swipeUp())
        onView(withId(R.id.listView)).perform(swipeUp())
    }

}