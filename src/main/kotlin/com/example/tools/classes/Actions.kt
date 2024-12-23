package com.example.tools.classes

import com.example.tools.interfaces.OpenURL
import org.openqa.selenium.WebDriver

class Actions
    (val webDriver : WebDriver) : OpenURL
{

    //Open URL in web driver
    override fun openURL(url: String)
    {
        webDriver.get(url)
    }
}