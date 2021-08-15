package com.example.hw_design_onne

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw_design_onne.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                //.replace(R.id.container, FiveLessonTwoFragment.newInstance())
                .commitNow()
        }
    }
}