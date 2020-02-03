package com.zakariachowdhury.cityschools

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.zakariachowdhury.cityschools.models.School

class MainActivity : AppCompatActivity() {
    lateinit var infoTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model: MainViewModel by viewModels()
        model.schools.observe(this, Observer<List<School>>{ schools ->
            updateUI(schools)
        })

        infoTextView = findViewById(R.id.infoTextView)
    }

    private fun updateUI(schools: List<School>) {
        infoTextView.text = "Total Schools = " + schools.size
    }
}
