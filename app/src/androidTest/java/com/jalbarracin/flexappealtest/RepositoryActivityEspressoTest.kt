package com.jalbarracin.flexappealtest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.jalbarracin.flexappealtest.controller.RepositoryActivity
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class RepositoryActivityEspressoTest {

    @get:Rule
    val activity = ActivityTestRule(RepositoryActivity::class.java)

//    @get:Rule
//    var activity: ActivityTestRule<RepositoryActivity> =
//        object : ActivityTestRule<RepositoryActivity>(RepositoryActivity::class.java) {
//            override fun getActivityIntent(): Intent {
//                val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
//                val result = Intent(targetContext, MainActivity::class.java)
//                result.putExtra("repository", Repository())
//                return result
//            }
//        }

    @Test
    fun dosomething() {
        // todo implement
        onView(withId(R.id.backIconView)).check(matches(not(isDisplayed())))
//        onView(withId(R.id.listView)).perform(swipeUp())
    }

}