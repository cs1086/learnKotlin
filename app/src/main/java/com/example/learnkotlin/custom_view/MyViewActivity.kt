package com.example.learnkotlin.custom_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import com.example.learnkotlin.R

class MyViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_view)
    }
    class MyView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)
            val paint= Paint()
            paint.color= Color.RED
            paint.style= Paint.Style.FILL_AND_STROKE
            paint.setStrokeWidth(600f)
            canvas?.drawCircle(360f,360f,20f,paint)
        }
    }
}