package com.example.gui

import org.openqa.selenium.WebDriver

abstract class BaseTest
{
    companion object
    {
        @JvmStatic
        lateinit var webDriver: WebDriver
    }
}