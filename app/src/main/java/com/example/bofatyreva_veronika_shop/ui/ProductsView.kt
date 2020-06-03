package com.example.bofatyreva_veronika_shop.ui

import com.example.bofatyreva_veronika_shop.model.Product
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProductsView: MvpView {
    /*
    * Outputs price in <PRICE>P format
    * If price have not fractional part than it will be printed as integer
    * If price have fractional part than it will be rounded for 2 symbols after "."
     */
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun print(price: Double)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun print(name: String)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showErrorForFamily(visible: Boolean)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showErrorForName(visible: Boolean)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showErrorForOtchestvo(visible: Boolean)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showErrorForPhone(visible: Boolean)
}