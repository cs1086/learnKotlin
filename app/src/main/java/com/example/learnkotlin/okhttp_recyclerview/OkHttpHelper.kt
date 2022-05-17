package com.example.learnkotlin.okhttp_recyclerview

import com.google.android.gms.common.util.JsonUtils
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONObject

class OkHttpHelper {
    companion object{
        fun getResponse(url:String):JSONArray{
            val client=OkHttpClient()
            val requestBuild=Request.Builder()
            val request=requestBuild.url(url).build()
            val response=client.newCall(request).execute()
            val result=response.body()!!.string()
            return JSONArray(result)
        }
    }
}