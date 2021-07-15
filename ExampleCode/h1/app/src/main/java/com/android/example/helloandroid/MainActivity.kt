package com.android.example.helloandroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/**
 * App 的默认首页，在 AndroidManifest 中设置
 */
class MainActivity : AppCompatActivity() {
    private val tag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "onCreate")
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.jumpToChina).setOnClickListener { jumpButton ->
            val jumpIntent = Intent()
            jumpIntent.action = "com.bytedance.android.example.action.CHINA_ACTIVITY"
            val bundle = Bundle()
            bundle.putString("name", "jack")
            bundle.putString("age", "20")
            jumpIntent.putExtras(bundle)
//            Log.d(tag, "DataTrans, 存放 name: jack")
//            Log.d(tag, "DataTrans, 存放 age: 20")
            startActivity(jumpIntent)
        }

        findViewById<Button>(R.id.jumpToViewTest).setOnClickListener {
            val jumpIntent = Intent(this, ViewTestActivity::class.java)
            startActivity(jumpIntent)
        }

        findViewById<Button>(R.id.jumpToProgramView).setOnClickListener {
            val jumpIntent = Intent(this, ProgramContentActivity::class.java)
            startActivity(jumpIntent)
        }
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