package com.example.bofatyreva_veronika_shop

import org.junit.Test

import org.junit.Assert.*
import java.lang.Math.pow
import kotlin.math.sqrt

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    fun FormatIntPrice(price: Int, measure: String = "шт", discount: Int): String {
        if (discount != 0) {
            val discountPrice = price - (price * discount / 100)
            return "$discountPrice/$measure (скидка $discount%)"
        }
        else return "$price/$measure"
    }

    fun FormatDoublePrice(price: Double, measure: String = "шт", discount: Int): String {
        if (discount != 0) {
            val discountPrice = price - (price * discount / 100)
            return "${String.format("%.2f", discountPrice)}/$measure (скидка $discount%)"
        } else return "$price/$measure"
    }

    @Test
    fun printFormatPrice() {
        val price = 123.99
        val discount = 60
        if (price % 1.0 == 0.0) print(message = FormatIntPrice(price = price.toInt(), discount = discount))
        else print(message = FormatDoublePrice(price = price, discount = discount))


    }
}
