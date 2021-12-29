package kr.hs.dgsw.hackathon.songil

import android.content.Context
import android.content.SharedPreferences

object SharedPreference {
    lateinit var sharedPreferences: SharedPreferences
    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences("TokenPrefs", Context.MODE_PRIVATE)
    }
    var token: String
            get() = sharedPreferences.getString("token", "") ?: ""
            set(value) {
                val edit = sharedPreferences.edit()
                edit.putString("token", value)
                edit.apply()
            }
}