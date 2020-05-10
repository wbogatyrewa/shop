package com.example.bofatyreva_veronika_shop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), basketView {

    val presenter = ProductsPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.printProductNameWithPrice()
        checkoutPriceWithoutSales.text = "2000 P"
        checkoutDiscount.text = "50%"
        checkoutSumValue.text = "1000 P"
        checkoutPay.setOnClickListener{
            Toast.makeText(this, "аххахахах лох", Toast.LENGTH_SHORT).show()
        }

    }

    override fun print(price: Double) {
        //if (price % 1.0 == 0.0) {
        //    println("${price.toInt()}₽")
        //} else {
        //    println("${String.format("%.2f", price)}₽")
        //}
    }

    override fun print(name: String) {
        //println(name)
    }
}
