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
    private var variable4 = 1.1.toFloat()
    private var variable5= 1.9
    private var variable6= 'a'
    private var variable7= "a"
    private var variable8= true
    private var variable9= arrayOf(1,2,3,4,5,6)
    private var variable10= arrayOfNulls<Int>( size = 10)  //==> [null, null, null]
    private val variable11= "This variable is read-only"

    //Showcase para Byte
    private fun showCase1() {
        Log.w( "VARIABLE-0",  "Is variable0 a Int ---->  " + (variable0 is Int) + " ¿Por qué no es un Byte")
        Log.w(  "VARIABLE-1",  "Is variable1 a Int ---->  " + (variable1 is Byte) + " ¿Por qué no es un Byte")
    }

    //Showcase para Int
    private fun showCase2(){
        Log.w ("VARIABLE-2" , "Es un valor Integer")
        variable2 = Int.MAX_VALUE
    }

    //Showcase para Long
    private fun showCase3(){
        Log.w  ( "VARIABLE-3" , "Es un valor Long?" + (variable3 is Long))
    }

    //Showcase para float
    private fun showCase4(){
        Log.w  (  "VARIABLE-4" ,  "Es un valor Float?" + (variable4 is Float))
    }

    //Showcase para Double
    private fun showCase5(){
        Log.w  ( "VARIABLE-5" ,  "Es un valor Double?" + (variable5 is Double))
    }

    //Showcase para Char
    private fun showCase6(){
        Log.w  (  "VARIABLE-6" ,  "Es un valor Char?" + (variable6 is Char))
    }


    //Showcase para string
    private fun showCase7(){
        Log.w  ( "VARIABLE-7" ,  "Es un valor String?" + (variable7 is String))
        // String literals
        variable7 = " ¡Hello world!"    // this is java's style
        variable7 = """
                    ¡Hello world!
                    """    // this is Kotlin's style

        // Strings Templates
        var points = 9
        var maxpoints = 10
        variable7 = " Hola, tengo " + points + " puntos sobre " + maxpoints +" puntos"  // java's style
        variable7 = " Hola, tengo $points puntos sobre  $maxpoints puntos"  // Kotlin's style

        // Kotlin's style operations within the Strings
        variable7 = " Hola, tengo ${points *10} puntos sobre  ${maxpoints * 10} puntos"
    }

    //Showcase para boolean
    private fun showCase8(){
        Log.w  (  "VARIABLE-8" ,"Es un valor boolean?" + (variable8 is Boolean))
    }

    //Showcase para array<Int>
    private fun showCase9(){
        Log.w  (  "VARIABLE-9" , "Es un valor array<Int>?" + (variable9 is Array<Int>))
    }

    //Showcase para array<Int>
    private fun showCase10(){
        Log.w  (  "VARIABLE-10" , "Es un valor array<Int>?" + (variable10 is Array<Int?>))
        variable10 [4]
    }



    fun showCase() {
        showCase1()
        showCase2()
        showCase3()
        showCase4()
        showCase5()
        showCase6()
        showCase7()
        showCase8()
        showCase9()
        showCase10()

    }
}