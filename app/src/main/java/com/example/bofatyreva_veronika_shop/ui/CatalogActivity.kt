package com.example.bofatyreva_veronika_shop.ui

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.example.bofatyreva_veronika_shop.R
import kotlinx.android.synthetic.main.catalog_layout.*

class CatalogActivity : BaseActivity() {

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

    companion object {
        const val PRODUCT_ID = "PRODUCT_ID"
        const val REQUEST_AUTH: Int = 10
        const val IS_USER_AUTH = "IS_USER_AUTH"
        const val SAVE_STATE_INT = "SAVE_STATE_INT"
    }
}