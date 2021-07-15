package com.android.example.helloandroid

import android.content.Context
import android.util.DisplayMetrics


/**
 * UI 工具类
 *
 * @author 高超（gaochao.cc）
 * @since 2021/6/19
 */
fun dp2px(dp: Float, context: Context): Int {
    return ((dp * context.resources.displayMetrics.densityDpi) / DisplayMetrics.DENSITY_DEFAULT).toInt()
}