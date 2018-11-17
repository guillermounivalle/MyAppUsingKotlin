package com.example.guillermoandres.myappusingkotlin.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.Button
import android.widget.Toast
import com.example.guillermoandres.myappusingkotlin.R
import com.example.guillermoandres.myappusingkotlin.others.ToolbarActivity

//importar para usar Android Kotlin Extension
import kotlinx.android.synthetic.main.activity_android_extensions.*
import kotlinx.android.synthetic.main.activity_intent_extras.*

class AndroidExtensionsActivity : ToolbarActivity() {

    /**
     * Nota: En los botones aparece KAT que es la abreviación de Kotlin Android Extension
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_extensions)

        toolbarToLoad(toolbar as Toolbar)
        enabledHomeDisplay(true)

        val btn = findViewById<Button>(R.id.buttonById)
        btn.setOnClickListener { Toast.makeText(this, "Click by Id", Toast.LENGTH_SHORT).show()}

        //al importar: kotlinx.android.synthetic.main.activity_android_extensions.*
        //No necesitamos hacer ningún findViewById<Button>, sino que llamamos directamente
        //al botón por el id que ha sido asignado al crearlo. ni siquiera hay necesidad de
        // hacerle casting al botón. Ejemplo:

        buttonByKAT.setOnClickListener {Toast.makeText(this, "Click by kat id", Toast.LENGTH_SHORT).show()}
    }
}
