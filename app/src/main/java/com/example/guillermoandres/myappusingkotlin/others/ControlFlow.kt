package com.example.guillermoandres.myappusingkotlin.others

import android.util.Log

// DOC: #https://kotlinlang.org/docs/reference/control-flow.html

class ControlFlow{

    private fun showCase1(){
        //Here we will work if
        val num1 = 5
        val num2 = 10

        if (num1 > num2){
            Log.w("CONTROL-FLOW-1", "el número " + num1 + " es mayor que el número " + num2 + ".")
        }
    }


    private fun showCase2(){
        //Here we will work if else

        val num1 = 5
        val num2 = 10

        if (num1 > num2){
            Log.w("CONTROL-FLOW-2", "el número " + num1 + " es mayor que el número " + num2 + ".")
        }
        else{
            Log.w("CONTROL-FLOW-2", "el número " + num2 + " es mayor que el número " + num1 + ".")
        }
        //
    }


    private fun showCase3(){
        //Here we will work when. This is similar cases in java

        val x = 1
        // Con Argumento (x)
        when(x){
            1 -> Log.w("CONTROL-FLOW-3", "X = 1")// case 1
            2 -> Log.w("CONTROL-FLOW-3", "X = 2")// case 1
            else -> Log.w("CONTROL-FLOW-3", "X = other number")// case default
        }

        //Sin Argumento

        when {
            (x % 2 == 0 ) ->  Log.w("CONTROL-FLOW-3", "X es par")
            ( x % 2 == 1) ->  Log.w("CONTROL-FLOW-3", "X es impar")
        }

        //Sin argumento pero devolviendo un valor
        val isPair = when {
            (x % 2 == 0) -> true
            else -> false
        }
    }


    private fun showCase4(){
        //Bucles for

        val numbers = arrayOf(1,2,3,4,5)

        for(number in numbers) //number es un nombre cualquiera. numbers es la colección que estamos llamando
            Log.w("CONTROL-FLOW-4", number.toString())

        // Especificando tipo
        for(number: Int in numbers){
            Log.w("CONTROL-FLOW-4", number.toString())
        }

        //Con indices
        for((index, number) in numbers.withIndex())//Nos devuelve dos variables por cada uno de los valores del array
            Log.w("CONTROL-FLOW-4", "$index: $number.toString()") //${number.toString()} esto es redundante

    }


    private fun showCase5(){
        //While and do while

        var x = 10

        while(x > 0){
            x--
            Log.w("CONTROL-FLOW-5", x--.toString())
        }

        // do while

        do{
            Log.w("CONTROL-FLOW-4", "Primera y única iteracción")
        }while(x > 0)
    }

    fun showcases(){
        showCase1()
        showCase2()
        showCase3()
        showCase4()
        showCase5()
    }
}