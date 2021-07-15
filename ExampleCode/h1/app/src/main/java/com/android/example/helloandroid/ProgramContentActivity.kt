package com.android.example.helloandroid

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity

/**
 * 展示通过代码来动态构建界面的方式
 */
class ProgramContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewByProgram()
    }

    private fun setContentViewByProgram() {
        val frameLayout = FrameLayout(this)
        frameLayout.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        )
        val view1 = View(this)
        view1.layoutParams = FrameLayout.LayoutParams(
            dp2px(80f, this),
            dp2px(80f, this)
        )
        view1.setBackgroundColor(Color.RED)
        view1.alpha = 1f
        val view2 = View(this)
        view2.layoutParams = FrameLayout.LayoutParams(
            dp2px(100f, this),
            dp2px(100f, this)
        )
        view2.setBackgroundColor(Color.GREEN)
        frameLayout.addView(view2)
        frameLayout.addView(view1)
        setContentView(frameLayout)
    }
}