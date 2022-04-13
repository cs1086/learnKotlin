package com.example.learnkotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CoordinatorLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinator_layout)
        val recycler: RecyclerView =findViewById(R.id.r_view)
        recycler.layoutManager= LinearLayoutManager(this)
        var adapter= HomeFragment.Adapter(this!!, getDataList())
        recycler.adapter = adapter
    }
    fun getDataList(): MutableList<ImageModel> {
        val map= mutableMapOf("blue_leader" to "ProgressControl","blue_manager" to "DatePick","blue_player_01" to "小春","blue_player_03" to "林敬倫","blue_player_08" to "小八","blue_player_09" to "李佳薇","blue_player_12" to "顏佑庭","blue_player_18" to "洗菜","blue_player_27" to "采子","blue_player_52" to "潘君侖","blue_player_55" to "李思緯","blue_player_56" to "小刀")
        val list = arrayListOf<ImageModel>()
        map.forEach{
            val str = it.component2()
            list.add(ImageModel(findResourceIdByString(it.component1()), str))
        }
        return list
    }
    fun findResourceIdByString(str: String): Int {
        return this.resources.getIdentifier(str, "drawable", this.packageName)
    }
    class Adapter: RecyclerView.Adapter<Adapter.MyViewHolder>{
        var context: Context
        var dataList: MutableList<ImageModel>
        constructor(context: Context, dataList:MutableList<ImageModel>):super(){
            this.context = context
            this.dataList = dataList
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item, parent, false)
            return MyViewHolder(view)
        }

        override fun getItemCount(): Int {
            return dataList.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.imageView.setImageResource(dataList[position].imgId)
            holder.memo.text = dataList[position].memo
            holder.memo.setOnClickListener{x->
                when(position){
                    0->context.startActivity(Intent(context,ProgressControlActivity::class.java))
                    1->context.startActivity(Intent(context,DatePickerDialogActivity::class.java))
                    else->print("")
                }

            }
        }
        class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            var memo = view.findViewById<TextView>(R.id.memo)
            var imageView = view.findViewById<ImageView>(R.id.imageView)
        }
    }
}