package com.example.learnkotlin.ui_test

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.learnkotlin.R
import java.text.SimpleDateFormat
import java.util.*

class DatePickerDialogActivity : AppCompatActivity() {
    lateinit var calendar:Calendar
    lateinit var dateButton:Button
    lateinit var timeButton:Button
    lateinit var submitButton:Button
    lateinit var builder:AlertDialog.Builder
    private val dateSetListener=DatePickerDialog.OnDateSetListener{
        view,year,month,date->
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DATE, date)
        val d=SimpleDateFormat("yyyy-MM-dd",Locale.TAIWAN)
        dateButton.text=d.format(calendar.time)
    }
    private val timeSetListener= TimePickerDialog.OnTimeSetListener{
            view,hour,minute->
        calendar.set(Calendar.HOUR, hour)
        calendar.set(Calendar.MINUTE, minute)
        val t=SimpleDateFormat("HH:mm",Locale.TAIWAN)
        timeButton.text=t.format(calendar.time)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_picker_dialog)
        dateButton=findViewById(R.id.date)
        timeButton=findViewById(R.id.time)
        submitButton=findViewById(R.id.submit)
        dateButton.setOnClickListener {
            dateClick()
        }
        timeButton.setOnClickListener {
            timeClick()
        }
        submitButton.setOnClickListener {
            sumitClick()
        }
        calendar= Calendar.getInstance()
        builder=AlertDialog.Builder(this)

        builder.setTitle("時間")
        builder.create()
        builder.setNegativeButton("cancel"){
                dialog,which->
            Log.e("####","dialog=${dialog},which=${which}")
        }
        builder.setPositiveButton("ok"){
                dialog,which->
            Log.e("####","dialog=${dialog},which=${which}")
        }
    }
    fun dateClick(){
        DatePickerDialog(this,dateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE)).show()
    }
    fun timeClick(){
        TimePickerDialog(this,timeSetListener,calendar.get(Calendar.HOUR),calendar.get(Calendar.MINUTE),true).show()
    }

    fun sumitClick(){
        val time=SimpleDateFormat("yyyy-MM-dd HH:mm",Locale.TAIWAN).format(calendar.time)
        builder.setMessage("${time}")


        builder.show()
    }
}