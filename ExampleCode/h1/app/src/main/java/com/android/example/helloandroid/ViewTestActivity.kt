package com.android.example.helloandroid

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/**
 * 测试学习 view 的各种属性
 */
class ViewTestActivity : AppCompatActivity() {

    private val TAG = "ViewTestActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_test)

        Log.d(TAG, "onCreate")

    }
}