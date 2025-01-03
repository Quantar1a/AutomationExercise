package com.example.pages.abstraction

import com.example.data.Configuration
import com.example.tools.classes.Settings
import org.openqa.selenium.Alert
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

//Abstract class that describes basic features of any page
abstract class AbstractPage
{
    private var jsExecutor : JavascriptExecutor
    private var wait : WebDriverWait

    companion object
    {
        @JvmStatic
        protected lateinit var webDriver: WebDriver
    }

    init
    {
        webDriver = Settings.getWebDriver()
        jsExecutor = webDriver as JavascriptExecutor
        wait = WebDriverWait(webDriver, Duration.ofSeconds(Configuration.explicitlyWait))
    }

    protected fun waitTillElementIsVisible(webElement : WebElement) : WebElement
    {
        wait.until(ExpectedConditions.visibilityOf(webElement))
        return webElement
    }

    protected fun waitTillAlertIsPresent() : Alert
    {
       return wait.until(ExpectedConditions.alertIsPresent())
    }

    //Scroll to the elements, and wait till it is visible
    protected fun scrollToTheElement(webElement : WebElement)
    {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement)
        this.waitTillElementIsVisible(webElement)
    }
}