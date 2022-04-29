package com.bear.testtdd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    var account="abc"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharePreferenceManager = SharePreferenceManager(this)
        val intent = Intent(this,ResultActivity::class.java)
        val button=findViewById<Button>(R.id.login)
        val builder=AlertDialog.Builder(this)
        button.setOnClickListener {
            findViewById<EditText>(R.id.account).apply {
                account=this.text.toString()
                if(RegisterVerify().checkAccount(account)){
                    Repository(sharePreferenceManager).saveUserId(account)
                    startActivity(intent)
                }else{
                    builder.setMessage("註冊失敗").setTitle("錯誤")
                    builder.show()
                }
            }
        }
    }
}