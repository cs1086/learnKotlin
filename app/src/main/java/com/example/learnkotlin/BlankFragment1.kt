package com.example.learnkotlin

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    override fun onAttach(context: Context) {
        println("####BlankFragment1.onAttach()")
        super.onAttach(context)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("####BlankFragment1.onCreate()")
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("####BlankFragment1.onCreateView")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        println("####BlankFragment1.onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        println("####BlankFragment1.onStart")
        super.onStart()
    }

    override fun onResume() {
        println("####BlankFragment1.onResume")
        super.onResume()
    }

    override fun onPause() {
        println("####BlankFragment1.onPause")
        super.onPause()
    }

    override fun onStop() {
        println("####BlankFragment1.onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        println("####BlankFragment1.onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        println("####BlankFragment1.onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        println("####BlankFragment1.onDetach")
        super.onDetach()
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}