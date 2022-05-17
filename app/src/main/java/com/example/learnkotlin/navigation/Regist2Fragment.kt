package com.example.learnkotlin.navigation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.learnkotlin.R

class Regist2Fragment : Fragment() {

    companion object {
        fun newInstance() = Regist2Fragment()
    }

    private lateinit var viewModel: Regist2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_regist2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Regist2ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}