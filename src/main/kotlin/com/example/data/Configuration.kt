package com.example.data

import com.example.tools.enums.Browsers
import com.example.tools.enums.WindowMode

class Configuration
{
    companion object
    {
        val defaultBrowser : Browsers = Browsers.MS_EDGE

        val headlessMode : Boolean = true

        val isAllCookiesCleared : Boolean = true

        val pageLoadTimeout : Long = 60L

        val implicitlyWait : Long = 30L

        val windowMode : WindowMode = WindowMode.MAXIMIZE
    }
}