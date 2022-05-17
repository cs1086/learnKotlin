package com.example.learnkotlin.menu.buttom_navigation.ui.home

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.learnkotlin.databinding.FragmentHome2Binding

class HomeFragment : Fragment() {

private var _binding: FragmentHome2Binding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val homeViewModel =
            ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)

    _binding = FragmentHome2Binding.inflate(inflater, container, false)
    val root: View = binding.root

    val imageView=binding.imageView2
      imageView.rotation=homeViewModel.ballRotation.value!!

      //初始化動畫物件，values參數至少要寫兩個數字就算用不到也要寫，不然會報錯
    val objectAnimator:ObjectAnimator= ObjectAnimator.ofFloat(imageView,"rotation",0f,0f).apply     {
      duration=500
    }
      homeViewModel.ballRotation.observe(viewLifecycleOwner){
          //設定動畫的變化值
          objectAnimator.setFloatValues(imageView.rotation,it)
          //動畫開始
          objectAnimator.start()
      }
      imageView.setOnClickListener {
          //如果上個動畫還沒結束則不允許繼續觸發
          if(!objectAnimator.isRunning){
              //homeViewModel.ballRotation.value=imageView.rotation+100
              homeViewModel.setBallRotation(imageView.rotation+100)

          }
      }

    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}