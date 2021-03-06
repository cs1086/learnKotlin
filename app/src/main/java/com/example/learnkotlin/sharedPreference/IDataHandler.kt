package com.example.learnkotlin.sharedPreference

interface IDataHandler {
    fun insert(input:String,cb: CallBack)
    fun select(key:String, cb: CallBack)
    interface CallBack{
        fun onSucess(info:String)
        fun onFailure(info:String)
    }
}