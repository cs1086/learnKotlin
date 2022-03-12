package com.example.learnkotlin
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import java.util.*
//參考 https://ithelp.ithome.com.tw/articles/10207491
class SwipeRefreshActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe_refresh)
        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager= GridLayoutManager(this,2)
        recyclerView.adapter=Adapter(this,getDataList())
        swipeRefreshLayout=findViewById(R.id.swipeRefreshLayout)
        //使用 setProgressViewOffset 設定滑下時，螢幕上旋轉的圖示
        //第一個布林值為圖示在下拉時會不會有從小變到大的特效
        //第二個參數為圖示出現的起點
        //第三個參數為圖示出現的終點
        swipeRefreshLayout.setProgressViewOffset(true, 0, 100)
        //setSize 可以設定圖示的大小
        swipeRefreshLayout.setSize(SwipeRefreshLayout.LARGE)


    //setOnRefreshListener 這邊規定下拉之後要做的事情
    //使用 Thread.sleep 是為了模擬負載較重的狀況
    //然後呼叫我們在 Adapter 中所寫對外開放的方法 addListItem
    //最後設定 isRefreshing 讓刷新狀態停止
        swipeRefreshLayout.setOnRefreshListener {
            Thread.sleep(1000)
            (recyclerView.adapter as Adapter).addListItem(getRandomColor())

            swipeRefreshLayout.isRefreshing = false
        }
    }
    //隨機顏色
    fun getRandomColor(): Int {
        val rnd = Random()
        return Color.rgb(
            rnd.nextInt(256),
            rnd.nextInt(256),
            rnd.nextInt(256)
        )
    }
    fun getDataList(): MutableList<InfoItem> {
        val map= mutableMapOf("blue_leader" to "ProgressControl","blue_manager" to "DatePick","blue_player_01" to "小春","blue_player_03" to "林敬倫","blue_player_08" to "小八","blue_player_09" to "李佳薇","blue_player_12" to "顏佑庭","blue_player_18" to "洗菜","blue_player_27" to "采子","blue_player_52" to "潘君侖","blue_player_55" to "李思緯","blue_player_56" to "小刀")
        val list = arrayListOf<InfoItem>()
        map.forEach{
            val str = it.component2()
            list.add(InfoItem(str,1))
        }
        println("####list=$list")
        return list
    }
    class Adapter(val context: Context, val list:MutableList<InfoItem>):RecyclerView.Adapter<Adapter.MyViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item, parent, false)
            return MyViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            println("####color=${list[position].color}")
//            holder.imageView.setColorFilter(list[position].color)
            holder.imageView.setImageResource(R.drawable.blue_player_27)
            holder.memo.text = list[position].name

        }

        override fun getItemCount(): Int {
            return list.size
        }
        fun addListItem(color:Int){
            var size=list.size+1
            list.add(0,InfoItem("全明星成員${size++}號",color))
            notifyDataSetChanged()
        }

        inner class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
            var memo = view.findViewById<TextView>(R.id.memo)
            var imageView = view.findViewById<ImageView>(R.id.imageView)
            fun bind(position: Int) {
                memo.text = list[position].name
                imageView.setColorFilter(list[position].color)
            }
        }
    }
    data class InfoItem(var name:String,var color:Int)
}