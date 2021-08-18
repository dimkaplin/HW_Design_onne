package com.example.hw_design_onne.fivelesson

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.transition.TransitionManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw_design_onne.R
import kotlinx.android.synthetic.main.five_lesson_two_fragment.*

class FiveLessonTwoFragment : Fragment() {

    companion object {
        fun newInstance() = FiveLessonTwoFragment()
    }

    private lateinit var viewModel: FiveLessonTwoViewModel
    private var textIsVisible = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.five_lesson_two_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        button.setOnClickListener {
            TransitionManager.beginDelayedTransition(transitions_container)
            textIsVisible = !textIsVisible
            text.visibility = if (textIsVisible) View.VISIBLE else View.GONE
        }

    }

        override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FiveLessonTwoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}