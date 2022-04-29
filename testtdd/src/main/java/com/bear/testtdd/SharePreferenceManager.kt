package com.bear.testtdd

import android.content.Context
import android.content.SharedPreferences

class SharePreferenceManager(override val context: Context) :ISharePreferenceManager{
    val sharedPreferences:SharedPreferences
    val shareKey="data"
    init {
        sharedPreferences=context.getSharedPreferences(shareKey,Context.MODE_PRIVATE)
    }

    override fun saveString(key: String, value: String) {
        sharedPreferences.edit().putString(key,value).apply()
    }

    override fun getString(key: String): String {
        return sharedPreferences.getString(key,"")!!
    }
}
interface ISharePreferenceManager{
    val context:Context
    fun saveString(key:String,value:String)
    fun getString(key:String):String
}