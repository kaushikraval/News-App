package com.nytimesapp.samp

import androidx.test.core.app.launchActivity
import com.nytimesapp.samp.ui.activity.MainActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class UiTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init() {
        hiltRule.inject()
    }

    // test to check main activity properly attached and running
    @Test
    fun mainActivityTest() {
        val scenario = launchActivity<MainActivity>()
    }

}