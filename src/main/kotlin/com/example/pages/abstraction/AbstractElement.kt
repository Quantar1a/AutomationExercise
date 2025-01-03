package com.example.pages.abstraction

import com.example.tools.classes.Settings
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

//Abstract class for inner class that stores page elements
abstract class AbstractElement
{
    companion object
    {
        @JvmStatic
        protected lateinit var webDriver: WebDriver
    }

    init
    {
        webDriver = Settings.getWebDriver()
        PageFactory.initElements(
            /* searchContext = */ webDriver,
            /* page = */ this)
    }
}