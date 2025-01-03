package com.example.pages

import com.example.data.Message
import com.example.pages.abstraction.AbstractElement
import com.example.pages.abstraction.AbstractPage
import com.example.pages.pageComponents.PageFooter
import com.example.pages.pageComponents.PageHeader
import io.qameta.allure.Step
import org.junit.jupiter.api.Assertions
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import java.io.File

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
    fun verifyThatGetInTouchIsVisible() : ContactUsPage
    {
        Assertions.assertTrue(elements.getInTouchTitle.isDisplayed)
        return this
    }

    @Step("Enter name, email, subject and message")
    fun enterNameEmailSubjectMessage(message: Message) : ContactUsPage
    {
        elements.nameInputField.sendKeys(message.name)
        elements.emailInputField.sendKeys(message.email)
        elements.subjectInputField.sendKeys(message.subject)
        elements.messageInputField.sendKeys(message.message)
        return this
    }

    @Step("Upload file")
    fun uploadFile(file : File) : ContactUsPage
    {
        elements.fileInputField.sendKeys(file.absolutePath)
        return this
    }

    @Step("Click 'Submit' button")
    fun submitButtonClick() : ContactUsPage
    {
        elements.submitButton.click()
        return this
    }

    @Step("Click OK button")
    fun okButtonClickOnAlert() : ContactUsPage
    {
        this.waitTillAlertIsPresent().accept()
        return this
    }

    @Step("Verify success message 'Success! Your details have been " +
            "submitted successfully.' is visible")
    fun verifyThatSuccessMessageIsVisible() : ContactUsPage
    {
        Assertions.assertTrue(elements.successMessage.isDisplayed)
        return this
    }

    @Step("Click 'Home' button and verify that landed to home page successfully")
    fun homeButtonClick() : AutomationExerciseMainPage
    {
        elements.homeButton.click()
        return AutomationExerciseMainPage(header, footer)
    }

    private class Elements : AbstractElement()
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