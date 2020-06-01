package com.example.bofatyreva_veronika_shop.ui

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.example.bofatyreva_veronika_shop.R
import kotlinx.android.synthetic.main.details_layout.*

class BasketActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.basket_layout)

        Log.d(tag, savedInstanceState.toString())
        val savedInt = savedInstanceState?.getInt(SAVE_STATE_INT)
        Log.d(tag, "saved $savedInt")


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