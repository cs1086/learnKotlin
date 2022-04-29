package com.bear.testtdd

import android.content.Context
import android.content.SharedPreferences

class Repository(val sharePreferenceManager:ISharePreferenceManager){
    fun saveUserId(account:String){
        sharePreferenceManager.saveString("account",account)
    }
}