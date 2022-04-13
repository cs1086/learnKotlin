package com.example.learnkotlin.touch_event

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatButton

class MyButton: AppCompatButton {
    constructor(context:Context):super(context){

    }
    constructor(context:Context,attrs: AttributeSet):super(context,attrs) {

    }
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        println("####MyButton.dispatchTouchEvent(motionEvent=${ev?.action})")
        val result=super.dispatchTouchEvent(ev)
        println("####MyButton.dispatchTouchEvent.result=${result}")
        return result
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        println("####MyButton.onTouchEvent(motionEvent=${event?.action})")
        val result=super.onTouchEvent(event)
        println("####MyButton.onTouchEvent.result=${result}")
        return false
    }
}