package com.example.pages

import com.example.pages.abstraction.AbstractElement
import com.example.pages.abstraction.AbstractPage
import com.example.pages.pageComponents.PageHeader
import com.example.tools.classes.Waiter
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

//Class of the Automation Exercise main page
class AutomationExerciseMainPage(
    var header : PageHeader
) : AbstractPage()
{
        private val elements : Elements = Elements()

        init{
            //Wait till the page is visible
           Waiter(webDriver)
               .waitTillElementIsVisible(elements.topCarousel)
        }

    //Inner class that stores elements of the Main page
    private class Elements : AbstractElement()
    {
        @FindBy(xpath = "//div[@class='col-sm-12']//div[@class='carousel-inner']")
        lateinit var topCarousel : WebElement
    }
}