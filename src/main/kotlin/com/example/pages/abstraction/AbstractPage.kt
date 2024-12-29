package com.example.pages.abstraction

import com.example.tools.classes.Settings
import com.example.tools.classes.Waiter
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

//Abstract class that describes basic features of any page
abstract class AbstractPage
{
    private var jsExecutor : JavascriptExecutor

    companion object
    {
        @JvmStatic
        protected lateinit var webDriver: WebDriver
    }

    init
    {
        webDriver = Settings.getWebDriver()
        jsExecutor = webDriver as JavascriptExecutor
    }

    //Scroll to the elements, and wait till it is visible
    protected fun scrollToTheElement(webElement : WebElement)
    {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement)
        Waiter(webDriver).waitTillElementIsVisible(webElement)
    }
}