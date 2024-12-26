package com.example.gui

import com.example.data.Configuration
import com.example.data.TestData
import com.example.pages.AutomationExerciseMainPage
import com.example.pages.pageComponents.PageHeader
import com.example.tools.classes.Actions
import com.example.tools.classes.Settings
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestClass : BaseTest()
{
    lateinit var mainPage : AutomationExerciseMainPage
    lateinit var headerPage : PageHeader

    @BeforeEach
    fun setUpTest()
    {
        //Driver set up
        webDriver = Settings.driverInstall(Configuration.activeBrowser, Configuration.headlessMode)
        Settings.clearAllCookies(Configuration.isAllCookiesCleared)
        Settings.setPageLoadTimeout(Configuration.pageLoadTimeout)
        Settings.setImplicitlyWait(Configuration.implicitlyWait)
        Settings.setWindowMode(Configuration.windowMode)

        //initialize AutomationExercise main page, and open it in browser
        Actions(webDriver).openURL(TestData.url)
        headerPage = PageHeader()
        mainPage = AutomationExerciseMainPage(headerPage)
    }

    @Test
    fun testCase3()
    {
        //Main page is visible
        Assertions.assertTrue(
            mainPage
                .mainPageISVisible()
        )
        //Try to log in with invalid email and check the error message
        Assertions.assertTrue(
            mainPage.header
                .clickOnLogInButton()
                .enterEmailInLogInInput("12345@gmail")
                .enterPasswordInLogInInput("123456")
                .clickOnLogInButton()
                .invalidEmailOrPasswordMessageIsVisible())
    }

    @Test
    fun testCase7()
    {
        //Main page is visible
        Assertions.assertTrue(
            mainPage
                .mainPageISVisible()
        )
        //Navigate to "Test cases" page and check that it is visible
        Assertions.assertTrue(
            mainPage.header
                .clickOnTestCasesButton()
                .testCaseContainerIsVisible())
    }

    //Arrow button is covered by add iframe, do not know how to solve it
    @Test
    fun textCase25()
    {
        //Main page is visible
        Assertions.assertTrue(
            mainPage
                .mainPageISVisible()
        )
        //Scroll page to footer and check that "Subscription" title is visible
        Assertions.assertTrue(
            mainPage
            .scrollToSubscriptionHeader()
            .clickOnArrow()
            .bannerTextIsVisible()
            .first)
    }

    @Test
    fun textCase26()
    {
        //Main page is visible
        Assertions.assertTrue(
            mainPage
                .mainPageISVisible()
        )
        //Check that "Subscription" header is visible
        Assertions.assertTrue(
            mainPage
                .scrollToSubscriptionHeader()
                .subscriptionHeaderIsVisible()
                .first
        )
        //Check that "Full-Fledged practice website for Automation Engineers" title is visible
        Assertions.assertTrue(
            mainPage
                .scrollToBannerText()
                .bannerTextIsVisible()
                .first
        )
    }

    @AfterEach
    fun closeDriver()
    {
        webDriver.quit()
    }
}