package com.example.data

import com.example.tools.enums.Browsers
import com.example.tools.enums.WindowMode

class Configuration
{
    companion object
    {
        //Set active browser
        val activeBrowser : Browsers = Browsers.GOOGLE_CHROME

        //Set headless mode
        //true - headless on
        //false - headless off
        val headlessMode : Boolean = false

        //Clearing all cookie files
        //true - clear
        //false - not clear
        val isAllCookiesCleared : Boolean = true

        //set page load time duration, in seconds
        val pageLoadTimeout : Long = 90L

        //set implicitly wait, in seconds
        val implicitlyWait : Long = 20L

        //set explicitly wait, in seconds
        val explicitlyWait : Long = 20L

        //Set window mod for the browser
        val windowMode : WindowMode = WindowMode.MAXIMIZE
    }
}