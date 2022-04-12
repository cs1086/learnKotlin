package com.example.learnkotlin.touch_event

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout

class MyLayout: ConstraintLayout {
    constructor(context:Context):super(context){

    }
    constructor(context:Context,attrs: AttributeSet):super(context,attrs){

    }
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        println("####MyLayout.dispatchTouchEvent(motionEvent=${ev?.action})")
//        val result=super.dispatchTouchEvent(ev)
//        println("####${result}")
        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        println("####MyLayout.onTouchEvent(motionEvent=${event?.action})")
        return super.onTouchEvent(event)
        //return false
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        println("####MyLayout.onInterceptTouchEvent(motionEvent=${ev?.action})")
//        val result=super.onInterceptTouchEvent(ev)
//        println("####${result}")
        return super.onInterceptTouchEvent(ev)
    }
}