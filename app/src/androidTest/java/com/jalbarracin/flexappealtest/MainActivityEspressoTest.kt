package com.jalbarracin.flexappealtest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
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
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityEspressoTest {

    @get:Rule
    val activity = ActivityTestRule(MainActivity::class.java)

//    @Before
//    fun launchActivity() {
//        ActivityScenario.launch(MainActivity::class.java)
//    }

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
//        onView(withId(R.id.searchEditText)).check(matches(isClosed()))
    }

//    @Test
//    fun testAdd() {
//        IdlingRegistry.getInstance().register(activity.activity.countingIdlingResource)

//        onView(withId(R.id.drawerLayout))
//            .perform(DrawerActions.open())
//            .check(matches(DrawerMatchers.isOpen()))

//        onView(withId(R.id.sideMenuIconView)).perform(click())
//        onView(withId(R.id.drawerLayout)).check(ViewAssertions.matches(isOpen()))
//        pressBack()
//        onView(withId(R.id.searchIconView)).perform(click())

//        onView(withId(R.id.backIconView)).perform(click())
//        onView(withId(R.id.searchIconView)).perform(click())
//        onView(withId(R.id.searchEditText)).perform(replaceText("react"))
//        onView(withId(R.id.searchIconView)).perform(click())



//        Espresso.onView(ViewMatchers.withId(R.id.searchIconView)).perform(ViewActions.click())
//        Espresso.onView(ViewMatchers.withId(R.id.backIconView)).perform(ViewActions.click())


//        Espresso.onView(ViewMatchers.withId(R.id.searchEditText))
//            .check(
//                ViewAssertions.matches(
//                    ViewMatchers.withEffectiveVisibility(
//                        ViewMatchers.Visibility.VISIBLE)))
//        R.id.searchEditText.

//    }

//    private fun clickOutsideDrawer(
//        parentDrawerLayout: View, @LayoutRes drawId: Int) {
//        onView(withId(drawId))
//            .perform(
//                CoordinatesClickViewAction.clickOnCoordinates(
//                    parentDrawerLayout.x + parentDrawerLayout.width + 10,
//                    parentDrawerLayout.height / 2f))
//    }

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