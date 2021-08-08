package com.example.hw_design_onne

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.example.hw_design_onne.R
import androidx.viewpager.widget.ViewPager
import com.example.hw_design_onne.ui.main.ViewPageAdapter
import kotlinx.android.synthetic.main.activity_mapiactivity.*

private const val EARTH = 0
private const val MARS = 1
private const val WEATHER = 2

class MAPIActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapiactivity)
        view_pager.adapter = ViewPageAdapter(supportFragmentManager)
        setHighlightedTab(EARTH)

        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageSelected(position: Int) {
                setHighlightedTab(position)
            }

            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }
        })

    }

    private fun setHighlightedTab(position: Int) {
        val layoutInflater = LayoutInflater.from(this@MAPIActivity)

        tab_layout.getTabAt(EARTH)?.customView = null
        tab_layout.getTabAt(MARS)?.customView = null
        tab_layout.getTabAt(WEATHER)?.customView = null

        when (position) {
            EARTH -> {
                setEarthTabHighlighted(layoutInflater)
            }
            MARS -> {
                setMarsTabHighlighted(layoutInflater)
            }
            WEATHER -> {
                setWeatherTabHighlighted(layoutInflater)
            }
            else -> {
                setEarthTabHighlighted(layoutInflater)
            }
        }
    }

    private fun setEarthTabHighlighted(layoutInflater: LayoutInflater) {
        val earth =
            layoutInflater.inflate(R.layout.activity_api_tab_earth, null)
        earth.findViewById<AppCompatTextView>(R.id.tab_image_textview)
            .setTextColor(
                ContextCompat.getColor(
                    this@MAPIActivity,
                    R.color.colorAccent
                )
            )
        tab_layout.getTabAt(EARTH)?.customView = earth
        tab_layout.getTabAt(MARS)?.customView =
            layoutInflater.inflate(R.layout.activity_api_tab_mars, null)
        tab_layout.getTabAt(WEATHER)?.customView =
            layoutInflater.inflate(R.layout.activity_api_tab_weather, null)
    }

    private fun setMarsTabHighlighted(layoutInflater: LayoutInflater) {
        val mars =
            layoutInflater.inflate(R.layout.activity_api_tab_mars, null)
        mars.findViewById<AppCompatTextView>(R.id.tab_image_textview)
            .setTextColor(
                ContextCompat.getColor(
                    this@MAPIActivity,
                    R.color.colorAccent
                )
            )
        tab_layout.getTabAt(EARTH)?.customView =
            layoutInflater.inflate(R.layout.activity_api_tab_earth, null)
        tab_layout.getTabAt(MARS)?.customView = mars
        tab_layout.getTabAt(WEATHER)?.customView =
            layoutInflater.inflate(R.layout.activity_api_tab_weather, null)
    }

    private fun setWeatherTabHighlighted(layoutInflater: LayoutInflater) {
        val weather =
            layoutInflater.inflate(R.layout.activity_api_tab_weather, null)
        weather.findViewById<AppCompatTextView>(R.id.tab_image_textview)
            .setTextColor(
                ContextCompat.getColor(
                    this@MAPIActivity,
                    R.color.colorAccent
                )
            )
        tab_layout.getTabAt(EARTH)?.customView =
            layoutInflater.inflate(R.layout.activity_api_tab_earth, null)
        tab_layout.getTabAt(MARS)?.customView =
            layoutInflater.inflate(R.layout.activity_api_tab_mars, null)
        tab_layout.getTabAt(WEATHER)?.customView = weather
    }
}