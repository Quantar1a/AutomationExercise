package com.example.pages.abstraction

import org.openqa.selenium.WebDriver

//Abstract class that describes basic features of any page
abstract class AbstractPage
    (protected val driver : WebDriver)
{
}