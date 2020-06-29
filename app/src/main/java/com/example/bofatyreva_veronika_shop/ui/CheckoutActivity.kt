package com.example.bofatyreva_veronika_shop.ui

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import com.example.bofatyreva_veronika_shop.presenter.ProductsPresenter
import com.example.bofatyreva_veronika_shop.R
import com.example.bofatyreva_veronika_shop.domain.MainApi
import com.example.bofatyreva_veronika_shop.ui.CatalogActivity.Companion.IS_USER_AUTH
import com.example.bofatyreva_veronika_shop.ui.CatalogActivity.Companion.PRODUCT_ID
import com.example.bofatyreva_veronika_shop.ui.CatalogActivity.Companion.REQUEST_AUTH
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit

class CheckoutActivity : BaseActivity(), ProductsView {

    private val presenter = ProductsPresenter()
    private var isAuth:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val productId: Int? = intent.extras?.getInt(PRODUCT_ID, -1)
        Log.d(tag, productId.toString())

        presenter.printProductNameWithPrice()
        checkoutPriceWithoutSales.text = "2000 P"
        checkoutDiscount.text = "1000 P"
        checkoutSumValue.text = "1000 P"
        checkoutPay.setOnClickListener{
            isAuth = true
            setResult(REQUEST_AUTH, Intent().apply {
                putExtra(IS_USER_AUTH, isAuth)
            })
        }

        presenter.attachView(this)

        setListeners()
    }

    private fun setListeners() {

        checkoutFamily.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                presenter.checkFamily(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        checkoutName.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                presenter.checkName(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        checkoutOtchestvo.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                presenter.checkOtchestvo(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        checkoutPhone.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                presenter.checkPhone(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
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

    private fun EditText.showError(visible: Boolean) {
        val drawable = if (visible) R.drawable.ic_error
        else 0

        this.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawable, 0)
    }

    override fun showErrorForFamily(visible: Boolean) {
        checkoutFamily.showError(visible)
    }

    override fun showErrorForName(visible: Boolean) {
        checkoutName.showError(visible)
    }

    override fun showErrorForOtchestvo(visible: Boolean) {
        checkoutOtchestvo.showError(visible)
    }

    override fun showErrorForPhone(visible: Boolean) {
        checkoutPhone.showError(visible)
    }
}
