package com.example.guillermoandres.myappusingkotlin.Activities

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.Toast
import com.example.guillermoandres.myappusingkotlin.R
import com.example.guillermoandres.myappusingkotlin.others.LifeCycleEventsActivity
import com.example.guillermoandres.myappusingkotlin.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_intent_extras.*

class LifeCyclesActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycles)

        //Hay que saber de cual android kotlin extension se está llamando para no tener problemas
        /**toolbarToLoad(toolbar as Toolbar)
        enabledHomeDisplay(true)*/
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
