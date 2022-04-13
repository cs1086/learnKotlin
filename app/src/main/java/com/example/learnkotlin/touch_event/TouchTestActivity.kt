package com.example.learnkotlin.touch_event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.learnkotlin.R

class TouchTestActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var constraintLayout: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_touch_test)
        constraintLayout=findViewById<ConstraintLayout?>(R.id.myConstraintLayout).apply {
            setOnClickListener {
                println("####事件MyLayout.setOnClickListener")
            }
            setOnTouchListener(object:View.OnTouchListener{
                override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                    println("####事件MyLayout.onTouch(motionEvent=${event?.action})")
                    return false
                }
            })
        }
        button=findViewById<Button?>(R.id.button8).apply {
            setOnClickListener {
                println("####事件MyButton.setOnClickListener")
            }
            setOnTouchListener(object:View.OnTouchListener{
                override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                    println("####事件MyButton.onTouch(motionEvent=${event?.action})")
                    return false
                }
            })
        }

    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        println("####TouchTestActivity.dispatchTouchEvent(motionEvent=${ev?.action})")
        val result=super.dispatchTouchEvent(ev)
        println("####TouchTestActivity.dispatchTouchEvent.result=${result}")
        return result
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        println("####TouchTestActivity.onTouchEvent(motionEvent=${event?.action})")
        val result=super.onTouchEvent(event)
        println("####TouchTestActivity.onTouchEvent.result=${result}")
        return result
    }

}