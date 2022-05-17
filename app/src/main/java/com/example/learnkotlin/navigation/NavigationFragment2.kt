package com.example.learnkotlin.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.get
import androidx.navigation.Navigation
import com.example.learnkotlin.R
import com.example.learnkotlin.databinding.FragmentNavigation2Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NavigationFragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class NavigationFragment2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentNavigation2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        println("####fragment2.onCreate")
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("####fragment2.onCreateView")
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_navigation2,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("####fragment2.onViewCreated")
        val button=view.findViewById<Button>(R.id.back_to_fragment1)
        button.setText(arguments?.getString("myName"))
        button.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_navigationFragment2_to_navigation3))
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        println("####fragment2.onActivityCreated")
        val viewModel=ViewModelProvider(requireActivity()).get(NavigationViewModel::class.java)
        println("####fragment2.navigationViewModel=$viewModel")
        binding.data=viewModel
        binding.lifecycleOwner=activity
        super.onActivityCreated(savedInstanceState)
    }
    override fun onDestroy() {
        println("####fragment2.onDestroy")
        super.onDestroy()
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NavigationFragment2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NavigationFragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}