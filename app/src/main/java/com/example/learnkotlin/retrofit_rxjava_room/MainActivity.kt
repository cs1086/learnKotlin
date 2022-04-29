package com.example.learnkotlin.retrofit_rxjava_room

import android.app.Notification
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.learnkotlin.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable

import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //rxjava
        val list= arrayOf("王柏榕","王威晨","彭政閔")
        //從陣列取得資料轉成Observalble 
        Observable.fromArray(list).observeOn(Schedulers.io())
            .subscribe(object :Observer<Array<String>>{
                override fun onSubscribe(d: Disposable) {
                    println("####onSubscribe")
                }
                override fun onError(e: Throwable) {
                    println("####onError")
                }

                override fun onComplete() {
                    println("####onComplete")
                }

                override fun onNext(t: Array<String>) {
                    println("####onNext.t="+t)
                }
            })
    }
}