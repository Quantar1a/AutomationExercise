package com.example.pages

import com.example.data.Message
import com.example.pages.abstraction.AbstractElement
import com.example.pages.abstraction.AbstractPage
import com.example.pages.pageComponents.PageFooter
import com.example.pages.pageComponents.PageHeader
import io.qameta.allure.Step
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class ContactUsPage(
    var header: PageHeader,
    var footer: PageFooter
) : AbstractPage()
{
    private var elements : Elements

    init
    {
        elements = Elements()

        this.waitTillElementIsVisible(elements.getInTouchTitle)
    }

    @Step("Verify 'GET IN TOUCH' is visible")
    fun getInTouchTitleIsVisible() : Pair <Boolean, ContactUsPage>
    {
        return Pair(elements.getInTouchTitle.isDisplayed, this)
    }

    @Step("""
        Enter name, email, subject and message
        Upload file
        Click 'Submit' button
    """)
    fun sendAMessage(message : Message) : ContactUsPage
    {
        elements.nameInputField.sendKeys(message.name)
        elements.emailInputField.sendKeys(message.email)
        elements.subjectInputField.sendKeys(message.subject)
        elements.messageInputField.sendKeys(message.message)
        elements.fileInputField.sendKeys(message.file.absolutePath)
        elements.submitButton.click()
        return this
    }

    @Step("Click OK button")
    fun submitAlert() : ContactUsPage
    {
        this.waitTillAlertIsPresent().accept()
        return this
    }

    @Step("Verify success message 'Success! Your details have been " +
            "submitted successfully.' is visible")
    fun successMessageISVisible() : Boolean
    {
        return elements.successMessage.isDisplayed
    }

    @Step("Click 'Home' button and verify that landed to home page successfully")
    fun clickOnHomeButton() : AutomationExerciseMainPage
    {
        elements.homeButton.click()
        return AutomationExerciseMainPage(header, footer)
    }

    class Elements : AbstractElement()
    {
        @FindBy(xpath = "//h2[text()='Get In Touch']")
        lateinit var getInTouchTitle : WebElement

        @FindBy(xpath = "//input[@data-qa='name']")
        lateinit var nameInputField : WebElement

        @FindBy(xpath = "//input[@data-qa='email']")
        lateinit var emailInputField : WebElement

        @FindBy(xpath = "//input[@data-qa='subject']")
        lateinit var subjectInputField : WebElement

        @FindBy(xpath = "//textarea[@data-qa='message']")
        lateinit var messageInputField : WebElement

        @FindBy(xpath = "//input[@data-qa='submit-button']")
        lateinit var submitButton : WebElement

        @FindBy(xpath = "//input[@name='upload_file']")
        lateinit var fileInputField : WebElement

        @FindBy(xpath = "//div[@class='status alert alert-success']")
        lateinit var successMessage : WebElement

        @FindBy(xpath = "//span[text()=' Home']")
        lateinit var homeButton : WebElement
    }
}