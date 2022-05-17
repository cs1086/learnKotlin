package com.example.learnkotlin.java_function.serializable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learnkotlin.R


class SerializableAndParcelable2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serializable_and_parcelable)
        val intent = intent
        //val user = intent.getSerializableExtra("user") as SerializableAndParcelableActivity.User?
        val user2 = intent.getParcelableExtra("user2") as SerializableAndParcelableActivity.User2?
        println("####name=${user2?.name},age=${user2?.age}")
    }

}