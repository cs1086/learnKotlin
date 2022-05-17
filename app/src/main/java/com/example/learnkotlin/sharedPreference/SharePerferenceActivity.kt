package com.example.learnkotlin.sharedPreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.learnkotlin.R

class SharePerferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_perference)
        val button2=findViewById<Button>(R.id.button2)
        val button3=findViewById<Button>(R.id.button3)
        val preference= Preference(this)
        button2.setOnClickListener{
            preference.insert("帶資穎",object: IDataHandler.CallBack {
                override fun onSucess(info: String) {
                    Log.d("####","onSucess=$String")

                    Toast.makeText(this@SharePerferenceActivity,"name $info is save",Toast.LENGTH_LONG).show()
                }

                override fun onFailure(info: String) {
                    Log.d("####","onFailure=$String")
                    Toast.makeText(this@SharePerferenceActivity,"name save is onFailure",Toast.LENGTH_LONG).show()
                }
            })
        }
        button3.setOnClickListener{
            preference.select("name",object: IDataHandler.CallBack {
                override fun onSucess(info: String) {
                    Log.d("####","onSucess=$String")
                    Toast.makeText(this@SharePerferenceActivity,"name $info is show",Toast.LENGTH_LONG).show()
                }

                override fun onFailure(info: String) {
                    Log.d("####","onFailure=$String")
                    Toast.makeText(this@SharePerferenceActivity,"name show is onFailure",Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}