package com.bear.testtdd
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharePreferenceManager = SharePreferenceManager(this)
        val intent = Intent(this,ResultActivity::class.java)
        val builder=AlertDialog.Builder(this)

        login.setOnClickListener {
            val accountStr=account.text.toString()
            val passwordStr=password.text.toString()
            if(RegisterVerify().checkAccount(accountStr)){
                Repository(sharePreferenceManager).saveUserId(accountStr)
                intent.putExtra("account",accountStr)
                startActivity(intent)
            }else{
                builder.setMessage("註冊失敗").setTitle("錯誤")
                builder.show()
            }
        }
    }
}