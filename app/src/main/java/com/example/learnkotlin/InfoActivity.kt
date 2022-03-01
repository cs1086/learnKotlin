package com.example.learnkotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        val projects: ArrayList<ProjectModel>? = intent.extras?.getParcelableArrayList("projects")
        val adapter=MyAdapter(this,projects!!)
        val info_recycler=findViewById<RecyclerView>(R.id.info_recycler)
        info_recycler.layoutManager=LinearLayoutManager(this)
        info_recycler.adapter=adapter;

    }
    class MyAdapter(val context: Context, val arrayList:ArrayList<ProjectModel>):
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item, parent, false)
            return MyViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.memo.text=arrayList[position].projectName
        }

        override fun getItemCount(): Int {
            return arrayList.size
        }
        class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            var memo = view.findViewById<TextView>(R.id.memo)
            var imageView = view.findViewById<ImageView>(R.id.imageView)
        }
    }
}