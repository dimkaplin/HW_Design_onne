package com.example.hw_design_onne

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.hw_design_onne.databinding.ActivityAnimTwoBinding
import kotlinx.android.synthetic.main.fragment_first2.*

class AnimActivityTwo : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityAnimTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAnimTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_anim_activity_two)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val titles: MutableList<String> = ArrayList()
        for (i in 0..4) {
            titles.add(String.format("Item %d", i + 1))
        }
        createViews(transitions_container, titles)
        button.setOnClickListener {
            TransitionManager.beginDelayedTransition(transitions_container, ChangeBounds())
            titles.shuffle()
            createViews(transitions_container, titles)
        }

    }

    private fun createViews(layout: ViewGroup, titles: List<String>) {
        layout.removeAllViews()
        for (title in titles) {
            val textView = TextView(this)
            textView.text = title
            textView.gravity = Gravity.CENTER_HORIZONTAL
            ViewCompat.setTransitionName(textView, title)
            layout.addView(textView)
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_anim_activity_two)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}