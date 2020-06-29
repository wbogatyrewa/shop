package com.example.bofatyreva_veronika_shop.presenter

import com.example.bofatyreva_veronika_shop.domain.MainApi
import com.example.bofatyreva_veronika_shop.domain.ViewedProductDao
import com.example.bofatyreva_veronika_shop.ui.CatalogView
import moxy.InjectViewState
import moxy.MvpPresenter
import org.json.JSONObject

@InjectViewState
class CatalogPresenter(
    private val mainApi: MainApi,
    private val viewedProductDao: ViewedProductDao
): MvpPresenter<CatalogView>() {
    val list = mutableListOf(
        "Телевизоры",
        "Телефоны",
        "Планшеты",
        "Часы",
        "Компьютеры",
        "Ноутбуки"
    )

    fun setData() {
        viewState.setCategories(list)
    }

    fun removeItem(category: String) {
        val position = list.indexOf(category)
        list.remove(category)
        viewState.removeItem(position)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        val productsJson = mainApi.allProducts()
        /*val productNames = productsJson.map { element ->
            val productJson: JSONObject = element.asJsonOnject
            val productName = productJson["productName"].asString
        }
        viewState.setCategories(productNames)*/
    }

    override fun attachView(view: CatalogView?) {
        super.attachView(view)
        val productIds = viewedProductDao.getAllProduct()
        viewState.showProductIds(productIds)
    }
}