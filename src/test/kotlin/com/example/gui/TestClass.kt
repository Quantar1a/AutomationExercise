package com.example.gui

import com.example.data.Configuration
import com.example.data.TestData
import com.example.pages.AutomationExerciseMainPage
import com.example.pages.pageComponents.PageFooter
import com.example.pages.pageComponents.PageHeader
import com.example.tools.classes.Actions
import com.example.tools.classes.Settings
import io.qameta.allure.Description
import org.junit.jupiter.api.*

@TestMethodOrder(MethodOrderer::class)
class TestClass : BaseTest()
{
    lateinit var mainPage: AutomationExerciseMainPage

    @BeforeEach
    fun setUpTest()
    {
        //Driver set up
        webDriver = Settings.driverInstall()
        Settings.clearAllCookies(Configuration.isAllCookiesCleared)
        Settings.setPageLoadTimeout(Configuration.pageLoadTimeout)
        Settings.setImplicitlyWait(Configuration.implicitlyWait)
        Settings.setWindowMode(Configuration.windowMode)

        //initialize AutomationExercise main page, and open it in browser
        Actions(webDriver).openURL(TestData.url)
        mainPage = AutomationExerciseMainPage(PageHeader(), PageFooter())

        //switch to the extension page and close it
        val windowHandles : ArrayList<String> = ArrayList(webDriver.windowHandles)

        webDriver.switchTo().window(windowHandles[1])
        webDriver.close()

        //go to primary page
        webDriver.switchTo().window(windowHandles[0])
    }

    @Test
    @Order(1)
    @DisplayName("Test Case 1: Register User")
    @Description("Register new user in the system")
    fun testCase1()
    {
        mainPage
            .verifyThatMainPageISVisible()
            .header.logInButtonClick()
            .verifyThatNewUserSignUpTitleIsVisible()
            .signUpWithValidData(TestData.customer.firstName, TestData.customer.email)
            .verifyThatPageTitleIsVisible()
            .fillInUserDetails(TestData.customer, TestData.password)
            .singUpForNewsLettersCheckBoxSelection()
            .receiveSpecialOffersCheckBoxSelection()
            .fillInUserPlaceDetails(TestData.customer)
            .createAccountButtonClick()
            .verifyThatAccountCreatedTitleIsVisible()
            .continueButtonClick()
            .header
            .verifyThatLoggedInAsAUserTextIsVisible()
            .deleteAccountButtonClick()
            .verifyThatAccountDeletedTitleIsVisible()
    }

    @Test
    @Order(2)
    @DisplayName("Test Case 2: Login User with correct email and password")
    @Description("Login in the system with valid data")
    fun testCase2()
    {
        mainPage
            .verifyThatMainPageISVisible()
            .header.logInButtonClick()
            .verifyThatLogInToYourAccountHeaderIsVisible()
            .logInWithValidData(TestData.email, TestData.password)
            .header
            .verifyThatLoggedInAsAUserTextIsVisible()
            .logOutButtonClick()
    }

    @Test
    @Order(3)
    @DisplayName("Test Case 3: Login User with incorrect email and password")
    @Description("Attempt to login in the system with invalid data")
    fun testCase3()
    {
        mainPage
            .verifyThatMainPageISVisible()
            .header
            .logInButtonClick()
            .verifyThatLogInToYourAccountHeaderIsVisible()
            .logInWithInvalidData("123123@gmai", TestData.password)
            .verifyThatInvalidEmailOrPasswordMessageIsVisible()
    }

    @Test
    @Order(4)
    @DisplayName("Test Case 4: Logout User")
    @Description("Log out user from the system")
    fun testCase4()
    {
        mainPage
            .verifyThatMainPageISVisible()
            .header
            .logInButtonClick()
            .verifyThatLogInToYourAccountHeaderIsVisible()
            .logInWithValidData(TestData.email, TestData.password)
            .header
            .verifyThatLoggedInAsAUserTextIsVisible()
            .logOutButtonClick()
            .verifyThatLogInToYourAccountHeaderIsVisible()
    }

    @Test
    @Order(5)
    @DisplayName("Test Case 5: Register User with existing email")
    @Description("Try to register the user with already registered email " +
            "amd check the error message")
    fun testCase5()
    {
        mainPage
            .verifyThatMainPageISVisible()
            .header
            .logInButtonClick()
            .verifyThatNewUserSignUpTitleIsVisible()
            .signUpWithInvalidData(TestData.customer.firstName, TestData.email)
            .verifyThatEmailAddressAlreadyExistsIsVisible()
    }

    @Test
    @Order(6)
    @DisplayName("Test Case 6: Contact Us Form")
    @Description("Go to \"Contact us\" form, fill it, and send the message")
    fun testCase6()
    {
        mainPage
            .verifyThatMainPageISVisible()
            .header
            .contactUsButtonClick()
            .verifyThatGetInTouchIsVisible()
            .enterNameEmailSubjectMessage(TestData.message)
            .uploadFile(TestData.message.file)
            .submitButtonClick()
            .okButtonClickOnAlert()
            .verifyThatSuccessMessageIsVisible()
            .homeButtonClick()
    }

    @Test
    @Order(7)
    @DisplayName("Test Case 7: Verify Test Cases Page")
    @Description("Check that the page with test cases is displayed after moving to it")
    fun testCase7()
    {
        mainPage
            .verifyThatMainPageISVisible()
            .header
            .testCasesButtonClick()
            .verifyThatTestCasesPageIsVisible()
    }

    @Test
    @Order(10)
    @DisplayName("Test Case 10: Verify Subscription in home page")
    @Description("Check that user can subscribe to a newsletters from main page")
    fun testCase10()
    {
        mainPage
            .verifyThatMainPageISVisible()
            .footer
            .verifyThatSubscriptionHeaderIsVisible()
            .scrollToFooter()
            .verifyThatSubscriptionHeaderIsVisible()
            .subscribeToNewsLetters(TestData.customer.email)
            .verifyThatYouHaveBeenSuccessfullySubscribedIsVisible()
    }

    @Test
    @Order(11)
    @DisplayName("Test Case 11: Verify Subscription in Cart page")
    @Description("Check that user can subscribe to a newsletters from cart page")
    fun testCase11()
    {
        mainPage
            .verifyThatMainPageISVisible()
            .header
            .cartButtonClick()
            .footer
            .scrollToFooter()
            .verifyThatSubscriptionHeaderIsVisible()
            .subscribeToNewsLetters(TestData.customer.email)
            .verifyThatYouHaveBeenSuccessfullySubscribedIsVisible()
    }

    @Test
    @Order(25)
    @DisplayName("Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality")
    @Description("Scroll page to the footer, check that \"Subscription\" title is displayed, " +
            "and move to the top by clicking on arrow button")
    fun textCase25()
    {
        mainPage
            .verifyThatMainPageISVisible()
            .footer
            .scrollToFooter()
            .verifyThatSubscriptionHeaderIsVisible()
        mainPage
            .arrowButtonClick()
            .verifyThatBannerTextIsVisible()
    }

    @Test
    @Order(26)
    @DisplayName("Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality")
    @Description("Scroll page to the footer, check that \"Subscription\" title is displayed, " +
            "and move to the top by scrolling it manually")
    fun textCase26()
    {
        mainPage
            .verifyThatMainPageISVisible()
            .footer
            .scrollToFooter()
            .verifyThatSubscriptionHeaderIsVisible()
        mainPage
            .scrollUpToBanner()
            .verifyThatBannerTextIsVisible()
    }

    @AfterEach
    fun closeDriver()
    {
        webDriver.quit()
    }
}