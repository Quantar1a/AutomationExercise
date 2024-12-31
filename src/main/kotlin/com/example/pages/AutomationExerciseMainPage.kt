package com.example.pages

import com.example.pages.abstraction.AbstractElement
import com.example.pages.abstraction.AbstractPage
import com.example.pages.pageComponents.PageFooter
import com.example.pages.pageComponents.PageHeader
import io.qameta.allure.Step
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

//Class of the Automation Exercise main page
class AutomationExerciseMainPage(
    var header : PageHeader,
    var footer : PageFooter
) : AbstractPage()
{
    private val elements : Elements = Elements()

    init{
        //Wait till the page is visible
        this.waitTillElementIsVisible(elements.topCarousel)
    }

    @Step("Verify that home page is visible successfully")
    fun mainPageISVisible() : Boolean
    {
        return elements.topCarousel.isDisplayed
    }

    @Step("Scroll up page to top")
    fun scrollToBannerText() : AutomationExerciseMainPage
    {
        this.scrollToTheElement(elements.bannerText)
        return this
    }

    @Step("Click on arrow at bottom right side to move upward")
    fun clickOnArrow() : AutomationExerciseMainPage
    {
        elements.arrowUp.click()
        return this
    }

    @Step("Verify that page is scrolled up and 'Full-Fledged practice website for " +
            "Automation Engineers' text is visible on screen")
    fun bannerTextIsVisible() : Boolean
    {
        return elements.bannerText.isDisplayed
    }



    //Inner class that stores elements of the Main page
    private class Elements : AbstractElement()
    {
        @FindBy(xpath = "//div[@class='col-sm-12']//div[@class='carousel-inner']")
        lateinit var topCarousel : WebElement

        @FindBy(xpath = "//a[@id='scrollUp']")
        lateinit var arrowUp : WebElement

        @FindBy(xpath = "//h2[text()='Full-Fledged practice website for Automation Engineers']")
        lateinit var bannerText : WebElement
    }
}