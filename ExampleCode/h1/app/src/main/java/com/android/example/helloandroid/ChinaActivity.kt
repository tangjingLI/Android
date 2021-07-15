package com.android.example.helloandroid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/**
 * 测试页面跳转的子页面
 */
class ChinaActivity : AppCompatActivity() {
    private val tag = "ChinaActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "onCreate")
        setContentView(R.layout.activity_china)

//        if (intent != null) {
//            Log.d(tag, "DataTrans, 接收到 name: ${intent.getStringExtra("name")}")
//            Log.d(tag, "DataTrans, 接收到 age: ${intent.getStringExtra("age")}")
//        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy")
    }
}