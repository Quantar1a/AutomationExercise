package com.example.pages.abstraction

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

//Abstract class for inner class that stores page elements
abstract class AbstractElement
    (protected val driver : WebDriver)
{
        init{
            PageFactory.initElements(driver, this)
        }
}