package com.example.pages.pageComponents

import com.example.pages.SpecificProductPage
import com.example.pages.abstraction.AbstractElement
import com.example.pages.abstraction.AbstractPage
import io.qameta.allure.Step
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class Product(
    id : Int
) : AbstractPage()
{
    private var elements : Elements

    init
    {
        elements = Elements(id)
    }

    @Step("Click on 'View Product' of any product")
    fun viewProductClick() : SpecificProductPage
    {
        elements.viewProductButton.click()
        return SpecificProductPage(PageHeader(), PageFooter())
    }


    private class Elements(id : Int) : AbstractElement()
    {
        var productsPicture : WebElement
        var viewProductButton : WebElement

        init
        {
            productsPicture = webDriver.findElement(By.xpath("//img[@src='/get_product_picture/$id']"))
            viewProductButton = webDriver.findElement(By.xpath("//a[@href='/product_details/$id']"))
        }
    }
}