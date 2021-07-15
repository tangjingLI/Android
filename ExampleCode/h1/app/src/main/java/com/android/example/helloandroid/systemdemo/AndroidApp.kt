package com.android.example.helloandroid.systemdemo

/**
 * Android app 基本过程
 *
 * @author 高超（gaochao.cc）
 * @since 2021/6/13
 */
class AndroidApp {
    private val activity = Activity()

    fun start() {
        activity.onCreate()
        activity.onStart()
        activity.onResume()
    }

    fun stop() {
        activity.onPause()
        activity.onStop()
        activity.onDestroy()
    }
}