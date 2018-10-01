package com.example.guillermoandres.myappusingkotlin.others

import android.util.Log

// DOC: #https://kotlinlang.org/docs/reference/keyword-reference.html#OPERATORS-and-special-symbols
// DOC: #https://kotlinlang.org/docs/reference/equality.html




class Operators{

    private fun showCase1(){
        var a = 5
        var b = 5

        Log.w("OPERATORS-1", "Referential equality. Es 'a' igual a 'b'? ${a===b}") // true: Compara no por referencia sino por valor
        Log.w("OPERATORS-1", "Structural equality. Es 'a' igual a 'b'? ${a==b}")   // true:
    }

    private fun showCase2(){

        val pn1 = PersonNormal()
        val pn2 = PersonNormal()

        Log.w("OPERATORS-2", "Referential equality. Es 'pn1' igual a 'pn2'? ${pn1===pn2}") // false: No son iguales
        Log.w("OPERATORS-2", "Structural equality. Es 'pn1' igual a 'pn2'? ${pn1==pn2}")   // true: Arroja false:
        // Como no hemos sobreescrito el método equals()
        // pasa que no sabe como compararlo entonces debemos sobreescribir el método.
        //Creamos una clase y sobreescribimos el equals...... Mirar mas abajo "class PersonEqualOverride"
    }

    private fun showCase3(){

        val pn1 = PersonEqualOverride()
        val pn2 = PersonEqualOverride()

        Log.w("OPERATORS-3", "Referential equality. Es 'pn1' igual a 'pn2'? ${pn1===pn2}") // false: No son iguales
        Log.w("OPERATORS-3", "Structural equality. Es 'pn1' igual a 'pn2'? ${pn1==pn2}")   // true: Si es true por lo que sobreescribe
        //La Structural equality nos va a decir que son dos valores identicos
    }

    private fun showCase4(){

        val pn1 = PersonDataClass() // Guillermo, 27
        val pn2 = PersonDataClass() // Guillermo, 27
        val pn3 = PersonDataClass( "Diego")

        Log.w("OPERATORS-4", "Referential equality. Es 'pn1' igual a 'pn2'? ${pn1===pn2}") // false: No son iguales
        Log.w("OPERATORS-4", "Structural equality. Es 'pn1' igual a 'pn2'? ${pn1==pn2}")   // true:
        Log.w("OPERATORS-4", "Structural equality. Es 'pn2' igual a 'pn3'? ${pn2==pn3}")   // true:

    }

    fun showCases(){
        showCase1()
        showCase2()
        showCase3()
        showCase4()
    }


    //Provisional class
    class PersonNormal {var name = "Guillermo"
    }


    //Override equlas()
    class PersonEqualOverride{
    val name = "Guillermo"
        override fun equals(other: Any?): Boolean {
            if(other=== null) return false
            if(other is PersonEqualOverride){
                return other.name === this.name
            }
            return false
        }
    }


    // Esta clase de mucha importancia. Por dentro esta clase trae unos métodos internos que permiten
    // con sus lógica que se repiten, ser de mucha utilidad ya que nos ayuda a comparar no una, sino todas las propiedades
    // que le pasemos. L avamos a usar en showCase4()
    data class PersonDataClass(val name: String = "Guillermo", val age: Int = 27)//Paso de valores a un constructor
}