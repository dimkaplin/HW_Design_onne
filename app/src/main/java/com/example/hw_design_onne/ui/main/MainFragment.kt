package com.example.hw_design_onne.ui.main

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hw_design_onne.MAPIActivity
import com.example.hw_design_onne.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        btnStartAPIActivity.setOnClickListener {
            Toast.makeText(context, "Выбран one", Toast.LENGTH_SHORT).show()
            //startActivity(Intent(it, ApiBottomActivity::class.java))
            startActivity(Intent(context, MAPIActivity::class.java))
        }

        btnAnimationOne.setOnClickListener{
            TransitionManager.beginDelayedTransition(fragmentContainerView, Slide())
               //fragmentContainerView.visibility = if (fragmentContainerView.visibility == View.GONE) View.VISIBLE else View.GONE
        }
    }



}