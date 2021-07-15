package com.android.example.helloandroid

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout

/**
 * 学习测试 frame layout
 */
class FrameLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_layout)
    }

//    private fun setContentViewByProgram() {
//        val frameLayout = FrameLayout(this)
//        val view1 = View(this, ViewGroup.LayoutParams())
//    }
}