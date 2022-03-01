package com.example.learnkotlin

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PageViewerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PageViewerFragment : Fragment() {


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    var pagerText:TextView?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_page_viewer, container, false)
        pagerText=view.findViewById<TextView>(R.id.pagerText)
        getImages();
        pagerText?.text="1 / ${imageList.size}"
        var p=view.findViewById<androidx.viewpager.widget.ViewPager>(R.id.pager)
        p.adapter=CustomAdapter(context!!,imageList)
        p.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
                Log.d(TAG,"onPageScrollStateChanged.state=$state")
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                Log.d(TAG,"onPageScrolled.state=$position,positionOffset=$positionOffset,positionOffsetPixels=$positionOffsetPixels")
                val currentPosition = position + 1
                pagerText?.text = "$currentPosition / ${imageList.size}"
            }

            override fun onPageSelected(position: Int) {
                Log.d(TAG,"onPageSelected.state=$position")
            }
        })
        return view
    }

    companion object {
        private const val TAG = "PageViewerFragment"
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PageViewerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                PageViewerFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
    var imageList:ArrayList<Int> =arrayListOf()
    fun getImages(){
        val map= mutableMapOf("blue_leader" to "錢薇娟","blue_manager" to "孟潔","blue_player_01" to "小春","blue_player_03" to "林敬倫","blue_player_08" to "小八","blue_player_09" to "李佳薇","blue_player_12" to "顏佑庭","blue_player_18" to "洗菜","blue_player_27" to "采子","blue_player_52" to "潘君侖","blue_player_55" to "李思緯","blue_player_56" to "小刀")
        map.forEach{
            val str = it.component1()
            imageList.add(context?.resources?.getIdentifier(str,"drawable",context?.packageName)!!)
        }
    }
    class CustomAdapter:PagerAdapter{
        val context: Context
        val imageList:MutableList<Int>
        constructor(context: Context,imageList:MutableList<Int>){
            this.context=context
            this.imageList=imageList
        }
        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view==`object`
        }

        override fun getCount(): Int {
            return imageList.size
        }
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val inflater =
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            val v = inflater.inflate(R.layout.image_layout, container, false)
            val imageView=v.findViewById<ImageView>(R.id.imageView)
            imageView.setImageResource(imageList[position])
            container.addView(v)

            return v
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as ConstraintLayout)
        }

    }
}