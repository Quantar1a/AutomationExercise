package com.example.pages.pageComponents

import com.example.pages.abstraction.AbstractElement
import com.example.pages.abstraction.AbstractPage
import com.example.tools.classes.Waiter
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class PageFooter : AbstractPage()
{
    private var elements : Elements = Elements()

    init
    {
        Waiter(webDriver).waitTillElementIsVisible(elements.subscriptionHeader)
    }

    fun scrollToSubscriptionHeader() : PageFooter
    {
        this.scrollToTheElement(elements.subscriptionHeader)
        return this
    }

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