package com.bear.testtdd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class NumberSelectActivity : AppCompatActivity(){
    lateinit var numberSelectComponent: NumberSelectComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.number_select)
        numberSelectComponent=findViewById(R.id.numberSelect)
        numberSelectComponent.setListener(object : NumberSelectComponent.NumberSelectListener{
            override fun onValueChange(value: Int) {
                println("####setListener資料收到=$value")
            }
        })
    }
}