package com.example.learnkotlin

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import android.view.animation.CycleInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.ImageView

@Suppress("FillClass")
class AnimatorActivity : AppCompatActivity() {
    lateinit var ball:ImageView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_animator)
        ball=findViewById(R.id.ball)
        //val animator=ValueAnimator.ofFloat(ball.translationX,ball.translationX+600,ball.translationX)
        val animator = ObjectAnimator.ofFloat(
            ball,
            "rotationY",
            0.0f, 360.0f)

        animator.duration=1000
        animator.interpolator = DecelerateInterpolator()
        animator.addUpdateListener {
            ball.translationY=it.animatedValue as Float
        }
        ball.setOnClickListener{
            animator.start()
        }
//        val animator1 = ObjectAnimator.ofFloat(
//            ball,
//            "translationY",
//            0f, -500f, 0f
//        )
//        val animator2 = ObjectAnimator.ofFloat(
//            ball,
//            "translationX",
//            0f, 500f, 0f
//        )

//        val animatorSet_onebyone = AnimatorSet()
//        animatorSet_onebyone.duration = 500
//
//        ball.setOnClickListener {
//
//            if (!animatorSet_onebyone.isRunning) {
//                animatorSet_onebyone.play(animator1).after(animator2)
//                animatorSet_onebyone.start()
//            }
//        }

//        val animatorSet_sameTime = AnimatorSet()
//        animatorSet_sameTime.duration = 500
//
//        ball.setOnClickListener {
//            if (!animatorSet_sameTime.isStarted) {
//                animatorSet_sameTime.playTogether(animator1, animator2)
//                animatorSet_sameTime.start()
//            }
//        }
    }
}