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
        Assertions.assertTrue(
            mainPage.header
                .clickOnTestCasesButton()
                .testCaseContainerIsVisible())
    }

    @AfterEach
    fun closeDriver()
    {
        webDriver.quit()
    }
}