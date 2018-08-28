package com.example.guillermoandres.myappusingkotlin.others

// DOC: https://kotlinlang.org/docs/reference/null-safety.html

class Nullable {

    /*
    Operadores que se relacionan con la nulabilidad

        -only-safe (?)
        -non-null asserted( !! )

    El sistema de tipado de kotlin está diseñado para eliminar de nuestro código
    ese molesto NullPointerException.
    Los únicos cuatro casos en los que puede pasar son:

        1. Una llamada explicita al NullPointer exception()
        2. Uso del operador !!
        3. Código externo Java
        4. Alguna inconsistencia de datos en relación a la inicialización

     */
    //Variables
    private lateinit var variable1: String   //Se le dice que se inicializara mas tarde la variable, yo me hago responsable
    private var variable2: String? = null    //Se inicializa la variable directamente


    private fun showCase1(){
        throw NullPointerException()
    }

    private fun showCase2(var1: String?){
        var1.toString()  // Devuelve nulo en caso de que la variable sea Null
        var1.toString()!!  // Devuelve NullPointer Exception
    }

    private fun showCase3(){
        //Para llamar una clase Java en Kotlin, solo la nombramos y llamamos al método.
        // Ejemplo:
        OtherJavaClass.getNPE()  //Devuelve NullPointerException
    }

    private fun showCase4(){
        variable1.length // Esto retorna un NullPointerException ya que la variable1 no ha sido inicializada lateinit
        //variable2.length  -->Si lo hacemos de esta manera, automaticamente nos arrojará NullPointer Exception
        //Entonces podemos hacer algo por este estilo:
        variable2?.length
        variable2!!.length
    }

    public fun showCases() {
        showCase1()
        showCase2("Pedro")
        showCase3()
        showCase4()
    }
}