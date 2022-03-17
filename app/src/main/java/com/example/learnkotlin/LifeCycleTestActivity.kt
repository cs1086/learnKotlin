package com.example.learnkotlin

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class LifeCycleTestActivity : AppCompatActivity() {
    var type=FragType.BLANK1
    var fragmentManager=this.supportFragmentManager
    lateinit var button: Button
    lateinit var button2: Button
    lateinit var transition:FragmentTransaction
    lateinit var blankFragment1:Fragment
    lateinit var blankFragment2:Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle_test)
        println("####Activity1.onCreate")
        button2=findViewById(R.id.button4)
        val intent = Intent(this,LifeCycleTest2Activity::class.java)
        button2.setOnClickListener{
            startActivity(intent)
            this.finish()
        }
        button=findViewById(R.id.fragButton)
        button.setOnClickListener{
            transition=fragmentManager.beginTransaction().setCustomAnimations(
                android.R.anim.fade_in, R.anim.fragment_close_exit)
            //println("####setOnClickListener.type=$type")
            when(type){
                FragType.BLANK1->{
                    type=FragType.BLANK2

                    if(blankFragment2.isAdded) {//檢查這個fragment是否已經被加入
                        transition.hide(blankFragment1).show(blankFragment2).commit()
                    }else{
                        transition.hide(blankFragment1).add(R.id.fragTab, blankFragment2).commit()
                    }
                }
                else->{
                    type=FragType.BLANK1
                    if(blankFragment1.isAdded) {
                        transition.hide(blankFragment2).show(blankFragment1).commit()
                    }else{
                        transition.hide(blankFragment2).add(R.id.fragTab, blankFragment1).commit()
                    }
                }
            }
            transition.addToBackStack(null)
        }
        transition=fragmentManager.beginTransaction().setCustomAnimations(
            android.R.anim.fade_in, R.anim.fragment_close_exit)
        if(savedInstanceState!=null) {
            blankFragment1 = fragmentManager.getFragment(savedInstanceState, "f1") ?: BlankFragment1()
            blankFragment2 = fragmentManager.getFragment(savedInstanceState, "f2") ?: BlankFragment2()
        }else{
            blankFragment1 = BlankFragment1()
            blankFragment2 = BlankFragment2()
        }
        if(!blankFragment1.isAdded)transition.add(R.id.fragTab, blankFragment1).commit()
        transition.addToBackStack(null)
    }
        enum class FragType{
        BLANK1,
        BLANK2
    }
    override fun onStart() {
        println("####Activity1.onStart")
        super.onStart()
    }
    override fun onSaveInstanceState(outState: Bundle) {
        println("####Activity1.onSaveInstanceState")
        fragmentManager.putFragment(outState,"f1",blankFragment1)
        if(this::blankFragment2.isInitialized && blankFragment2.isAdded)fragmentManager.putFragment(outState,"f2",blankFragment2)
        super.onSaveInstanceState(outState)
    }
    override fun onResume() {
        println("####Activity1.onResume")
        super.onResume()
    }
    override fun onPause() {
        println("####Activity1.onPause")
        super.onPause()
    }
    override fun onStop() {
        println("####Activity1.onStop")
        super.onStop()
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        println("####Activity1.onRestoreInstanceState")

        super.onRestoreInstanceState(savedInstanceState)
    }
    override fun onDestroy() {
        println("####Activity1.onDestroy")
        super.onDestroy()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        println("####Activity1.onConfigurationChanged")
        super.onConfigurationChanged(newConfig)
    }
}