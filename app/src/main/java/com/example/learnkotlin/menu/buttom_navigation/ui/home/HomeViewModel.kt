package com.example.learnkotlin.menu.buttom_navigation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val _ballRotation = MutableLiveData<Float>().apply {
        value = 0f
    }
    val ballRotation: LiveData<Float> = _ballRotation
    fun setBallRotation(value:Float){
        _ballRotation.value=value
    }
}