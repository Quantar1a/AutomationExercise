package com.example.pages

import com.example.pages.abstraction.AbstractElement
import com.example.pages.abstraction.AbstractPage
import com.example.pages.pageComponents.PageFooter
import com.example.pages.pageComponents.PageHeader
import io.qameta.allure.Step
import org.junit.jupiter.api.Assertions
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class InformationalPage(
    var header : PageHeader,
    var footer: PageFooter
) : AbstractPage()
{
    private var elements : Elements

    init
    {
        elements = Elements()
    }

    @Step("Verify that 'ACCOUNT CREATED!' is visible")
    fun verifyThatAccountCreatedTitleIsVisible() : InformationalPage
    {
        Assertions.assertTrue(this.waitTillElementIsVisible(elements.accountCreatedTitle).isDisplayed)
        return this
    }

    @Step("Click 'Continue' button")
    fun continueButtonClick() : AutomationExerciseMainPage
    {
        elements.continueButton.click()
        return AutomationExerciseMainPage(header, footer)
    }

    @Step("Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button")
    fun verifyThatAccountDeletedTitleIsVisible() : InformationalPage
    {
        Assertions.assertTrue(elements.accountDeletedTitle.isDisplayed)
        return this
    }


    private class Elements() : AbstractElement()
    {
        @FindBy(xpath = "//b[text()='Account Created!']")
        lateinit var accountCreatedTitle : WebElement

        @FindBy(xpath = "//a[@data-qa='continue-button']")
        lateinit var continueButton : WebElement

        @FindBy(xpath = "//h2[@data-qa='account-deleted']")
        lateinit var accountDeletedTitle : WebElement
    }
}