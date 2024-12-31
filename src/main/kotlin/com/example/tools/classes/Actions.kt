package com.example.tools.classes

import com.example.tools.interfaces.OpenURL
import io.qameta.allure.Step
import org.openqa.selenium.WebDriver

class Actions
    (val webDriver : WebDriver) : OpenURL
{

    //Open URL in web driver
    @Step("Navigate to url")
    override fun openURL(url: String)
    {
        webDriver.get(url)
    }
}