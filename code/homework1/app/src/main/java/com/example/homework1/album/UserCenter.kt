package com.example.homework1.album

/**
 * @author ltj
 * @since  2021/7/14 11:58
 */
object UserCenter {

    // user email -> user obj
    private val users = mutableMapOf<String, User>()

    var signInUser: User? = null

    fun addUser(user: User) {
        users[user.email] = user
    }

    fun getUserByEmail(email: String): User? {
        return users[email]
    }
}