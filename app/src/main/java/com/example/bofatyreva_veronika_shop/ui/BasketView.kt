package com.example.bofatyreva_veronika_shop.ui

import com.example.bofatyreva_veronika_shop.domain.model.Product
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface BasketView: MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setCategories(list: List<Product>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun remoteItem(position: Int)
}