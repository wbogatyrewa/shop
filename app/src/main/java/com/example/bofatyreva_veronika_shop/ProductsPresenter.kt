package com.example.bofatyreva_veronika_shop

import moxy.MvpPresenter

class ProductsPresenter: MvpPresenter<BasketView>() {
    private val iphoneCase = Product(price = 123.0, discountInPercent = 30, productName = "Iphone Case")
    private val samsungCase = Product(price = 100.0, discountInPercent = 15, productName = "Samsung Case")

    private val products = listOf(iphoneCase, samsungCase)

    private val model = CreateOrderModel()

    fun checkFamily(text: String) {
        if (!checkSymbols(text)) model.Family = text
        viewState.showErrorForFamily(checkSymbols(text))
    }

    fun checkName(text: String) {
        if (!checkSymbols(text)) model.Name = text
        viewState.showErrorForName(checkSymbols(text))
    }

    fun checkOtchestvo(text: String) {
        if (!checkSymbols(text)) model.Otchestvo = text
        viewState.showErrorForOtchestvo(checkSymbols(text))
    }

    fun checkPhone(text: String) {
        if (!checkSymbols(text)) model.Phone = text
        viewState.showErrorForPhone(checkSymbols(text))
    }

    private fun checkSymbols(text: String): Boolean = text.length < 11


    fun printProductNameWithPrice() {
        viewState.print(iphoneCase.calcDiscountPrice())

        //val allPrice: Double = 0.0
        products.forEach { product ->
            viewState.print("${product.getProductName()}: ${product.calcDiscountPrice()}")
        }
    }
}