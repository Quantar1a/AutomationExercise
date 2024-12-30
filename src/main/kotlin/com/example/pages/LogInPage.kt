package com.example.pages

import com.example.pages.abstraction.AbstractElement
import com.example.pages.abstraction.AbstractPage
import com.example.pages.pageComponents.PageFooter
import com.example.pages.pageComponents.PageHeader
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
        this.waitTillElementIsVisible(elements.loginForm)
    }

    private fun logIn(email : String, password : String)
    {
        elements.logInEmailInput.sendKeys(email)
        elements.logInPasswordInput.sendKeys(password)
        elements.logInButton.click()
    }


    fun logInWithValidData(email : String, password : String) : AutomationExerciseMainPage
    {
        this.logIn(email, password)
        return AutomationExerciseMainPage(header, footer)
    }

    fun logInWithInvaliData(email : String, password : String) : LogInPage
    {
        this.logIn(email, password)
        return this
    }

    fun invalidEmailOrPasswordMessageIsVisible() : Boolean
    {
        return this
            .waitTillElementIsVisible(elements.invalidEmailOrPasswordMessage)
            .isDisplayed
    }

    fun newUserSignUpTitleIsVisible() : Pair<Boolean, LogInPage>
    {
        return Pair(elements.newUserSignUpTitle.isDisplayed, this)
    }

    fun signIn(name : String, email : String) : RegisterPage
    {
        elements.signInNameInput.sendKeys(name)
        elements.signInEmailInput.sendKeys(email)
        elements.signupButton.click()
        return RegisterPage(header, footer)
    }

    fun signInWithInvalidData(name : String, email : String) : LogInPage
    {
        elements.signInNameInput.sendKeys(name)
        elements.signInEmailInput.sendKeys(email)
        elements.signupButton.click()
        return this
    }

    fun logInToYourAccountHeaderIsVisible() : Pair <Boolean, LogInPage>
    {
        return Pair(elements.logInToYourAccountTitle.isDisplayed, this)
    }

    fun emailAddressAlreadyExistsIsVisible() : Boolean
    {
        return elements.emailAddressAlreadyExistsError.isDisplayed
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

        @FindBy(xpath = "//div[@class='signup-form']//h2")
        lateinit var newUserSignUpTitle : WebElement

        @FindBy(xpath = "//input[@data-qa='signup-name']")
        lateinit var signInNameInput : WebElement

        @FindBy(xpath = "//input[@data-qa='signup-email']")
        lateinit var signInEmailInput : WebElement

        @FindBy(xpath = "//button[@data-qa='signup-button']")
        lateinit var signupButton : WebElement

        @FindBy(xpath = "//div[@class='login-form']//h2")
        lateinit var logInToYourAccountTitle : WebElement

        @FindBy(xpath = "//p[text()='Email Address already exist!']")
        lateinit var emailAddressAlreadyExistsError : WebElement
    }
}