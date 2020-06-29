package com.example.bofatyreva_veronika_shop.ui

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bofatyreva_veronika_shop.R
import com.example.bofatyreva_veronika_shop.data.ViewedProductDaoImpl
import com.example.bofatyreva_veronika_shop.domain.MainApi
import com.example.bofatyreva_veronika_shop.presenter.CatalogPresenter
import kotlinx.android.synthetic.main.catalog_layout.*
import moxy.ktx.moxyPresenter
import retrofit2.Retrofit

class CatalogActivity : BaseActivity(), CatalogView {

    private val presenter by moxyPresenter {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.github.com/")
            .build()
        val service = retrofit.create(MainApi::class.java)
        CatalogPresenter(
            mainApi = service,
            viewedProductDao = ViewedProductDaoImpl(sharedPreferences)
        )
    }

    private val adapter = CategoryAdapter { category ->
        presenter.removeItem(category)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.catalog_layout)


        val productId: Int? = intent.extras?.getInt(PRODUCT_ID, -1)
        Log.d(tag, productId.toString())

        Log.d(tag, savedInstanceState.toString())
        val savedInt = savedInstanceState?.getInt(SAVE_STATE_INT)
        Log.d(tag, "saved $savedInt")

        detailsCheckoutBtn.setOnClickListener {
            val intent : Intent = Intent(this, DetailsActivity::class.java).apply {
                putExtra(DetailsActivity.PRODUCT_ID, 2000)
            }
            startActivityForResult(intent, DetailsActivity.REQUEST_AUTH)
        }

        catalogCheckoutBtn.setOnClickListener {
            val intent : Intent = Intent(this, CheckoutActivity::class.java).apply {
                putExtra(PRODUCT_ID, 2000)
            }
            startActivityForResult(intent, REQUEST_AUTH)
        }

        categoryRv.layoutManager = LinearLayoutManager(this)
        categoryRv.adapter = adapter

    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        outState.putInt(SAVE_STATE_INT, 22)
        super.onSaveInstanceState(outState, outPersistentState)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (REQUEST_AUTH == requestCode) {
            val isUserAuth = data?.extras?.getBoolean(IS_USER_AUTH)
            Log.d(tag, isUserAuth.toString())
        }
    }

    override fun setCategories(list: List<String>) {
        adapter.setData(list)
    }

    override fun removeItem(position: Int) {
        adapter.notifyItemRemoved(position)
    }

    override fun showProductIds(productIds: List<Long>) {
        Toast.makeText(this, productIds.joinToString(","), Toast.LENGTH_LONG).show()
    }

    companion object {
        const val PRODUCT_ID = "PRODUCT_ID"
        const val REQUEST_AUTH: Int = 10
        const val IS_USER_AUTH = "IS_USER_AUTH"
        const val SAVE_STATE_INT = "SAVE_STATE_INT"
    }
}

val AppCompatActivity.sharedPreferences: SharedPreferences
    get() = getSharedPreferences("data", MODE_PRIVATE)