package com.example.tools.classes

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
import java.time.Duration

//Driver settings according to configurations
//in com.example.data.Configuration.kt
class Settings
{
    companion object
    {
        private lateinit var webDriver : WebDriver

        fun driverInstall(selectedBrowser : Browsers, headlessMode : Boolean) : WebDriver
        {
            when(selectedBrowser)
            {
                Browsers.GOOGLE_CHROME -> {
                    WebDriverManager.chromedriver().setup()
                    val chromeOptions = ChromeOptions()

                    if(headlessMode)
                    {
                        chromeOptions.addArguments("--headless")
                    }

                    webDriver = ChromeDriver(chromeOptions)
                }
                Browsers.FIREFOX -> {
                    WebDriverManager.firefoxdriver().setup()
                    val firefoxOptions = FirefoxOptions()

                    if(headlessMode)
                    {
                        firefoxOptions.addArguments("-headless")
                    }

                    webDriver = FirefoxDriver(firefoxOptions)
                }
                Browsers.MS_EDGE -> {
                    WebDriverManager.edgedriver().setup()
                    val edgeOptions = EdgeOptions()

                    if(headlessMode)
                    {
                        edgeOptions.addArguments("headless")
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
    }
}