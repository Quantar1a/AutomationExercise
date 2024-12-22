package com.example.gui

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class AutomationExerciseTest : BaseTest()
{
    @BeforeEach
    fun setUpTest()
    {

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