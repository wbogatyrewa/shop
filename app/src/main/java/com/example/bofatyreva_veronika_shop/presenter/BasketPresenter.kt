package com.example.bofatyreva_veronika_shop.presenter

import com.example.bofatyreva_veronika_shop.domain.model.Product
import com.example.bofatyreva_veronika_shop.ui.BasketView
import moxy.MvpPresenter

class BasketPresenter: MvpPresenter<BasketView>() {
    private val basketList =  mutableListOf(
        Product(price = 222.2, discountInPercent = 22, productName = "Мааак бук"),
        Product(price = 8783.24, discountInPercent = 36, productName = "Колечки из бк"),
        Product(price = 55.8, discountInPercent = 14, productName = "BIG jeans"),
        Product(price = 5410.4, discountInPercent = 24, productName = "Футболка с принтом"),
        Product(price = 348.4, discountInPercent = 34, productName = "Свитшоот"),
        Product(price = 860.4, discountInPercent = 44, productName = "Еще колечки из бк"),
        Product(price = 4005.5, discountInPercent = 4, productName = "Многа колечек"),
        Product(price = 5450.4, discountInPercent = 26, productName = "Блузка"),
        Product(price = 832.95, discountInPercent = 15, productName = "22 двойки"),
        Product(price = 4852.99, discountInPercent = 25, productName = "Кубик Рубика"),
        Product(price = 8541.4, discountInPercent = 75, productName = "КОЛЕЧКИ (из бк конечно)"),
        Product(price = 4.4, discountInPercent = 12, productName = "Шорты"),
        Product(price = 15.4, discountInPercent = 1, productName = "Акция ахахаха")
    )

    fun setData() {
        viewState.setCategories(basketList)
    }

    fun removeItem(product: Product) {
        val position = basketList.indexOf(product)
        basketList.remove(product)
        viewState.remoteItem(position)
    }
}