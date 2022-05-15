package com.example.learnkotlin

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class LifeCycleTestActivity : AppCompatActivity(), BlankFragment1.SampleCallback {
    var type = FragType.BLANK1
    var fragmentManager = this.supportFragmentManager
    lateinit var button: Button
    lateinit var button2: Button
    lateinit var transition: FragmentTransaction
    lateinit var blankFragment1: Fragment
    lateinit var blankFragment2: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle_test)
        println("####Activity1.onCreate")
        button2 = findViewById(R.id.button4)
        val intent = Intent(this, LifeCycleTest2Activity::class.java)
        button2.setOnClickListener {
           // fragmentManager.popBackStack("f1", FragmentManager.POP_BACK_STACK_INCLUSIVE)
//            transition = fragmentManager.beginTransaction().setCustomAnimations(
//                android.R.anim.fade_in, R.anim.fragment_close_exit
//            )
//            transition.remove(blankFragment1).commit()
//            startActivity(intent)
//            this.finish()
//            val bundle = Bundle()
//            bundle.putString("name","王柏榕222")
//            blankFragment1.arguments=bundle
        }
        button = findViewById(R.id.fragButton)
        button.setOnClickListener {
            transition = fragmentManager.beginTransaction().setCustomAnimations(
                android.R.anim.fade_in, R.anim.nav_default_exit_anim
            )
            //println("####setOnClickListener.type=$type")
            //If fragment is already on stack, we can pop back stack to prevent stack infinite growth

            when (type) {
                FragType.BLANK1 -> {
                    type = FragType.BLANK2
                    if (blankFragment2.isAdded) {//檢查這個fragment是否已經被加入
                        //transition.hide(blankFragment1).show(blankFragment2).commit()
                        transition.replace(R.id.fragTab,blankFragment2).addToBackStack(null).commit()
                    } else {
                        //transition.hide(blankFragment1).add(R.id.fragTab, blankFragment2).commit()
                        transition.replace(R.id.fragTab,blankFragment2).addToBackStack(null).commit()
                    }
                }
                else -> {
                    type = FragType.BLANK1
                    if (blankFragment1.isAdded) {
                        //transition.hide(blankFragment2).show(blankFragment1).commit()
                        transition.replace(R.id.fragTab,blankFragment1).addToBackStack(null).commit()
                    } else {
                        //transition.hide(blankFragment2).add(R.id.fragTab, blankFragment1).commit()
                        transition.replace(R.id.fragTab,blankFragment1).addToBackStack(null).commit()
                    }
                }
            }
        }
        transition = fragmentManager.beginTransaction().setCustomAnimations(
            android.R.anim.fade_in, R.anim.nav_default_exit_anim
        )
        if (savedInstanceState != null) {
            blankFragment1 =
                fragmentManager.getFragment(savedInstanceState, "f1") ?: BlankFragment1()
            blankFragment2 =
                fragmentManager.getFragment(savedInstanceState, "f2") ?: BlankFragment2()
        } else {
            blankFragment1 = BlankFragment1()
            blankFragment2 = BlankFragment2()
        }
        val bundle = Bundle()
        bundle.putString("name","王柏榕")
        blankFragment1.arguments=bundle
        //if (!blankFragment1.isAdded) transition.add(R.id.fragTab, blankFragment1).commit()
        if (!blankFragment1.isAdded) transition.replace(R.id.fragTab, blankFragment1).addToBackStack(null).commit()


    }
    override fun onBackPressed() {
        val count = fragmentManager.backStackEntryCount
        if (count == 0) {
            super.onBackPressed()
        } else {
            fragmentManager.popBackStack()
        }
    }
    enum class FragType {
        BLANK1,
        BLANK2
    }

    override fun onStart() {
        println("####Activity1.onStart")
        super.onStart()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        println("####Activity1.onSaveInstanceState")
        fragmentManager.putFragment(outState, "f1", blankFragment1)
        if (this::blankFragment2.isInitialized && blankFragment2.isAdded) fragmentManager.putFragment(
            outState,
            "f2",
            blankFragment2
        )
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

    override fun onRestart() {
        println("####Activity1.onRestart")
        super.onRestart()
    }
    override fun onDestroy() {
        println("####Activity1.onDestroy")
        super.onDestroy()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        println("####Activity1.onConfigurationChanged")
        super.onConfigurationChanged(newConfig)
    }

    override fun onButtonClicked(data:String) {
        println("####Activity1.onButtonClicked.data=$data")
    }

}