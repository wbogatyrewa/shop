package com.example.bofatyreva_veronika_shop.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    val tag: String = this.javaClass.simpleName

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // The activity is being created
        Log.d(tag, "onCreate")
    }

    public override fun onStart() {
        super.onStart()
        // The activity is about to become visible
        Log.d(tag, "onStart")
    }

    public override fun onResume() {
        super.onResume()
        // The activity has become visible (it is now "resumed")
        Log.d(tag, "onResume")
    }

    public override fun onPause() {
        super.onPause()
        // Another activity is talking focus (this activity is about to be "paused")
        Log.d(tag, "onPause")
    }

    public override fun onRestart() {
        super.onRestart()
        Log.d(tag, "onRestart")
    }

    public override fun onStop() {
        super.onStop()
        // The activity is no longer visible (it is now "stopped")
        Log.d(tag, "onStop")
    }

    public override fun onDestroy() {
        super.onDestroy()
        // The activity is about to be destroyed
        Log.d(tag, "onDestroy")
    }
}