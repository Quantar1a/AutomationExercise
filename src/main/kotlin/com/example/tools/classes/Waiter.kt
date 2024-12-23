package com.example.tools.classes

import com.example.data.Configuration
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

//Class for explicitly waits
class Waiter
    (driver : WebDriver)
{
    private val wait : WebDriverWait = WebDriverWait(driver, Duration.ofSeconds(Configuration.explicitlyWait))

    //wait till element is visible
    fun waitTillElementIsVisible(element : WebElement) : WebElement
    {
        wait.until(ExpectedConditions.visibilityOf(element))
        return element
    }
}