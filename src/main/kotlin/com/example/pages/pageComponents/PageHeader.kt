package com.example.pages.pageComponents

import com.example.pages.LogInPage
import com.example.pages.TestCasesPage
import com.example.pages.abstraction.AbstractElement
import com.example.pages.abstraction.AbstractPage
import com.example.tools.classes.Waiter
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

//Class that describes header of the page
class PageHeader : AbstractPage()
{
    private var elements : Elements = Elements()

    init
    {
        Waiter(webDriver).waitTillElementIsVisible(elements.webSiteLogo)
    }

    fun clickOnLogInButton() : LogInPage
    {
        elements.loginButton.click()
        return LogInPage()
    }

    fun clickOnTestCasesButton() : TestCasesPage
    {
        elements.testCasesButton.click()
        return TestCasesPage()
    }

    class Elements : AbstractElement()
    {
        @FindBy(xpath = "//img[@src='/static/images/home/logo.png']")
        lateinit var webSiteLogo : WebElement

        @FindBy(xpath = "//a[@href='/login']")
        lateinit var loginButton : WebElement

        @FindBy(xpath = "//a[@href='/test_cases']")
        lateinit var testCasesButton : WebElement
    }
}