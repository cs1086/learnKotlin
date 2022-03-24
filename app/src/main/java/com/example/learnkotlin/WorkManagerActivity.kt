package com.example.learnkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.work.*
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit

class WorkManagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)

        val constraint=Constraints.Builder().build()
        val data1= Data.Builder().putInt("time",10).build()
        val request= OneTimeWorkRequest.Builder(MyWork::class.java).setInputData(data1).setConstraints(constraint).build()
        val data2= Data.Builder().putInt("time",5).build()
        val request2= OneTimeWorkRequest.Builder(MyWork::class.java).setInputData(data2).setConstraints(constraint).build()
        val data3= Data.Builder().putInt("time",2).build()
        val request3= OneTimeWorkRequest.Builder(MyWork::class.java).setInputData(data3).setConstraints(constraint).build()
        val button=findViewById<Button>(R.id.button6)
        button.setOnClickListener{
            WorkManager.getInstance(this).beginUniqueWork("unique", ExistingWorkPolicy.APPEND, request).enqueue()
        }

        //val chain1=WorkManager.getInstance(this).beginWith(listOf(request2,request3)).then(request2)
//        val chain2=WorkManager.getInstance(this).beginWith(request2)
//        val chain3 = WorkContinuation
//            .combine(listOf(chain1, chain2))
//            .then(request3).enqueue()

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(request.id).observe(this){
            workInfo->println("####${workInfo.state},${workInfo.outputData.getString("data")}")
        }
    }
}