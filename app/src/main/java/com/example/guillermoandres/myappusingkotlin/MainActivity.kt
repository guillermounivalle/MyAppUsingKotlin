package com.example.guillermoandres.myappusingkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.guillermoandres.myappusingkotlin.others.ControlFlow
import com.example.guillermoandres.myappusingkotlin.others.Nullable
import com.example.guillermoandres.myappusingkotlin.others.Operators
import com.example.guillermoandres.myappusingkotlin.others.Variables

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Variables().showCase()
        //Nullable().showCases()  ---> Solo usar para mostrar los posibles Nullpointer Exception
        Operators().showCases()
        ControlFlow().showcases()
    }
}
