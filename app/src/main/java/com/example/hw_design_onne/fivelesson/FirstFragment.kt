package com.example.hw_design_onne.fivelesson

import android.os.Bundle
import android.transition.*
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hw_design_onne.R
import com.example.hw_design_onne.databinding.FragmentFirstBinding

import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private var toRightAnimation = false

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.btnSunDown.setOnClickListener{
            val changeBounds = ChangeBounds()
            changeBounds.setPathMotion(ArcMotion())
            changeBounds.duration = 500
            TransitionManager.beginDelayedTransition(
                transitions_container,
                changeBounds
            )

            toRightAnimation = !toRightAnimation
            /*val params = binding.btnSunDown.layoutParams as FrameLayout.LayoutParams
            params.gravity =
                if (toRightAnimation) Gravity.END or Gravity.BOTTOM else Gravity.START or Gravity.TOP
            binding.btnSunDown.layoutParams = params*/



        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}