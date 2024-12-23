package com.example.pages

import com.example.pages.abstraction.AbstractElement
import com.example.pages.abstraction.AbstractPage
import com.example.tools.classes.Waiter
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

//Page with the list of test cases on the website
class TestCasesPage : AbstractPage()
{
    private var elements : Elements = Elements()

    init
    {
        // wait till the page is loaded (element is visible on the page)
        Waiter(webDriver).waitTillElementIsVisible(elements.testCaseContainer)
    }

    fun testCaseContainerIsVisible() : Boolean
    {
        return Waiter(webDriver)
            .waitTillElementIsVisible(elements.testCaseContainer)
            .isDisplayed
    }

    class Elements : AbstractElement()
    {
        //Container for test cases
        @FindBy(xpath = "//section//div[@class='container']")
        lateinit var testCaseContainer : WebElement
    }
}