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
    fun formatPrice(price: Double, measure: String = "шт", discount: Int = 0): String {
        if (discount != 0) {
            val discountPrice = price - (price * discount / 100)
            return "$discountPrice/$measure (скидка $discount%)"
        }
        else return "$price/$measure"
    }

    @Test
    fun printFormatPrice() {
        println(formatPrice(price = 123.0, discount = 15))
    }
}
