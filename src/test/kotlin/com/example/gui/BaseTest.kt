package com.example.gui

import com.example.data.Configuration
import com.example.tools.Settings
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
            webDriver = Settings.driverInstall(Configuration.defaultBrowser, Configuration.headlessMode)
            Settings.clearAllCookies(Configuration.isAllCookiesCleared)
            Settings.setPageLoadTimeout(Configuration.pageLoadTimeout)
            Settings.setImplicitlyWait(Configuration.implicitlyWait)
            Settings.setWindowMode(Configuration.windowMode)
        }
    }
}