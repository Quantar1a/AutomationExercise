package com.example.tools.classes

import com.example.pages.AutomationExerciseMainPage
import com.example.tools.interfaces.OpenURL
import org.openqa.selenium.WebDriver

class Actions
    (val webDriver : WebDriver) : OpenURL
{

    override fun openURL(url: String) : AutomationExerciseMainPage
    {
        webDriver.get(url)
        return AutomationExerciseMainPage(webDriver)
    }
}