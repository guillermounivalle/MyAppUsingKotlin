package com.example.guillermoandres.myappusingkotlin.others

import android.content.Context


class MySharedPreferences(context: Context) {

    //Nombre del fichero
    private val filename = "My Preferences"  //Este va a ser el nombre con que se cree el archivo

    //Instancia del fichero
    private val prefs = context.getSharedPreferences(filename, Context.MODE_PRIVATE)

    //Por cada una de las variables a guardar en nuestro fichero
    //En Kotlin podemos crear variables que harán referencias a esos valores
    var name: String
        get() = prefs.getString("name", "")
        set(value) = prefs.edit().putString("name", value).apply()

    var age: Int
        get() = prefs.getInt("age", -1)
        set(value) = prefs.edit().putInt("age", value).apply()
}