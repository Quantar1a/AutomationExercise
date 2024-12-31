package com.example.pages

import com.example.pages.abstraction.AbstractElement
import com.example.pages.abstraction.AbstractPage
import com.example.pages.pageComponents.PageFooter
import com.example.pages.pageComponents.PageHeader
import io.qameta.allure.Step
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

//Page with the list of test cases on the website
class TestCasesPage(
    var header: PageHeader,
    var footer : PageFooter
) : AbstractPage()
{
    private var elements : Elements = Elements()

    init
    {
        // wait till the page is loaded (element is visible on the page)
        this.waitTillElementIsVisible(elements.testCaseContainer)
    }

    @Step("Verify user is navigated to test cases page successfully")
    fun testCaseContainerIsVisible() : Boolean
    {
        return this.waitTillElementIsVisible(elements.testCaseContainer).isDisplayed
    }

    class Elements : AbstractElement()
    {
        //Container for test cases
        @FindBy(xpath = "//section//div[@class='container']")
        lateinit var testCaseContainer : WebElement
    }
}