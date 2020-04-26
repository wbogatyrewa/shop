package com.example.bofatyreva_veronika_shop

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest2 {

    @Test
    fun example() {

        val iphoneCase = Product(price = 123.0, discountInPercent = 30)
        val samsungCase = Product(price = 100.0, discountInPercent = 15)

        val pricePrinter: PricePrinter = ConsolePricePrinter()

        val products = listOf(iphoneCase, samsungCase)
        val discountPrices = products.map { it.calcDiscountPrice() }

        discountPrices.forEach { discountPrice ->
            pricePrinter.print(discountPrice)
        }
    }
}

        class Product(
            /*
            * Must be positive
            */
            private val price: Double,
            private val discountInPercent: Int = 0
        ) {
            /*
            *@return price with applied discount determined by [discountInPercent]
            *
            * If [discountInPercent] is more than 100 product will have negative price
            * If [discountInPercent] less than 0 product price will be increased
            */
            fun calcDiscountPrice(): Double = price * (1 - discountInPercent / 100.0)
        }

        interface PricePrinter {
            /*
            * Outputs price in <PRICE>P format
            * If price have not fractional part than it will be printed as integer
            * If price have fractional part than it will be rounded for 2 symbols after "."
            */
            fun print(price: Double)

        }

        class ConsolePricePrinter : PricePrinter {
            override fun print(price: Double) {
                if (price % 1.0 == 0.0) {
                    println("${price.toInt()}₽")
                } else {
                    println("${String.format("%.2f", price)}₽")
                }
            }


        }
