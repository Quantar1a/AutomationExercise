package com.example.pages.pageComponents

import com.example.pages.abstraction.AbstractElement
import com.example.pages.abstraction.AbstractPage
import io.qameta.allure.Step
import org.junit.jupiter.api.Assertions
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class PageFooter : AbstractPage()
{
    private var elements : Elements

    init
    {
        elements = Elements()

        this.waitTillElementIsVisible(elements.subscriptionHeader)
    }

    @Step("Scroll down page to bottom")
    fun scrollToFooter() : PageFooter
    {
        this.scrollToTheElement(elements.subscriptionHeader)
        return this
    }

    @Step("Verify 'SUBSCRIPTION' is visible")
    fun verifyThatSubscriptionHeaderIsVisible() : PageFooter
    {
        Assertions.assertTrue(elements.subscriptionHeader.isDisplayed)
        return this
    }

    @Step("Enter email address in input and click arrow button")
    fun subscribeToNewsLetters(email : String) : PageFooter
    {
        elements.emailInputField.sendKeys(email)
        elements.arrowButton.click()
        return this
    }

    @Step("Verify success message 'You have been successfully subscribed!' is visible")
    fun verifyThatYouHaveBeenSuccessfullySubscribedIsVisible() : PageFooter
    {
        Assertions.assertTrue(
            this.waitTillElementIsVisible(
                elements.youHaveBeenSuccessfullySubscribedMessage
            ).isDisplayed)
        return this
    }


    private class Elements() : AbstractElement()
    {
        @FindBy(xpath = "//div[@class='single-widget']//h2")
        lateinit var subscriptionHeader : WebElement

        @FindBy(xpath = "//input[@type='email']")
        lateinit var emailInputField : WebElement

        @FindBy(xpath = "//div[@class='alert-success alert']")
        lateinit var youHaveBeenSuccessfullySubscribedMessage : WebElement

        @FindBy(xpath = "//button[@id='subscribe']")
        lateinit var arrowButton : WebElement
    }
}