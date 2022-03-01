package com.example.learnkotlin

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.Log
import android.view.MotionEvent


class CustomView: androidx.appcompat.widget.AppCompatImageView {
    var oriDistance=0.0
    var offsetX=0.0f
    var offsetY=0.0f
    var originalX=0.0f
    var originalY=0.0f
    var deviceWidth=0
    var deviceHeight=0
    var navigationHeight=0
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    init {
        val displayMetrics = DisplayMetrics()
        val activity=context as Activity
        activity.windowManager.defaultDisplay.getMetrics(displayMetrics)

        deviceWidth = displayMetrics.widthPixels
        deviceHeight = displayMetrics.heightPixels

        val resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
        //Get the height of the NavigationBar
        navigationHeight=resources.getDimensionPixelSize(resourceId)
    }
    companion object {
        private const val TAG = "CustomView"
    }
    override fun onTouchEvent(event: MotionEvent?): Boolean {

        Log.d(TAG, "onTouchEvent: event=$event,actionmask=${event?.actionMasked}")
        when(event?.action){
            MotionEvent.ACTION_DOWN->{
                //Log.d(TAG, "onTouchEventaction:down,x=${event.x},y=${event.y}")
                originalX=event.x
                originalY=event.y
            }
            MotionEvent.ACTION_MOVE->{
                try {
                    val x1 = event.getX(0)
                    val y1 = event.getY(0)
                    val x2 = event.getX(1)
                    val y2 = event.getY(1)

                    var distance = getDistance(x1, y1, x2, y2)

                    var ratio = distance / oriDistance
                    scaleImage(ratio)
                    this.oriDistance = distance
                } catch (e: Exception) {
                }
//
//                offsetX=event.x-originalX
//                offsetY=event.y-originalY
//                var nowX=x+offsetX
//                var nowY=y+offsetY
//                if(nowX<deviceWidth-width && nowX>0 && nowY<deviceHeight-height-navigationHeight && nowY>0){
//                    x=x+offsetX
//                    y=y+offsetY
//                }
                //Log.d(TAG, "onTouchEventaction:move,x=${event.x},y=${event.y}")
            }
            MotionEvent.ACTION_POINTER_UP->{
                oriDistance = getDistance(
                        event.getX(0),
                        event.getY(0),
                        event.getX(1),
                        event.getY(1)
                )
            }
        }
        //super.onTouchEvent(event)
        return true
    }
    fun getDistance(x1: Float, y1: Float, x2: Float, y2: Float): Double {
        return Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)).toDouble())
    }
    fun scaleImage(ratio: Double) {

        if (ratio > 1) {
            val increasedWidth = this.width * (ratio - 1)
            val increasedHeight = this.height * (ratio - 1)

            val left = this.left - (increasedWidth / 2)
            val right = this.right + (increasedWidth / 2)
            val top = this.top - (increasedHeight / 2)
            val bottom = this.bottom + (increasedHeight / 2)

            setFrame(left.toInt(), top.toInt(), right.toInt(), bottom.toInt())

        } else if (ratio < 1) {
            val decreasedWidth = this.width * (1 - ratio)
            val decreasedHeight = this.height * (1 - ratio)

            val left = this.left + (decreasedWidth / 2)
            val right = this.right - (decreasedWidth / 2)
            val top = this.top + (decreasedHeight / 2)
            val bottom = this.bottom - (decreasedHeight / 2)

            setFrame(left.toInt(), top.toInt(), right.toInt(), bottom.toInt())
        }
    }
}