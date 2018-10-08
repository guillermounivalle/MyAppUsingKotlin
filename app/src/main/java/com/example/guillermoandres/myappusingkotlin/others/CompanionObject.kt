package com.example.guillermoandres.myappusingkotlin.others

import android.util.Log


class CompanionObject{

    private fun showcase1(){
        //Normal Companion object
        val value = MyClass.flag
        MyClass.welcome()
    }

    private fun showcase2(){
        MyClass2.welcome()
    }



    fun showCases(){
        showcase1()
        showcase2()
    }
}

class MyClass{
    //Nota: Dentro de una clase no se puede crear mas de un CompanionObject, por lo que lo que se necesite
    // debe estar dentro de ese unico CompanionObject
    companion object {
        val flag = 1

        fun welcome(){
            Log.w("COMPANION-OBJECT-1", "Welcome from Companion Object!")
        }
    }

}

class MyClass2{
    //implementando la interfaz
    companion object: Welcome {
        override fun welcome(){
            Log.w("COMPANION-OBJECT-2", "Welcome from Companion Object2! + interface")
        }
    }
}


interface Welcome{

     fun welcome(){

     }
 }