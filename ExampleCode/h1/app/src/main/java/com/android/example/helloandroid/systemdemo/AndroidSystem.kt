package com.android.example.helloandroid.systemdemo

/**
 * 展示 android 系统基本过程
 *
 * @author 高超（gaochao.cc）
 * @since 2021/6/13
 */
object AndroidSystem {
    @JvmStatic
    fun main(args: Array<String>) {
        while (true) {
            waitForLaunch()

            val app = AndroidApp()
            app.start()

            // 运行一段时间之后，用户手动退出 app
            app.stop()
        }
    }

    private fun waitForLaunch() {
    }
}