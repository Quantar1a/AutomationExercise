package com.example.pages

import com.example.pages.abstraction.AbstractElement
import com.example.pages.abstraction.AbstractPage
import com.example.pages.pageComponents.PageFooter
import com.example.pages.pageComponents.PageHeader
import io.qameta.allure.Step
import org.junit.jupiter.api.Assertions
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class SpecificProductPage(
    var header: PageHeader,
    var footer: PageFooter
) : AbstractPage()
{
    private var elements : Elements

    init
    {
        elements = Elements()

        //wait till the page is visible
        this.waitTillElementIsVisible(elements.productsImage)
    }

    @Step("User is landed to product detail page")
    fun verifyThatUserIsOnSpecificProductPage() : SpecificProductPage
    {
        Assertions.assertTrue(elements.productsImage.isDisplayed)
        return this
    }

    @Step("Verify that detail detail is visible: product name, category, price, availability, condition, brand")
    fun verifyThatInformationAboutProductIsVisible() : SpecificProductPage
    {
        var listOfElements : MutableList<WebElement> = mutableListOf(
            elements.productsName,
            elements.productsCategory,
            elements.productsPrice,
            elements.productsAvailability,
            elements.productsCondition,
            elements.productsBrand
        )

        for (pageElement in listOfElements)
        {
            Assertions.assertTrue(pageElement.isDisplayed)
        }

        return this
    }

    private class Elements : AbstractElement()
    {
        @FindBy(xpath = "//img[contains(@src, '/get')]")
        lateinit var productsImage : WebElement

        @FindBy(xpath = "//div[@class='product-information']//h2")
        lateinit var productsName : WebElement

        @FindBy(xpath = "//div[@class='product-information']//p[1]")
        lateinit var productsCategory : WebElement

        @FindBy(xpath = "//div[@class='product-information']/span/span")
        lateinit var productsPrice : WebElement

        @FindBy(xpath = "//div[@class='product-information']//p[2]")
        lateinit var productsAvailability : WebElement

        @FindBy(xpath = "//div[@class='product-information']//p[3]")
        lateinit var productsCondition : WebElement

        @FindBy(xpath = "//div[@class='product-information']//p[4]")
        lateinit var productsBrand : WebElement
    }
}