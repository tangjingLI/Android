package com.android.example.album

/**
 * 表示用户的数据类
 *
 * @author 高超（gaochao.cc）
 * @since 2021/7/10
 */
data class User(
    val name: String,
    val email: String,
    val password: String,
    val age: Int,
    val gender: String,
    val address: String
)