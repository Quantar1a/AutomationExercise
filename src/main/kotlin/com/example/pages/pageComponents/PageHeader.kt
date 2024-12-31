package com.example.pages.pageComponents

import com.example.pages.ContactUsPage
import com.example.pages.InformationalPage
import com.example.pages.LogInPage
import com.example.pages.TestCasesPage
import com.example.pages.abstraction.AbstractElement
import com.example.pages.abstraction.AbstractPage
import io.qameta.allure.Step
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

//Class that describes header of the page
class PageHeader : AbstractPage()
{
    private var elements : Elements = Elements()

    init
    {
        this.waitTillElementIsVisible(elements.webSiteLogo)
    }

    @Step("Click on 'Signup / Login' button")
    fun clickOnLogInButton() : LogInPage
    {
        elements.loginButton.click()
        return LogInPage(this, PageFooter())
    }

    @Step("Click on 'Test Cases' button")
    fun clickOnTestCasesButton() : TestCasesPage
    {
        elements.testCasesButton.click()
        return TestCasesPage(this, PageFooter())
    }

    @Step("Verify that 'Logged in as username' is visible")
    fun loggedInAsAUserTextIsVisible() : Boolean
    {
        return elements.loggedInAsUserText.isDisplayed
    }

    @Step("Click 'Delete Account' button")
    fun clickOnDeleteAccountButton() : InformationalPage
    {
        elements.deleteAccountButton.click()
        return InformationalPage(this, PageFooter())
    }

    @Step("Click 'Logout' button")
    fun logoutButtonClick() : LogInPage
    {
        elements.logoutButton.click()
        return LogInPage(this, PageFooter())
    }

    @Step("Click on 'Contact Us' button")
    fun clickOnContactUsButton() : ContactUsPage
    {
        elements.contactUsButton.click()
        return ContactUsPage(this, PageFooter())
    }

    class Elements : AbstractElement()
    {
        @FindBy(xpath = "//img[@src='/static/images/home/logo.png']")
        lateinit var webSiteLogo : WebElement

        @FindBy(xpath = "//a[@href='/login']")
        lateinit var loginButton : WebElement

        @FindBy(xpath = "//a[@href='/test_cases']")
        lateinit var testCasesButton : WebElement

        @FindBy(xpath = "//a[text()=' Logged in as ']")
        lateinit var loggedInAsUserText : WebElement

        @FindBy(xpath = "//a[text()=' Delete Account']")
        lateinit var deleteAccountButton : WebElement

        @FindBy(xpath = "//a[@href='/logout']")
        lateinit var logoutButton : WebElement

        @FindBy(xpath = "//a[@href='/contact_us']")
        lateinit var contactUsButton : WebElement
    }
}