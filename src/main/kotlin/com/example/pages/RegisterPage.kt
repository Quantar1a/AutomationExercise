package com.example.pages

import com.example.data.Customer
import com.example.pages.abstraction.AbstractElement
import com.example.pages.abstraction.AbstractPage
import com.example.pages.pageComponents.PageFooter
import com.example.pages.pageComponents.PageHeader
import com.example.tools.enums.Genders
import io.qameta.allure.Step
import org.junit.jupiter.api.Assertions
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.Select

class RegisterPage(
    var header : PageHeader,
    var footer : PageFooter
) : AbstractPage()
{
    private var elements : Elements

    init
    {
        elements = Elements()

        // wait till the page is loaded
        this.waitTillElementIsVisible(elements.registerForm)
    }

    @Step("Verify that 'ENTER ACCOUNT INFORMATION' is visible")
    fun verifyThatPageTitleIsVisible() : RegisterPage
    {
        Assertions.assertTrue(elements.enterAccountInformationTitle.isDisplayed)
        return this
    }

    @Step("Fill details: Title, Name, Email, Password, Date of birth")
    fun fillInUserDetails(customer: Customer, password : String) : RegisterPage
    {
        when(customer.gender)
        {
            Genders.MALE ->
            {
                elements.maleGenderRadioButton.click()
            }
            Genders.FEMALE ->
            {
                elements.femaleGenderRadioButton.click()
            }
        }

        elements.passwordField.sendKeys(password)
        Select(elements.daySelector).selectByValue(customer.dateOfBirths.day.toString())
        Select(elements.monthSelector).selectByValue(customer.dateOfBirths.month.toString())
        Select(elements.yearSelector).selectByValue("19" + customer.dateOfBirths.year.toString())
        return this
    }

    @Step("Select checkbox 'Sign up for our newsletter!'")
    fun singUpForNewsLettersCheckBoxSelection() : RegisterPage
    {
        elements.newsletterSubscriptionCheckbox.click()
        return this
    }

    @Step("Select checkbox 'Receive special offers from our partners!'")
    fun receiveSpecialOffersCheckBoxSelection() : RegisterPage
    {
        elements.specialOffersCheckbox.click()
        return this
    }

    @Step("Fill details: First name, Last name, Company, Address, " +
            "Country, State, City, Zipcode, Mobile Number")
    fun fillInUserPlaceDetails(customer : Customer) : RegisterPage
    {
        elements.firstNameField.sendKeys(customer.firstName)
        elements.lastNameField.sendKeys(customer.lastName)
        elements.companyField.sendKeys(customer.company)
        elements.addressField.sendKeys(customer.address)
        Select(elements.countrySelector).selectByVisibleText(customer.country.countryName)
        elements.stateField.sendKeys(customer.state)
        elements.cityField.sendKeys(customer.city)
        elements.zipcodeField.sendKeys(customer.zipcode)
        elements.mobileNumberField.sendKeys(customer.mobileNumber)
        return this
    }

    @Step("Click 'Create Account button'")
    fun createAccountButtonClick() : InformationalPage
    {
        elements.createAccountButton.click()
        return InformationalPage(header, footer)
    }

    private class Elements : AbstractElement()
    {
        @FindBy(xpath = "//div[@class='login-form']")
        lateinit var registerForm : WebElement

        @FindBy(xpath = "//b[text()='Enter Account Information']")
        lateinit var enterAccountInformationTitle : WebElement

        @FindBy(xpath = "//label[@for='id_gender2']")
        lateinit var femaleGenderRadioButton : WebElement

        @FindBy(xpath = "//label[@for='id_gender1']")
        lateinit var maleGenderRadioButton : WebElement

        @FindBy(xpath = "//input[@id='name']")
        lateinit var nameField : WebElement

        @FindBy(xpath = "//input[@id='email']")
        lateinit var emailField : WebElement

        @FindBy(xpath = "//input[@type='password']")
        lateinit var passwordField : WebElement

        @FindBy(xpath = "//input[@name='newsletter']")
        lateinit var newsletterSubscriptionCheckbox : WebElement

        @FindBy(xpath = "//input[@id='optin']")
        lateinit var specialOffersCheckbox : WebElement

        @FindBy(xpath = "//select[@id='days']")
        lateinit var daySelector : WebElement

        @FindBy(xpath = "//select[@id='months']")
        lateinit var monthSelector : WebElement

        @FindBy(xpath = "//select[@id='years']")
        lateinit var yearSelector : WebElement

        @FindBy(xpath = "//input[@data-qa='first_name']")
        lateinit var firstNameField : WebElement

        @FindBy(xpath = "//input[@data-qa='last_name']")
        lateinit var lastNameField : WebElement

        @FindBy(xpath = "//input[@data-qa='company']")
        lateinit var companyField : WebElement

        @FindBy(xpath = "//input[@data-qa='address']")
        lateinit var addressField: WebElement

        @FindBy(xpath = "//select[@data-qa='country']")
        lateinit var countrySelector : WebElement

        @FindBy(xpath = "//input[@data-qa='state']")
        lateinit var stateField : WebElement

        @FindBy(xpath = "//input[@data-qa='city']")
        lateinit var cityField : WebElement

        @FindBy(xpath = "//input[@data-qa='zipcode']")
        lateinit var zipcodeField : WebElement

        @FindBy(css = "input[data-qa='mobile_number']")
        lateinit var mobileNumberField : WebElement

        @FindBy(xpath = "//div[@class='login-form']//button[@type='submit']")
        lateinit var createAccountButton : WebElement

    }
}