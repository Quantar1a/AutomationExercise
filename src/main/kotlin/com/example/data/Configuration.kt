package com.example.data

import com.example.tools.enums.Browsers
import com.example.tools.enums.WindowMode
import java.io.File

class Configuration
{
    companion object
    {
        //Set active browser
        val activeBrowser : Browsers = Browsers.GOOGLE_CHROME

        //Set headless mode
        //true - headless on
        //false - headless off
        val headlessMode : Boolean = true

        //Clearing all cookie files
        //true - clear
        //false - not clear
        val isAllCookiesCleared : Boolean = true

        //set page load time duration, in seconds
        val pageLoadTimeout : Long = 240L

        //set implicitly wait, in seconds
        val implicitlyWait : Long = 20L

        //set explicitly wait, in seconds
        val explicitlyWait : Long = 20L

        //Set window mod for the browser
        val windowMode : WindowMode = WindowMode.MAXIMIZE

        //Set the add blocker if the value is true
        val isAddBlockerAllowed : Boolean = true

        //addblocker file
        val addblockerFile : File = File("src/test/resources/extensions/AdGuard-AdBlocker.crx")
    }
}