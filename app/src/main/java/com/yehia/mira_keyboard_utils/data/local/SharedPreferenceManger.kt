package com.yehia.mira_keyboard_utils.data.local

import android.content.Context
import com.yehia.mira_keyboard_utils.data.network.login_models.AuthData
import com.google.gson.Gson

class SharedPreferenceManger {
    companion object {

        val USER_DATA = "USER_DATA"

        fun saveData(context: Context, key: String, value: String) {
            val sharedPreference = context.getSharedPreferences("bytar", Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.putString(key, value)
            editor.apply()
        }

        fun saveData(context: Context, key: String, value: AuthData) {
            val sharedPreference = context.getSharedPreferences("bytar", Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()
            val gson = Gson()
            val json = gson.toJson(value)
            editor.putString(key, json)
            editor.apply()
        }

        fun loadData(context: Context, key: String): String? {
            val sharedPreference = context.getSharedPreferences("bytar", Context.MODE_PRIVATE)
            return sharedPreference.getString(key, "")
        }

        fun loadAuthData(context: Context, key: String): AuthData? {
            val sharedPreference = context.getSharedPreferences("bytar", Context.MODE_PRIVATE)

            val value = sharedPreference.getString(key, "")

            if (value != "") {
                val gson = Gson()
                return gson.fromJson(value, AuthData::class.java)
            } else {
                return null
            }
        }

    }
}