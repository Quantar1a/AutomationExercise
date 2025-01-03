package com.example.pages

import com.example.pages.abstraction.AbstractElement
import com.example.pages.abstraction.AbstractPage
import com.example.pages.pageComponents.PageFooter
import com.example.pages.pageComponents.PageHeader
import io.qameta.allure.Step
import org.junit.jupiter.api.Assertions
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

//Class for Login or Sing in page
class LogInPage(
    var header: PageHeader,
    var footer : PageFooter
) : AbstractPage()
{
    private var elements : Elements

    init
    {
        elements = Elements()

        // wait till the page is loaded
        this.waitTillElementIsVisible(elements.loginForm)
    }

    @Step("Enter email address and password in Log In form")
    private fun enterEmailAddressAndPasswordInLogInForm(email : String, password : String) : LogInPage
    {
        elements.logInEmailInput.sendKeys(email)
        elements.logInPasswordInput.sendKeys(password)
        return this
    }

    @Step("Click 'login' button on Log In form")
    private fun loginButtonClickOnLogInForm() : LogInPage
    {
        elements.logInButton.click()
        return this
    }

    @Step("Log in with valid data")
    fun logInWithValidData(email : String, password : String) : AutomationExerciseMainPage
    {
        this.enterEmailAddressAndPasswordInLogInForm(email, password)
            .loginButtonClickOnLogInForm()
        return AutomationExerciseMainPage(header, footer)
    }

    @Step("Log in with invalid data")
    fun logInWithInvalidData(email : String, password : String) : LogInPage
    {
        this.enterEmailAddressAndPasswordInLogInForm(email, password)
            .loginButtonClickOnLogInForm()
        return this
    }

    @Step("Verify error 'Your email or password is incorrect!' is visible")
    fun verifyThatInvalidEmailOrPasswordMessageIsVisible() : LogInPage
    {
        Assertions.assertTrue(this
            .waitTillElementIsVisible(elements.invalidEmailOrPasswordMessage)
            .isDisplayed)
        return this
    }

    @Step("Verify 'New User Signup!' is visible")
    fun verifyThatNewUserSignUpTitleIsVisible() : LogInPage
    {
        Assertions.assertTrue(elements.newUserSignUpTitle.isDisplayed)
        return this
    }

    @Step("Enter name and email address in Sing In form")
    private fun enterNameAndEmailInSignInForm(name : String, email : String) : LogInPage
    {
        elements.signInNameInput.sendKeys(name)
        elements.signInEmailInput.sendKeys(email)
        return this
    }

    @Step("Click 'Signup' button on Sing Up form")
    private fun signUnButtonClick()
    {
        elements.signupButton.click()
    }

    @Step("Sign up with valid data")
    fun signUpWithValidData(name : String, email : String) : RegisterPage
    {
        this.enterNameAndEmailInSignInForm(name, email)
            .signUnButtonClick()
        return RegisterPage(header, footer)
    }

    @Step("Sign up with invalid data")
    fun signUpWithInvalidData(name : String, email : String) : LogInPage
    {
        this.enterNameAndEmailInSignInForm(name, email)
            .signUnButtonClick()
        return this
    }

    @Step("Verify 'Login to your account' is visible")
    fun verifyThatLogInToYourAccountHeaderIsVisible() : LogInPage
    {
        Assertions.assertTrue(elements.logInToYourAccountTitle.isDisplayed)
        return this
    }

    @Step("Verify error 'Email Address already exist!' is visible")
    fun verifyThatEmailAddressAlreadyExistsIsVisible() : LogInPage
    {
        Assertions.assertTrue(elements.emailAddressAlreadyExistsError.isDisplayed)
        return this
    }


    private class Elements : AbstractElement()
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