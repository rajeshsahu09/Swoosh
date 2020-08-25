package com.example.swoosh.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

open class BaseActivity : AppCompatActivity() {
    val log = "LifeCycle"
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(log, "${javaClass.simpleName} onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        Log.d(log, "${javaClass.simpleName} onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d(log, "${javaClass.simpleName} onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(log, "${javaClass.simpleName} onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(log, "${javaClass.simpleName} onStop")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(log, "${javaClass.simpleName} onRestart")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(log, "${javaClass.simpleName} onDestory")
        super.onDestroy()
    }
}