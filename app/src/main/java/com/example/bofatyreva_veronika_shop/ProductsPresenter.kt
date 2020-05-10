package com.example.bofatyreva_veronika_shop

class ProductsPresenter(
    private val view: basketView
) {
    private val iphoneCase = Product(price = 123.0, discountInPercent = 30, productName = "Iphone Case")
    private val samsungCase = Product(price = 100.0, discountInPercent = 15, productName = "Samsung Case")

    private val products = listOf(iphoneCase, samsungCase)

    fun printProductNameWithPrice() {
        view.print(iphoneCase.calcDiscountPrice())

        //val allPrice: Double = 0.0
        products.forEach { product ->
            view.print("${product.getProductName()}: ${product.calcDiscountPrice()}")
        }
    }
}