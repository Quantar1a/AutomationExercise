package com.example.pages

import com.example.pages.abstraction.AbstractElement
import com.example.pages.abstraction.AbstractPage
import com.example.pages.pageComponents.PageFooter
import com.example.pages.pageComponents.PageHeader
import com.example.tools.classes.Waiter
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

//Class for Login or Sing in page
class LogInPage(
    var header: PageHeader,
    var footer : PageFooter
) : AbstractPage()
{
    private var elements : Elements = Elements()

    init
    {
        Waiter(webDriver).waitTillElementIsVisible(elements.loginForm)
    }

    fun enterEmailInLogInInput(email : String) : LogInPage
    {
        elements.logInEmailInput.sendKeys(email)
        return this
    }

    fun enterPasswordInLogInInput(password : String) : LogInPage
    {
        elements.logInPasswordInput.sendKeys(password)
        return this
    }

    fun clickOnLogInButton() : LogInPage
    {
        elements.logInButton.click()
        return this
    }

    fun invalidEmailOrPasswordMessageIsVisible() : Boolean
    {
        return Waiter(webDriver)
            .waitTillElementIsVisible(elements.invalidEmailOrPasswordMessage)
            .isDisplayed
    }


    class Elements : AbstractElement()
    {
        @FindBy(className = "login-form")
        lateinit var loginForm : WebElement

        @FindBy(xpath = "//div[@class='login-form']//input[@type='email']")
        lateinit var logInEmailInput : WebElement

        @FindBy(xpath = "//div[@class='login-form']//input[@type='password']")
        lateinit var logInPasswordInput : WebElement

        @FindBy(xpath = "//button[@data-qa='login-button']")
        lateinit var logInButton : WebElement

        @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
        lateinit var invalidEmailOrPasswordMessage : WebElement
    }
}