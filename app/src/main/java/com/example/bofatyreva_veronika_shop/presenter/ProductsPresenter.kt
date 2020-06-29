package com.example.bofatyreva_veronika_shop.presenter

import com.example.bofatyreva_veronika_shop.domain.model.Basket
import com.example.bofatyreva_veronika_shop.domain.model.CreateOrderModel
import com.example.bofatyreva_veronika_shop.domain.model.Product
import com.example.bofatyreva_veronika_shop.ui.ProductsView
import moxy.MvpPresenter

class ProductsPresenter: MvpPresenter<ProductsView>() {
    private val iphoneCase = Product(
        price = 123.0,
        discountInPercent = 30,
        productName = "Iphone Case"
    )
    private val samsungCase = Product(
        price = 100.0,
        discountInPercent = 15,
        productName = "Samsung Case"
    )

    private val basketList = Basket(listOf(iphoneCase, samsungCase))

    private val model = CreateOrderModel()

    fun getProduct() = basketList

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

    private fun checkSymbols(text: String): Boolean = text.length < 3


    fun printProductName() {
        basketList.getList().forEach { product ->
            viewState.print(product.getProductName())
        }
    }

    fun printProductNameWithPrice() {
        //val allPrice: Double = 0.0
        basketList.getList().forEach { product ->
            viewState.print("${product.getProductName()}: ${product.calcDiscountPrice()}")
        }
    }

    fun printPrice() {
        var allPrice: Double = 0.0
        basketList.getList().forEach { product ->
            allPrice += product.calcDiscountPrice()
        }
        viewState.print(allPrice)
    }

}