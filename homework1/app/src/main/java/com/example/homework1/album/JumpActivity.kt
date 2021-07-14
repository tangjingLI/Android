package com.example.homework1.album

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @author ltj
 * @since  2021/7/14 15:24
 */
class JumpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (UserCenter.signInUser != null) {
            startActivity(Intent(this, AlbumActivity::class.java))
        } else {
            startActivity(Intent(this, SignInActivity::class.java))
        }
        // 就是一个跳转页面，没有必要留存
        finish()
    }
}