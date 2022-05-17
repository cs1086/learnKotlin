package com.example.learnkotlin.sharedPreference

import android.content.Context
import android.content.SharedPreferences
import java.lang.Exception

class Preference: IDataHandler {
    lateinit var preference: SharedPreferences
    constructor(context:Context){
        preference=context.getSharedPreferences("MyPreferences",Context.MODE_PRIVATE)
    }
    override fun insert(input: String, cb: IDataHandler.CallBack) {
        val editor=preference.edit()
        try {
            editor.putString("name",input).apply()
            cb.onSucess(input)
        }catch (e:Exception){
            cb.onFailure(input)
        }
    }

    override fun select(key: String, cb: IDataHandler.CallBack) {
        try {
            val result=preference.getString(key,"default")
            cb.onSucess(result!!)
        }catch (e:Exception){
            cb.onFailure(e.message.toString())
        }
    }

    fun selectAll():MutableList<String>{
        val list=mutableListOf<String>()
        preference.all.keys.forEach{
            val value=preference.getString(it,"default")
            list.add(value!!)
        }
//        for(i in preference.all.keys){
//            val value=preference.getString(i,"default")
//            list.add(value!!)
//        }
        return list
    }

}