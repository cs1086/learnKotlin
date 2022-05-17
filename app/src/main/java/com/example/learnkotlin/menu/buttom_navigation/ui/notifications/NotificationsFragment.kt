package com.example.learnkotlin.menu.buttom_navigation.ui.notifications

import android.animation.Animator
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.learnkotlin.databinding.FragmentNotificationsBinding
import kotlin.random.Random

class NotificationsFragment : Fragment() {

private var _binding: FragmentNotificationsBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

    _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
    val root: View = binding.root
    val objectAnimator=ObjectAnimator.ofFloat(binding.imageView4,"x",0f,0f)
      objectAnimator.duration=500
      binding.imageView4.setOnClickListener {
          if(!objectAnimator.isRunning){
              val width = if(Random.nextBoolean()) 100 else -100

              objectAnimator.setFloatValues(binding.imageView4.x,binding.imageView4.x+width)
              objectAnimator.start()
          }
      }
    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}