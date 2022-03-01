package com.example.learnkotlin

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.Log
import android.view.MotionEvent
import java.util.*
import kotlin.concurrent.timer

class BallView: androidx.appcompat.widget.AppCompatImageView {
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    var customView: CustomView?=null;
    var deviceWidth=0
    var deviceHeight=0
    var navigationHeight=0
    var offsetX=10
    var offsetY=-10
    companion object {
        private const val TAG = "BallView"
    }
    init {
        val displayMetrics = DisplayMetrics()
        val activity=context as Activity
        activity.windowManager.defaultDisplay.getMetrics(displayMetrics)

        deviceWidth = displayMetrics.widthPixels
        deviceHeight = displayMetrics.heightPixels

        val resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
        //Get the height of the NavigationBar
        navigationHeight=resources.getDimensionPixelSize(resourceId)
        transfer()
    }
    fun setCrashView(customView: CustomView){
        this.customView=customView
    }
    override fun onTouchEvent(event: MotionEvent?): Boolean {

        return super.onTouchEvent(event)
    }

    fun transfer(){
        timer(initialDelay = 1000,period=30){
            rotation=rotation+5
            var nowX=(x+offsetX)
            var nowY=(y+offsetY)
            when{
                nowX>(deviceWidth-width)||nowX<0->offsetX=-offsetX

                nowY>(deviceHeight-height-navigationHeight)||nowY<0->offsetY=-offsetY

            }
            when{
               (nowX<customView!!.x+customView!!.width&&nowY<customView!!.y+customView!!.height)&&(nowX+width>customView!!.x&&nowY+height>customView!!.y)&&(nowX+width>customView!!.x&&nowY<customView!!.y+customView!!.height)&&(nowX<customView!!.x+width&&nowY+height>customView!!.y)->{offsetX=-offsetX;offsetY=-offsetY}
               //(nowX+width>customView!!.x&&nowY+height>customView!!.y)->{offsetX=-offsetX;offsetY=-offsetY}
               // (nowX+width>customView!!.x&&nowY<customView!!.y+customView!!.height)->{offsetX=-offsetX;offsetY=-offsetY}
               // (nowX<customView!!.x+width&&nowY+height>customView!!.y)->{offsetX=-offsetX;offsetY=-offsetY}
            }
            //Log.d(TAG, "transfer: offsetX=$offsetX,offsetY=$offsetY,x=$x,y=$y")
            x=(x+offsetX)
            y=(y+offsetY)

        }
    }
}