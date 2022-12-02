package com.app.printollo.consts

import android.content.Context
import android.content.SharedPreferences

class UserManager (context: Context) {
    private var prefs: SharedPreferences = context.getSharedPreferences("user", Context.MODE_PRIVATE)

    companion object {
        const val USER = "user"
    }
    fun saveUser(token: String) {
        val editor = prefs.edit()
        editor.putString(USER, token)
        editor.apply()
    }
    fun fetchUser(): String? {
        return prefs.getString(USER, null)
    }
}