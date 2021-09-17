package com.nytimesapp.samp.ui.fragment

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import com.nytimesapp.samp.R
import com.nytimesapp.samp.responsemodels.Media
import com.nytimesapp.samp.responsemodels.MediaMetadata
import com.nytimesapp.samp.responsemodels.Result
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class LatestArticlesTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun checkClickOnSingleArticle() {

        // setup nav controller to attach fragment to activity using nav controller
        val navController = mock(NavController::class.java)
        launchFragmentInHiltContainer<LatestArticleDetails> {
            Navigation.setViewNavController(requireView(), navController)
        }

        // create fake repository to pass data from list article fragment to detail article fragment
        val mediaMetadata = ArrayList<MediaMetadata>()
        mediaMetadata.add(
            MediaMetadata(
                "Standard Thumbnail",
                75,
                "https://static01.nyt.com/images/2021/09/01/multimedia/01virus-briefing-joe-rogan-01/01virus-briefing-joe-rogan-01-thumbStandard.jpg",
                75
            )
        )
        mediaMetadata.add(
            MediaMetadata(
                "mediumThreeByTwo210",
                140,
                "https://static01.nyt.com/images/2021/09/01/multimedia/01virus-briefing-joe-rogan-01/01virus-briefing-joe-rogan-01-mediumThreeByTwo210.jpg",
                210
            )
        )
        mediaMetadata.add(
            MediaMetadata(
                "mediumThreeByTwo440",
                293,
                "https://static01.nyt.com/images/2021/09/01/multimedia/01virus-briefing-joe-rogan-01/01virus-briefing-joe-rogan-01-mediumThreeByTwo440.jpg",
                440
            )
        )

        val media = ArrayList<Media>()
        media.add(
            Media(
                1,
                "Joe Rogan performing in August 2019 at the Ice House Comedy Club in Pasadena, Calif.",
                "Michael S. Schwartz/Getty Images",
                mediaMetadata,
                "photo",
                "image"
            )
        )

        val results = Result(
            "I got fevers, sweats, and I knew what was going on,” he said in a video on Instagram on Wednesday, after returning from a series of shows in Florida.",
            "",
            0,
            "By Alyssa Lukpat",
            "",
            listOf(),
            0,
            listOf(),
            0,
            media,
            "",
            listOf(),
            listOf(),
            "2021-09-01",
            "",
            "New York Times",
            "",
            "Joe Rogan, a podcasting giant who has been dismissive of vaccination, has Covid.",
            "Article",
            "",
            "nyt://article/918fdcdb-dfa6-58ec-86d4-77f11023f4d5",
            "https://www.nytimes.com/2021/09/01/business/joe-rogan-covid-19.html"

        )

        // setup click listener to test its working as expected
        onView(withId(R.id.rootSingleArticleLayout)).perform(click())
        verify(navController).navigate(
            LatestArticlesDirections.actionLatestArticlesToLatestArticleDetails(articleData = results)
        )
    }


}