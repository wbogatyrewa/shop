package com.example.bofatyreva_veronika_shop

interface basketView {
    /*
    * Outputs price in <PRICE>P format
    * If price have not fractional part than it will be printed as integer
    * If price have fractional part than it will be rounded for 2 symbols after "."
     */
    fun print(price: Double)

    fun print(name: String)
}