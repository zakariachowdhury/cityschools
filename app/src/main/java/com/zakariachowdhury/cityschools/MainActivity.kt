package com.zakariachowdhury.cityschools

import android.os.Bundle
import android.view.View
import android.widget.ExpandableListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var mainViewModel: MainViewModel
    lateinit var infoTextView: TextView
    lateinit var expandableListView: ExpandableListView
    lateinit var expandableListAdapter: CustomExpandableListAdapter

    private lateinit var cityNames: ArrayList<String>
    private lateinit var citySchoolsMap: HashMap<String, ArrayList<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        infoTextView = findViewById(R.id.infoTextView)
        expandableListView = findViewById(R.id.expandableListView)
        cityNames = ArrayList()
        citySchoolsMap = HashMap()

        expandableListAdapter = CustomExpandableListAdapter(this, cityNames, citySchoolsMap)
        expandableListView.setAdapter(expandableListAdapter)

        mainViewModel.citySchoolsHashMap.observe(
            this,
            Observer<HashMap<String, ArrayList<String>>> { hashMap ->
                hideLoader(hashMap.size != 0)
                populateExpandableListView(hashMap)
            })
    }

    private fun hideLoader(dataFound: Boolean) {
        if (dataFound) {
            infoTextView.visibility = View.GONE
        } else {
            infoTextView.text = "No data found"
        }
    }

    private fun populateExpandableListView(citySchoolsHashMap: HashMap<String, ArrayList<String>>) {
        cityNames.addAll(citySchoolsHashMap.keys.sorted())
        citySchoolsMap.putAll(citySchoolsHashMap)
        expandableListAdapter.notifyDataSetChanged()
    }
}
