package com.example.guillermoandres.myappusingkotlin.app

import android.app.Application
import com.example.guillermoandres.myappusingkotlin.others.MySharedPreferences

/**
 * Sobreescribimos sobre la clase application'
 * Esto nos permite poner lógica para que trabaje antes de que la aplicación sea lanzada.
 * Necesitamos entonces en el Manifest indicarle.
 * Nota. Revisar el Manifest.xml --> Aplication, la priemra linea que se adicionó
 *  <application
       android:name=".app.MyApp"
 */

//Al crearse fuera de la clase, se va a poder acceder a ella de manera global
val preferences: MySharedPreferences by lazy { MyApp.prefs!! }

//"by Lazy" nunca ejecutará MyApp.prefs hasta que preferences no sea llamada
//by Lazy loading o carga floja
//Esto se ejecuta una única vez cuando se llame la variable, en este caso preferences
//preferences será llamada en este caso en SharedPreferencesActivity

class MyApp : Application(){

    companion object {
        var prefs:MySharedPreferences? = null
    }

    override fun onCreate() {
        super.onCreate()
    //Cuando se inicie la aplicación se crea una instancia de MySharedPreferences con el contexto de la aplicación
        prefs = MySharedPreferences(applicationContext)
    }
}