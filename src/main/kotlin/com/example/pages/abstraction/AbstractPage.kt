package com.example.pages.abstraction

import com.example.tools.classes.Settings
import org.openqa.selenium.WebDriver

//Abstract class that describes basic features of any page
abstract class AbstractPage
{
    companion object
    {
        @JvmStatic
        protected lateinit var webDriver: WebDriver
    }

    init
    {
        webDriver = Settings.getWebDriver()
    }
}