package com.example.learnkotlin.menu.buttom_navigation.ui.dashboard

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.learnkotlin.databinding.FragmentDashboard2Binding
class DashboardFragment : Fragment() {

private var _binding: FragmentDashboard2Binding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val dashboardViewModel =
            ViewModelProvider(requireActivity()).get(DashboardViewModel::class.java)
    _binding = FragmentDashboard2Binding.inflate(inflater, container, false)
    val root: View = binding.root
      binding.imageView3.scaleX=dashboardViewModel.scaleX.value!!
      binding.imageView3.scaleY=dashboardViewModel.scaleY.value!!
     val objectAnimatorX=ObjectAnimator.ofFloat(binding.imageView3,"scaleX",0f,0.1f)
     val objectAnimatorY=ObjectAnimator.ofFloat(binding.imageView3,"scaleY",0f,0.1f)
      val animatorSet=AnimatorSet()
      //animatorSet.playTogether(objectAnimatorX,objectAnimatorY)
      animatorSet.play(objectAnimatorX).after(objectAnimatorY)
      animatorSet.duration=500
      binding.imageView3.setOnClickListener {
          if(!animatorSet.isRunning){
              dashboardViewModel.setScaleX(binding.imageView3.scaleX+0.1f)
              dashboardViewModel.setScaleY(binding.imageView3.scaleY+0.1f)
              objectAnimatorX.setFloatValues(binding.imageView3.scaleX,binding.imageView3.scaleX+0.1f)
              objectAnimatorY.setFloatValues(binding.imageView3.scaleY,binding.imageView3.scaleY+0.1f)
              animatorSet.start()
          }

      }
      return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}