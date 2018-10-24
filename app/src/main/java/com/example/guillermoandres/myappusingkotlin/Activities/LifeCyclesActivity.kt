package com.example.guillermoandres.myappusingkotlin.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.guillermoandres.myappusingkotlin.R

class LifeCyclesActivity : LifeCycleEventsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycles)
    }


}
