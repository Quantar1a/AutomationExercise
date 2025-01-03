package com.example.pages

import com.example.pages.abstraction.AbstractElement
import com.example.pages.abstraction.AbstractPage
import com.example.pages.pageComponents.PageFooter
import com.example.pages.pageComponents.PageHeader
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class CartPage(
    var header : PageHeader,
    var footer: PageFooter
) : AbstractPage()
{
    private var elements : Elements

    init
    {
        elements = Elements()

        //wait till the page is visible
        this.waitTillElementIsVisible(elements.breadcrumbs)
    }



    private class Elements : AbstractElement()
    {
        @FindBy(xpath = "//div[@class='breadcrumbs']")
        lateinit var breadcrumbs : WebElement
    }
}