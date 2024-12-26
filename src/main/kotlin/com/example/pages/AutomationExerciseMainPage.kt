package com.example.pages

import com.example.pages.abstraction.AbstractElement
import com.example.pages.abstraction.AbstractPage
import com.example.pages.pageComponents.PageHeader
import com.example.tools.classes.Waiter
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

//Class of the Automation Exercise main page
class AutomationExerciseMainPage(
    var header : PageHeader
) : AbstractPage()
{
    private val elements : Elements = Elements()
    private lateinit var jsExecutor : JavascriptExecutor

    init{
        //Wait till the page is visible
        Waiter(webDriver)
        .waitTillElementIsVisible(elements.topCarousel)

        jsExecutor = webDriver as JavascriptExecutor
    }

    //Scroll to the elements, and wait till it is visible
    private fun scrollToTheElement(webElement: WebElement) : AutomationExerciseMainPage
    {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement)
        Waiter(webDriver).waitTillElementIsVisible(webElement)
        return this
    }

    fun mainPageISVisible() : Boolean
    {
        return elements.topCarousel.isDisplayed
    }

    fun scrollToSubscriptionHeader() : AutomationExerciseMainPage
    {
        this.scrollToTheElement(elements.subscriptionHeader)
        return this
    }

    fun scrollToBannerText() : AutomationExerciseMainPage
    {
        this.scrollToTheElement(elements.bannerText)
        return this
    }

    fun clickOnArrow() : AutomationExerciseMainPage
    {
        elements.arrowUp.click()
        return this
    }

    fun subscriptionHeaderIsVisible() : Pair <Boolean, AutomationExerciseMainPage>
    {
        return Pair(elements.subscriptionHeader.isDisplayed, this)
    }

    fun bannerTextIsVisible() : Pair<Boolean, AutomationExerciseMainPage>
    {
        return Pair(elements.bannerText.isDisplayed, this)
    }



    //Inner class that stores elements of the Main page
    private class Elements : AbstractElement()
    {
        @FindBy(xpath = "//div[@class='col-sm-12']//div[@class='carousel-inner']")
        lateinit var topCarousel : WebElement

        @FindBy(xpath = "//div[@class='single-widget']//h2")
        lateinit var subscriptionHeader : WebElement

        @FindBy(xpath = "//a[@id='scrollUp']")
        lateinit var arrowUp : WebElement

        @FindBy(xpath = "//h2[text()='Full-Fledged practice website for Automation Engineers']")
        lateinit var bannerText : WebElement
    }
}