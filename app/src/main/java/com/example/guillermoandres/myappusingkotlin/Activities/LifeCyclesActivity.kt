package com.example.guillermoandres.myappusingkotlin.Activities

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.example.guillermoandres.myappusingkotlin.R
import com.example.guillermoandres.myappusingkotlin.others.LifeCycleEventsActivity

class LifeCyclesActivity : LifeCycleEventsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycles)
    }


    //Variable para mostrar ejemplo del método onBackPressed()
    private var exitEnabled = false

    //Botón back del dispositivo. Podemos sobreescribir su función para usarlo a nuestro modo.
    override fun onBackPressed() {
        if(exitEnabled){
            super.onBackPressed()
        }
        exitEnabled = true
        Toast.makeText(this, "Click back again to exit this screen", Toast.LENGTH_LONG).show()

        //Handler
        Handler().postDelayed(Runnable { exitEnabled = false }, 3000)
    }
}
