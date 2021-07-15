package com.example.homework1.album

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.os.StrictMode
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener


/**
 * @author ltj
 * @since  2021/7/14 11:59
 */
class SignInActivity : AppCompatActivity() {
    private val TAG = "SignInActivity"

    private var cn = DBConnection()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.login_with_constraint_layout)

        if (Build.VERSION.SDK_INT > 9) {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }

        // 设置页面标题
        supportActionBar?.title = getString(R.string.album_app_name)

        val etEmail = findViewById<EditText>(R.id.editText)
        etEmail.addTextChangedListener {
            Log.d(TAG, "用户输入的 email 地址：${it}")
        }

        val etPassword = findViewById<EditText>(R.id.editText2)
        etPassword.addTextChangedListener {
            Log.d(TAG, "用户输入的 password：${it}")
        }

        findViewById<TextView>(R.id.textView3).setOnClickListener {
            val intent = Intent(this, ForgetPasswordActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.button).setOnClickListener {
            val progressBar = findViewById<ProgressBar>(R.id.progressBar)
            val progressBarMask = findViewById<View>(R.id.progressBarMask)

            progressBar.visibility = View.VISIBLE
            progressBarMask.visibility = View.VISIBLE

            it.postDelayed({
                progressBar.visibility = View.GONE
                progressBarMask.visibility = View.GONE

                val email = etEmail.text.toString()
                val password = etPassword.text.toString()
                val user = UserCenter.getUserByEmail(email)
                Thread(Runnable {
                    val sign=cn.query(email,password)
                    if (sign) {
                        Looper.prepare()
                        Toast.makeText(this, R.string.login_sign_in_susscess_tip, Toast.LENGTH_SHORT)
                            .show()
                        // 记录一下已经登陆的用户信息
                        UserCenter.signInUser = user
                        // jump to album activity
                        val intent = Intent(this, AlbumActivity::class.java)
                        startActivity(intent)
                        // 已经登陆，当前这个页面就没有必要存在于回退栈中了，也就是用户从相册页面返回的时候看不到这个页面，直接到桌面
                        finish()
                    } else {
                        Looper.prepare()
                        Toast.makeText(this, R.string.login_sign_in_failure_tip, Toast.LENGTH_SHORT)
                            .show()
                        Looper.loop()
                    }
                }).start()

            }, /* 延迟两秒执行，模拟网路耗时 */2000)
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            val uri = Uri.parse("https://www.google.com/account")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.textView5).setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

    }

}