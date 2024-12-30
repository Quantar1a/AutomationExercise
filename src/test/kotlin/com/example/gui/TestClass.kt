package com.example.gui

import com.example.data.Configuration
import com.example.data.TestData
import com.example.pages.AutomationExerciseMainPage
import com.example.pages.pageComponents.PageFooter
import com.example.pages.pageComponents.PageHeader
import com.example.tools.classes.Actions
import com.example.tools.classes.Settings
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestClass : BaseTest()
{
    lateinit var mainPage: AutomationExerciseMainPage

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
        mainPage = AutomationExerciseMainPage(PageHeader(), PageFooter())
    }

    @Test
    fun testCase1()
    {
        //Main page is visible
        Assertions.assertTrue(
            mainPage
                .mainPageISVisible())

        //"New User Signup!" title is visible
        val (logInTitleIsVisible, logInPage) =
            mainPage
                .header
                .clickOnLogInButton()
                .newUserSignUpTitleIsVisible()
        Assertions.assertTrue(logInTitleIsVisible)

        //"Enter Account Information" title is visible
        val (registerTitleIsVisible, registerPage) =
            logInPage
                .signIn(TestData.customer.firstName, TestData.customer.email)
                .checkThatPageTitleIsVisible()

        Assertions.assertTrue(registerTitleIsVisible)

        //Register the user, and check that "Account Created!" title is visible
        val informationalPage =
            registerPage
                .enterAccountInformation(
                    TestData.customer,
                    TestData.password,
                    newsLetterSubscription = true,
                    specialOffersSubscription = true)
                .enterAddressInformation(TestData.customer)
                .createAnAccount()

        Assertions.assertTrue(
            informationalPage
                .accountCreatedTitleIsVisible())

        //"Logged as a User" text is visible
        Assertions.assertTrue(
            informationalPage
                .clickOnContinueButton()
                .header
                .loggedInAsAUserTextIsVisible())

        //Click on "Delete account" button and check that "Account deleted" is visible
        val (accountDeletedIsVisible, infoPage) =
            mainPage.header
                .clickOnDeleteAccountButton()
                .accountDeletedTitleIsVisible()
        Assertions.assertTrue(accountDeletedIsVisible)

        //Check that user have returned to main page
        Assertions.assertTrue(
            infoPage
                .clickOnContinueButton()
                .mainPageISVisible())
    }

    @Test
    fun testcase2()
    {
        //Main page is visible
        Assertions.assertTrue(
            mainPage
                .mainPageISVisible())

        //"Log in to your account" is visible
        var (logInToYourAccountIsVisible, logInPage) =
            mainPage
                .header
                .clickOnLogInButton()
                .logInToYourAccountHeaderIsVisible()
        Assertions.assertTrue(logInToYourAccountIsVisible)

        //"Logged in as a user" test is visible
        Assertions.assertTrue(
            logInPage
                .logInWithValidData(TestData.email, TestData.password)
                .header
                .loggedInAsAUserTextIsVisible())

        //Logout
        mainPage
            .header
            .logoutButtonClick()
    }

    @Test
    fun testCase3()
    {
        //Main page is visible
        Assertions.assertTrue(
            mainPage
                .mainPageISVisible())
        //Try to log in with invalid email and check the error message
        Assertions.assertTrue(
            mainPage.header
                .clickOnLogInButton()
                .logInWithInvaliData("12345@gmail.com", "123456")
                .invalidEmailOrPasswordMessageIsVisible())
    }

    @Test
    fun testCase4()
    {
        //Main page is visible
        Assertions.assertTrue(
            mainPage
                .mainPageISVisible())

        //"Log in to your account" is visible
        var (logInToYourAccountIsVisible, logInPage) =
            mainPage
                .header
                .clickOnLogInButton()
                .logInToYourAccountHeaderIsVisible()
        Assertions.assertTrue(logInToYourAccountIsVisible)

        //"Logged in as a user" test is visible
        Assertions.assertTrue(
            logInPage
                .logInWithValidData(TestData.email, TestData.password)
                .header
                .loggedInAsAUserTextIsVisible())

        //Logout and check that the LogIn page is visible
        Assertions.assertTrue(
            mainPage
            .header
            .logoutButtonClick().logInToYourAccountHeaderIsVisible()
            .first)
    }

    @Test
    fun testCase5()
    {
        //Main page is visible
        Assertions.assertTrue(
            mainPage
                .mainPageISVisible())

        //"New User Signup!" title is visible
        val (logInTitleIsVisible, logInPage) =
            mainPage
                .header
                .clickOnLogInButton()
                .newUserSignUpTitleIsVisible()
        Assertions.assertTrue(logInTitleIsVisible)

        //"Email already exists" error message is visible
        Assertions.assertTrue(logInPage
            .signInWithInvalidData("Anna", TestData.email)
            .emailAddressAlreadyExistsIsVisible())
    }

    @Test
    fun testCase6()
    {
        //Main page is visible
        Assertions.assertTrue(
            mainPage
                .mainPageISVisible())

        //
        var (getInTouchTitleIsVisible, contactUsPage) =
        mainPage
            .header
            .clickOnContactUsButton()
            .getInTouchTitleIsVisible()
        Assertions.assertTrue(getInTouchTitleIsVisible)

        //"Success! Your details have been submitted successfully." message is displayed
        Assertions.assertTrue(
            contactUsPage
                .sendAMessage(TestData.message)
                .submitAlert()
                .successMessageISVisible())

        //Click on "Home" button and check that home page is visible
        Assertions.assertTrue(
            contactUsPage
                .clickOnHomeButton()
                .mainPageISVisible())
    }

    @Test
    fun testCase7()
    {
        //Main page is visible
        Assertions.assertTrue(
            mainPage
                .mainPageISVisible())

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
                .mainPageISVisible())

        //Scroll page to footer and check that "Subscription" title is visible
        Assertions.assertTrue(
            mainPage
                .footer
                .scrollToSubscriptionHeader()
                .subscriptionHeaderIsVisible())

        //Click on arrow button and check that the text on the banner is visible
        Assertions.assertTrue(
            mainPage
                .clickOnArrow()
                .bannerTextIsVisible())
    }

    @Test
    fun textCase26()
    {
        //Main page is visible
        Assertions.assertTrue(
            mainPage
                .mainPageISVisible())

        //Check that "Subscription" header is visible
        Assertions.assertTrue(
            mainPage
                .footer
                .scrollToSubscriptionHeader()
                .subscriptionHeaderIsVisible())

        //Check that "Full-Fledged practice website for Automation Engineers" title is visible
        Assertions.assertTrue(
            mainPage
                .scrollToBannerText()
                .bannerTextIsVisible())
        
    }

    @AfterEach
    fun closeDriver()
    {
        webDriver.quit()
    }
}