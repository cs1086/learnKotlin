package com.example.learnkotlin.jetpack.work_manager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.work.*
import com.example.learnkotlin.R

class WorkManagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)
        val constraint=Constraints.Builder().build()
        constraint.setRequiredNetworkType(NetworkType.CONNECTED)
        val data1= Data.Builder().putInt("time",10).build()
        val request= OneTimeWorkRequest.Builder(MyWork::class.java).setInputData(data1).setConstraints(constraint).build()
        val data2= Data.Builder().putInt("time",5).build()
        val request2= OneTimeWorkRequest.Builder(MyWork::class.java).setInputData(data2).build()
        val data3= Data.Builder().putInt("time",2).build()
        val request3= OneTimeWorkRequest.Builder(MyWork::class.java).setInputData(data3).setConstraints(constraint).build()
        val button=findViewById<Button>(R.id.button6)
        val button7=findViewById<Button>(R.id.button7)
        button7.setOnClickListener{
            WorkManager.getInstance(this).beginUniqueWork("unique", ExistingWorkPolicy.KEEP, request).enqueue()
        }

        button.setOnClickListener{
            WorkManager.getInstance(this).beginUniqueWork("unique", ExistingWorkPolicy.APPEND_OR_REPLACE, request2).enqueue()
        }

        val chain1=WorkManager.getInstance(this).beginWith(listOf(request2,request3)).then(request2)
//        val chain2=WorkManager.getInstance(this).beginWith(request2)
//        val chain3 = WorkContinuation
//            .combine(listOf(chain1, chain2))
//            .then(request3).enqueue()

//        WorkManager.getInstance(this).getWorkInfoByIdLiveData(request.id).observe(this){
//            workInfo->println("####${workInfo.state},${workInfo.outputData.getString("data")}")
//        }
//        WorkManager.getInstance(this).getWorkInfoByIdLiveData(request2.id).observe(this){
//                workInfo->println("####${workInfo.state},${workInfo.outputData.getString("data")}")
//        }
    }
}