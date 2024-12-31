package com.example.pages

import com.example.pages.abstraction.AbstractElement
import com.example.pages.abstraction.AbstractPage
import com.example.pages.pageComponents.PageFooter
import com.example.pages.pageComponents.PageHeader
import io.qameta.allure.Step
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class InformationalPage(
    var header : PageHeader,
    var footer: PageFooter
) : AbstractPage()
{
    private var elements = Elements()

    @Step("Verify that 'ACCOUNT CREATED!' is visible")
    fun accountCreatedTitleIsVisible() : Boolean
    {
        return this.waitTillElementIsVisible(elements.accountCreatedTitle).isDisplayed
    }

    @Step("Click 'Continue' button")
    fun clickOnContinueButton() : AutomationExerciseMainPage
    {
        elements.continueButton.click()
        return AutomationExerciseMainPage(header, footer)
    }

    @Step("Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button")
    fun accountDeletedTitleIsVisible() : Pair<Boolean, InformationalPage>
    {
        return Pair(elements.accountDeletedTitle.isDisplayed, this)
    }


    class Elements() : AbstractElement()
    {
        @FindBy(xpath = "//b[text()='Account Created!']")
        lateinit var accountCreatedTitle : WebElement

        @FindBy(xpath = "//a[@data-qa='continue-button']")
        lateinit var continueButton : WebElement

        @FindBy(xpath = "//h2[@data-qa='account-deleted']")
        lateinit var accountDeletedTitle : WebElement
    }
}