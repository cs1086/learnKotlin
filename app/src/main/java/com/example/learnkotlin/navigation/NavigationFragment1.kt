package com.example.learnkotlin.navigation

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.learnkotlin.R
import com.example.learnkotlin.databinding.FragmentNavigation1Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NavigationFragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class NavigationFragment1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var fragmentNavigation1Binding:FragmentNavigation1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("####fragment1.onCreate")
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("####fragment1.onCreateView")

        // Inflate the layout for this fragment
        fragmentNavigation1Binding = DataBindingUtil.inflate(inflater,R.layout.fragment_navigation1,container,false)
        return fragmentNavigation1Binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("####fragment1.onViewCreated")
        val changeToFragment=view.findViewById<Button>(R.id.change_to_fragment2)
        changeToFragment.setText(arguments?.getString("params")?:"無獲得參數")//從deeplink 的url後的參數拿
        changeToFragment.setOnClickListener {
            val navController:NavController=findNavController()
            val bundle=Bundle()
            bundle.putString("myName","大鼓祥平")
            bundle.putStringArray("myAccount", arrayOf<String>("abc123","tt123"))
            navController.navigate(R.id.action_navigationFragment1_to_navigationFragment2,bundle)
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        println("####fragment1.onActivityCreated")
        val navigationViewModel:NavigationViewModel=ViewModelProvider(activity as ViewModelStoreOwner).get(NavigationViewModel::class.java)
        println("####fragment1.navigationViewModel=$navigationViewModel")
        fragmentNavigation1Binding.data=navigationViewModel
        fragmentNavigation1Binding.lifecycleOwner=activity
        fragmentNavigation1Binding.seekBar2.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                navigationViewModel.number.value=progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        println("####fragment1.onStart")
        super.onStart()
    }

    override fun onResume() {
        println("####fragment1.onResume")
        super.onResume()
    }
    override fun onDestroy() {
        println("####fragment1.onDestroy")
        super.onDestroy()
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NavigationFragment1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NavigationFragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}