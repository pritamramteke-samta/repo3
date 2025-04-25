package com.bgservice

import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.facebook.react.HeadlessJsTaskService
import com.facebook.react.jstasks.HeadlessJsTaskConfig
import com.facebook.react.bridge.Arguments
import java.util.*

class MyBackgroundService : HeadlessJsTaskService() {

    companion object {
        private const val TAG = "MyBackgroundService"
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "🔄 onStartCommand called with intent: $intent")

        // 🧠 Required to allow Headless JS to start
        HeadlessJsTaskService.acquireWakeLockNow(applicationContext)
        Log.d(TAG, "⚡️ acquireWakeLockNow called to trigger JS")

        // Use the super method to properly support HeadlessJsTaskService
        return super.onStartCommand(intent, flags, startId)
    }

    override fun getTaskConfig(intent: Intent?): HeadlessJsTaskConfig? {
        Log.d(TAG, "📦 getTaskConfig called")

        val extras = Arguments.createMap().apply {
            putString("message", "Triggered from Kotlin!")
            putDouble("timestamp", Date().time.toDouble())
        }

        Log.d(TAG, "🧳 Passing extras to Headless JS task: $extras")

        return HeadlessJsTaskConfig(
            "MyBackgroundTask", // Must match JS registration
            extras,
            5000, // Timeout in ms
            true  // Allow while app is in background
        )
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.d(TAG, "❌ onBind() called - returning null")
        return null
    }
}
