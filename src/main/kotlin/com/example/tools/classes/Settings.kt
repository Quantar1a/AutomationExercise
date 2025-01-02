package com.example.tools.classes

import com.example.data.Configuration
import com.example.tools.enums.Browsers
import com.example.tools.enums.WindowMode
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.edge.EdgeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.firefox.FirefoxProfile
import java.time.Duration

//Driver settings according to configurations
//in com.example.data.Configuration.kt
class Settings
{
    companion object
    {
        private lateinit var webDriver : WebDriver

        fun driverInstall() : WebDriver
        {
            when(Configuration.activeBrowser)
            {
                Browsers.GOOGLE_CHROME -> {
                    WebDriverManager.chromedriver().setup()
                    val chromeOptions = ChromeOptions()

                    if(Configuration.headlessMode)
                    {
                        chromeOptions.addArguments("--headless")
                    }

                    if(Configuration.isAddBlockerAllowed)
                    {
                        chromeOptions.addExtensions(Configuration.addblockerFile)
                    }

                    webDriver = ChromeDriver(chromeOptions)
                }
                Browsers.FIREFOX -> {
                    WebDriverManager.firefoxdriver().setup()
                    val firefoxOptions = FirefoxOptions()

                    if(Configuration.headlessMode)
                    {
                        firefoxOptions.addArguments("-headless")
                    }

                    if(Configuration.isAddBlockerAllowed)
                    {
                        val profile : FirefoxProfile = FirefoxProfile()
                        profile.addExtension(Configuration.addblockerFile)
                        firefoxOptions.setProfile(profile)
                    }

                    webDriver = FirefoxDriver(firefoxOptions)
                }
                Browsers.MS_EDGE -> {
                    WebDriverManager.edgedriver().setup()
                    val edgeOptions = EdgeOptions()

                    if(Configuration.headlessMode)
                    {
                        edgeOptions.addArguments("headless")
                    }

                    if(Configuration.isAddBlockerAllowed)
                    {
                        edgeOptions.addExtensions(Configuration.addblockerFile)
                    }

                    webDriver = EdgeDriver(edgeOptions)
                }
            }
            return webDriver
        }

        fun clearAllCookies(isCookieCleared : Boolean)
        {
            if (isCookieCleared)
            {
                webDriver.manage().deleteAllCookies()
            }
        }

        fun setPageLoadTimeout(pageLoadTimeout : Long)
        {
            webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout))
        }

        fun setImplicitlyWait(implicitlyWait : Long)
        {
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait))
        }

        fun setWindowMode(windowMode : WindowMode)
        {
            when(windowMode)
            {
                WindowMode.MAXIMIZE -> {
                    webDriver.manage().window().maximize()
                }
                WindowMode.MINIMAZE -> {
                    webDriver.manage().window().minimize()
                }
                WindowMode.FULLSCREEN -> {
                    webDriver.manage().window().fullscreen()
                }
            }
        }

        fun getWebDriver() : WebDriver
        {
            return webDriver
        }
    }
}