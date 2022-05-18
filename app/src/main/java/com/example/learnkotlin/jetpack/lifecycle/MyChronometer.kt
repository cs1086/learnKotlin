package com.example.learnkotlin.jetpack.lifecycle

import android.content.Context
import android.os.SystemClock
import android.util.AttributeSet
import android.widget.Chronometer
import androidx.lifecycle.*
import java.util.jar.Attributes
//LifeCycle做法1，實作LifecycleEventObserver介面
class MyChronometer(context: Context, attributeSet: AttributeSet) :
    Chronometer(context, attributeSet) , LifecycleEventObserver {
    var elapsedTime:Long=0;
    private fun pauseMeter() {
        //base代表這個元件的開始基底時間  SystemClock.elapsedRealtime()代表手機開機到現在經過的時間，就算手機睡眠也不暫停
        elapsedTime = SystemClock.elapsedRealtime() - base
        stop()
    }

    private fun resumeMeter(){
       base= SystemClock.elapsedRealtime()-elapsedTime
        start()
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        println("####MyChronometer.onStateChanged=${source},event=${event}")
        when(event){
            Lifecycle.Event.ON_PAUSE->pauseMeter()
            Lifecycle.Event.ON_RESUME->resumeMeter()
        }
    }
}
//LifeCycle做法2，實作DefaultLifecycleObserver介面
class MyChronometer2(context: Context, attributeSet: AttributeSet) :
    Chronometer(context, attributeSet) , DefaultLifecycleObserver {
    var elapsedTime:Long=0;
    override fun onResume(owner: LifecycleOwner) {
        println("####MyChronometer2.onResume")
        resumeMeter()
        super.onResume(owner)
    }

    override fun onPause(owner: LifecycleOwner) {
        println("####MyChronometer2.onPause")
        pauseMeter()
        super.onPause(owner)
    }
    private fun pauseMeter() {
        //base代表這個元件的開始基底時間  SystemClock.elapsedRealtime()代表手機開機到現在經過的時間，就算手機睡眠也不暫停
        elapsedTime = SystemClock.elapsedRealtime() - base
        stop()
    }
    private fun resumeMeter(){
        base= SystemClock.elapsedRealtime()-elapsedTime
        start()
    }
}