package com.example.guillermoandres.myappusingkotlin.Activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.guillermoandres.myappusingkotlin.R
import com.example.guillermoandres.myappusingkotlin.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_click_evente.*


class ClickEventeActivity : ToolbarActivity(), View.OnLongClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_evente)

        //Hay que saber de cual android kotlin extension se está llamando para no tener problemas
        toolbarToLoad(toolbar as Toolbar)
        enabledHomeDisplay(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)



        //Captura de botones
        val button1 = findViewById<Button>(R.id.buttonClickMulti1)
        val button2 = findViewById<Button>(R.id.buttonClickMulti2)
        val button3 = findViewById<Button>(R.id.buttonClickMulti3)

        button1.setOnLongClickListener(this)
        button2.setOnLongClickListener(this)
        button3.setOnLongClickListener(this)
        clickInLine()
    }

    // 1. Click en XML
    // 2. Click en en linea
    // 1. Click en por ID´s

    //Reglas obligatorias para clicks en XML
    //El método debes ser público. Los nombres tienen que coincidir. Recibe un solo parametro
    fun xmlClick(view: View){
        Toast.makeText(this, "Clickeado por XML", Toast.LENGTH_LONG).show()
    }

    //En linea
    private fun clickInLine(){
        val btn = findViewById<Button>(R.id.buttonClickInLine)
        btn.setOnClickListener{Toast.makeText(this, "Clickeado en Linea", Toast.LENGTH_LONG).show()}
    }

    override fun onLongClick(v: View): Boolean {
        when(v.id){
            R.id.buttonClickMulti1 -> Toast.makeText(this, "Clickeado Multi1", Toast.LENGTH_LONG).show()
            R.id.buttonClickMulti2 -> Toast.makeText(this, "Clickeado Multi2", Toast.LENGTH_LONG).show()
            R.id.buttonClickMulti3 -> Toast.makeText(this, "Clickeado Multi3", Toast.LENGTH_LONG).show()
        }
        return true
    }


}
