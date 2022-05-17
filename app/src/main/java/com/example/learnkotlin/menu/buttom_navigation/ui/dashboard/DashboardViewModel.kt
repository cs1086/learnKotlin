package com.example.learnkotlin.menu.buttom_navigation.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {
    private val _scaleX=MutableLiveData<Float>().apply {
        value=1f
    }
    val scaleX:LiveData<Float> = _scaleX
    fun setScaleX(value:Float){
        _scaleX.value=value
    }
    private val _scaleY=MutableLiveData<Float>().apply {
        value=1f
    }
    val scaleY:LiveData<Float> = _scaleY
    fun setScaleY(value:Float){
        _scaleY.value=value
    }
}