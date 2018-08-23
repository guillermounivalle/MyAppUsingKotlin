package com.example.guillermoandres.myappusingkotlin.others

import android.util.Log

// DOC :https://kotlinlang.org/docs/reference/basic-types.html
// Documentación kotlin

/*
    In Kotlin all is a object.
    Do not exist basic types or Void. ==> (Sí algo no devuelve nada, está devolviendo Unit.)
    The variables are immutable.=>( Preferiblemente que no sean mutables:
    Var ==> mutable Types
    Val ==> immutable type
    Los tipos son definidos despues del nombre de la variable con dos puntos y espacio
    Ej ==>  Var nombre: tipo

 */
class Variables{
    private var variable0 = 1 // It is not necessary to declare the type
    private var variable1 = 1.toByte()
    private var variable2 = -123
    private var variable3 = 8373645354245
    private var variable4 = 1.1

    //Showcase para Byte
    private fun showCase1() {
        Log.w  ( tag: "VARIABLE-0" , msg: "Is variable0 a Int ---->  " + (variable0 is Int) + " ¿Por qué no es un Byte");
        Log.w( tag:"VARIABLE-1", msg: "Is variable0 a Int ---->  " + (variable0 is Int) + " ¿Por qué no es un Byte");
    }

    //Showcase para Int
    private fun showCase2(){
        Log.w  ( tag: "VARIABLE-2" , msg: "Es un valor entero")
        variable2 = Int.MAX_VALUE
    }

    //Showcase para Long
    private fun showCase3(){
        Log.w  ( tag: "VARIABLE-3" , msg: "Es un valor Long?" + (variable0 is Long))
        variable3 = Int.MAX_VALUE
    }

    //Showcase para float
    private fun showCase4(){
        Log.w  ( tag: "VARIABLE-3" , msg: "Es un valor Long?" + (variable0 is Long))
        variable3 = Int.MAX_VALUE
    }

    fun showCase() {
        showCase1()
        showCase2()
        showCase3()
        showCase4()
    }
}