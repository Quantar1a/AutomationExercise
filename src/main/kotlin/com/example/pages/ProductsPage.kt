package com.example.pages

import com.example.pages.abstraction.AbstractElement
import com.example.pages.abstraction.AbstractPageContainsListOfProducts
import com.example.pages.pageComponents.PageFooter
import com.example.pages.pageComponents.PageHeader
import com.example.pages.pageComponents.Product
import io.qameta.allure.Step
import org.junit.jupiter.api.Assertions
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class ProductsPage(
    var header: PageHeader,
    var footer: PageFooter
) : AbstractPageContainsListOfProducts()
{
    private var elements : Elements
    override var productList : MutableList<Product>

    init
    {
        elements = Elements()
        productList = this.getListOfProducts()

        //Wait till the page is visible
        this.waitTillElementIsVisible(elements.brandsSection)
    }

    @Step("Verify user is navigated to ALL PRODUCTS page successfully")
    fun verifyThatUserIsOnProductsPage() : ProductsPage
    {
        Assertions.assertTrue(elements.allProductsTitle.isDisplayed)
        return this
    }

    @Step("The products list is visible")
    fun verifyThatProductListIsVisible() : ProductsPage
    {
        Assertions.assertTrue(elements.productsList.isDisplayed)
        return this
    }

    private class Elements : AbstractElement()
    {
        @FindBy(xpath = "//div[@class='brands_products']")
        lateinit var brandsSection : WebElement

        @FindBy(xpath = "//h2[@class='title text-center']")
        lateinit var allProductsTitle : WebElement

        @FindBy(xpath = "//div[@class='features_items']")
        lateinit var productsList : WebElement
    }
}