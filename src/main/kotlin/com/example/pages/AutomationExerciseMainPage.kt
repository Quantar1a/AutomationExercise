package com.example.pages

import com.example.pages.abstraction.AbstractElement
import com.example.pages.abstraction.AbstractPage
import com.example.tools.classes.Waiter
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

//Class of the Automation Exercise main page
class AutomationExerciseMainPage
    (driver : WebDriver) : AbstractPage(driver)
{
        private val elements : Elements = Elements(driver)

        init{
            //Wait till the page is visible
           Waiter(driver)
               .waitTillElementIsVisible(elements.webSiteLogo)
        }



    //Inner class that stores elements of the Main page
    private class Elements(driver : WebDriver) : AbstractElement(driver)
    {
        @FindBy(xpath = "//img[@src='/static/images/home/logo.png']")
       lateinit var webSiteLogo : WebElement
    }
}