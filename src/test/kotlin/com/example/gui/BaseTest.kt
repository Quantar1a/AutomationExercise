package com.example.gui

import com.example.data.Configuration
import com.example.tools.classes.Settings
import org.junit.jupiter.api.BeforeAll
import org.openqa.selenium.WebDriver

abstract class BaseTest
{
    companion object
    {
        @JvmStatic
        protected lateinit var webDriver : WebDriver

        @JvmStatic
        @BeforeAll
        fun testConfiguration()
        {
            //Setting up webDriver according to Configurations
            webDriver = Settings.driverInstall(Configuration.activeBrowser, Configuration.headlessMode)
            Settings.clearAllCookies(Configuration.isAllCookiesCleared)
            Settings.setPageLoadTimeout(Configuration.pageLoadTimeout)
            Settings.setImplicitlyWait(Configuration.implicitlyWait)
            Settings.setWindowMode(Configuration.windowMode)
        }
    }
}