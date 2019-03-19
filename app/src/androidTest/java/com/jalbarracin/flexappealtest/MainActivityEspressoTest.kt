package com.jalbarracin.flexappealtest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.jalbarracin.flexappealtest.controller.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityEspressoTest {

    @get:Rule
    val activity = ActivityTestRule(MainActivity::class.java)


    @Test
    fun testAdd() {
        IdlingRegistry.getInstance().register(activity.activity.countingIdlingResource)
        onView(withId(R.id.sideMenuIconView)).perform(click())
        pressBack()
        onView(withId(R.id.searchIconView)).perform(click())
        onView(withId(R.id.backIconView)).perform(click())
        onView(withId(R.id.searchIconView)).perform(click())



//        Espresso.onView(ViewMatchers.withId(R.id.searchIconView)).perform(ViewActions.click())
//        Espresso.onView(ViewMatchers.withId(R.id.backIconView)).perform(ViewActions.click())


//        Espresso.onView(ViewMatchers.withId(R.id.searchEditText))
//            .check(
//                ViewAssertions.matches(
//                    ViewMatchers.withEffectiveVisibility(
//                        ViewMatchers.Visibility.VISIBLE)))
//        R.id.searchEditText.

    }

//    @Test
//    fun intentTest() {
//        var intent = Intent()
//        intent.putExtra("repository", Repository())
//        activity.launchActivity(intent)
//    }
//
//    @Test
//    fun intentTest() {
//        var idlingResource: IdlingResource = OkHttpClient
////        IdlingResource idlingResource = OkHttp3IdlingResource.create(
////                "okhttp", OkHttpProvider.getOkHttpInstance());
////        IdlingRegistry.getInstance().register(idlingResource);
////
////        ...
////
////        IdlingRegistry.getInstance().unregister(idlingResource);
//    }

}