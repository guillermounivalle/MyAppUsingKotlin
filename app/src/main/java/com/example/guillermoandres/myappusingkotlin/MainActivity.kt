package com.example.guillermoandres.myappusingkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.guillermoandres.myappusingkotlin.others.Variables

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Variables().showCase()
    }
}
