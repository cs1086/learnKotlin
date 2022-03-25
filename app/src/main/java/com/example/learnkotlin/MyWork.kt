package com.example.learnkotlin

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

class MyWork(context: Context,params: WorkerParameters): Worker(context,params) {
    override fun doWork(): Result {
        println("####MyWork.doWork${Thread.currentThread()}")
        var i=0
            while(i<inputData.getInt("time",10)){println("####MyWork${i++}")
            Thread.sleep(1000)
        }
        val outPutData=workDataOf("data" to "王柏榕")
        return Result.success(outPutData)
    }
}
class MyWork2(context: Context,params: WorkerParameters): Worker(context,params) {
    override fun doWork(): Result {
        println("####MyWork2.doWork${Thread.currentThread()}")
        var i=0
        while(i<inputData.getInt("time",10)){println("####MyWork2=${i++}")
            Thread.sleep(1000)
        }
        val outPutData=workDataOf("data" to "王柏榕")
        return Result.success(outPutData)
    }
}