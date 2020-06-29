package com.example.bofatyreva_veronika_shop.domain.model

class Product(
    /*
    * Must be positive
    */
    private val price: Double,
    private val discountInPercent: Int = 0,
    private val productName: String
) {
    /*
     *@return price with applied discount determined by [discountInPercent]
     *
     * If [discountInPercent] is more than 100 product will have negative price
     * If [discountInPercent] less than 0 product price will be increased
     */
    fun calcDiscountPrice(): Double = price * (1 - discountInPercent / 100.0)

    fun getProductName(): String = productName

    fun getPrice(): Double = price

    fun getDiscountInPercent(): Int = discountInPercent
}