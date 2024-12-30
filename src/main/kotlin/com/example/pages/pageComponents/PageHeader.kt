package com.example.pages.pageComponents

import com.example.pages.ContactUsPage
import com.example.pages.InformationalPage
import com.example.pages.LogInPage
import com.example.pages.TestCasesPage
import com.example.pages.abstraction.AbstractElement
import com.example.pages.abstraction.AbstractPage
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

    fun clickOnLogInButton() : LogInPage
    {
        elements.loginButton.click()
        return LogInPage(this, PageFooter())
    }

    fun clickOnTestCasesButton() : TestCasesPage
    {
        elements.testCasesButton.click()
        return TestCasesPage(this, PageFooter())
    }

    fun loggedInAsAUserTextIsVisible() : Boolean
    {
        return elements.loggedInAsUserText.isDisplayed
    }

    fun clickOnDeleteAccountButton() : InformationalPage
    {
        elements.deleteAccountButton.click()
        return InformationalPage(this, PageFooter())
    }

    fun logoutButtonClick() : LogInPage
    {
        elements.logoutButton.click()
        return LogInPage(this, PageFooter())
    }

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