package com.example.pages.pageComponents

import com.example.pages.abstraction.AbstractElement
import com.example.pages.abstraction.AbstractPage
import io.qameta.allure.Step
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class PageFooter : AbstractPage()
{
    private var elements : Elements = Elements()

    init
    {
        this.waitTillElementIsVisible(elements.subscriptionHeader)
    }

    @Step("Scroll down page to bottom")
    fun scrollToSubscriptionHeader() : PageFooter
    {
        this.scrollToTheElement(elements.subscriptionHeader)
        return this
    }

    @Step("Verify 'SUBSCRIPTION' is visible")
    fun subscriptionHeaderIsVisible() : Boolean
    {
        return elements.subscriptionHeader.isDisplayed
    }


    class Elements() : AbstractElement()
    {
        @FindBy(xpath = "//div[@class='single-widget']//h2")
        lateinit var subscriptionHeader : WebElement
    }
}