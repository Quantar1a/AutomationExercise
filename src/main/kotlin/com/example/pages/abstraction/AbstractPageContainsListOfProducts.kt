package com.example.pages.abstraction

import com.example.pages.pageComponents.Product

abstract class AbstractPageContainsListOfProducts : AbstractPage()
{
    abstract var productList : MutableList<Product>

    protected fun getListOfProducts() : MutableList<Product>
    {
        var productsList : MutableList<Product> = mutableListOf()

        for (id in 1 .. 8)
        {
            productsList.add(Product(id))
        }
        return productsList
    }

    fun getElementFromProductList(index : Int) : Product
    {
        return productList[index - 1]
    }
}