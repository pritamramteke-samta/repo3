package com.bgservice

import android.content.Intent
import android.util.Log
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

class MyBackgroundModule(private val reactContext: ReactApplicationContext) :
    ReactContextBaseJavaModule(reactContext) {

    override fun getName() = "MyBackgroundModule"

    @ReactMethod
    fun startBackgroundTask() {
        Log.d("MyBackgroundModule", "startBackgroundTask() called")

        val intent = Intent(reactContext, MyBackgroundService::class.java)
        reactContext.startService(intent)

        Log.d("MyBackgroundModule", "Intent to start MyBackgroundService dispatched")
    }
}
