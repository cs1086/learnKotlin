package com.example.learnkotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view  =inflater.inflate(R.layout.fragment_home, container, false)
        val recycler: RecyclerView =view.findViewById(R.id.recycler)
        recycler.layoutManager= LinearLayoutManager(context)
        var adapter= Adapter(context!!, getDataList())
        recycler.adapter = adapter
        return view

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
        return this.resources.getIdentifier(str, "drawable", context?.packageName)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                HomeFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
    class Adapter: RecyclerView.Adapter<Adapter.MyViewHolder>{
        var context: Context
        var dataList: MutableList<ImageModel>
        constructor(context:Context,dataList:MutableList<ImageModel>):super(){
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