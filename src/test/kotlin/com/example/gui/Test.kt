package com.example.gui

import com.example.data.TestData
import com.example.pages.AutomationExerciseMainPage
import com.example.tools.classes.Actions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class AutomationExerciseTest : BaseTest()
{
    lateinit var mainPage : AutomationExerciseMainPage

    @BeforeEach
    fun setUpTest()
    {
        //initialize AutomationExercise main page, and open it in browser
        mainPage = Actions(webDriver).openURL(TestData.url)
    }

    @Test
    fun test1()
    {

    }

    @AfterEach
    fun closeDriver()
    {
        webDriver.quit()
    }
}