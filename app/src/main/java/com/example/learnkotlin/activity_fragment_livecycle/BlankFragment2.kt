package com.example.learnkotlin.activity_fragment_livecycle

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.learnkotlin.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    override fun onAttach(context: Context) {
        println("####BlankFragment2.onAttach()")
        super.onAttach(context)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("####BlankFragment2.onCreate()")
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("####BlankFragment2.onCreateView")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank2, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        println("####BlankFragment2.onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        println("####BlankFragment2.onStart")
        super.onStart()
    }

    override fun onResume() {
        println("####BlankFragment2.onResume")
        super.onResume()
    }

    override fun onPause() {
        println("####BlankFragment2.onPause")
        super.onPause()
    }

    override fun onStop() {
        println("####BlankFragment2.onStop")
        super.onStop()
    }
    override fun onSaveInstanceState(outState: Bundle) {
        println("####BlankFragment2.onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }
    override fun onDestroyView() {
        println("####BlankFragment2.onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        println("####BlankFragment2.onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        println("####BlankFragment2.onDetach")
        super.onDetach()
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}