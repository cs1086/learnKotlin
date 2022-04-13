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
        val result=super.dispatchTouchEvent(ev)
        println("####MyLayout.dispatchTouchEvent.result=${result}")
        return result
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        println("####MyLayout.onTouchEvent(motionEvent=${event?.action})")
        val result=super.onTouchEvent(event)
        println("####MyLayout.onTouchEvent.result=${result}")
        return result
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        println("####MyLayout.onInterceptTouchEvent(motionEvent=${ev?.action})")
        val result=super.onInterceptTouchEvent(ev)
        println("####MyLayout.onInterceptTouchEvent.result=${result}")
        return result
    }
}