package com.example.guillermoandres.myappusingkotlin.others

import android.util.Log

// DOC: https://kotlinlang.org/docs/reference/interfaces.html

class Interfaces {

    private var anonymusObjectImplementingInterface: Any? = null

    private fun showcase1() {
        //En programación, las interfaces no tienen  instancias, no se puede crear una instancia directamente de una interface
        //Se crea un objeto anonimo que implemente esa interface
        anonymusObjectImplementingInterface = object : Interface1  {
            override fun methodWithimplementationbyDefault() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun abstractMethod() {
               //Poner código es totalmente opcional. Se está sobreescribiendo y haciedno una implementación.
            }

        }
        //Aquí le hacemos un casting al objeto diciendole qé si el implementa esta interfaz
        // object as interface. Es necesario realizar este casting ya que en la declaració lo hacemos como Any y
        //no puede inferir el tipo correctamente
        (anonymusObjectImplementingInterface as Interface1).methodWithimplementationbyDefault()
        (anonymusObjectImplementingInterface as Interface1).abstractMethod()
    }

    private fun showcase2() {
        val anonymusObjectImplementationInterface = object : Interface2{
            override val propertyAbstract: Int
                get() = 10 // Le indicamos que dé por defecto un valor, en este caso 10

        }
        anonymusObjectImplementationInterface.propertyAbstract
        anonymusObjectImplementationInterface.propertyWithImplementation
        anonymusObjectImplementationInterface.hello()
        //Podemos acceder a las propiedades y metodos de la interfcae gracias a:
        /**
         * val anonymusObjectImplementationInterface = object : Interface2{
                override val propertyAbstract: Int
                get() = 10 // Le indicamos que dé por defecto un valor, en este caso 10
        }
         //Lo que hace este metodo determine el tipo, es decir, está infiriendo el tipo que para este caso es
            la Interface2, esto nos ahorra el casting
         */
    }


    fun showCases() {
        showcase1()
        showcase2()
    }
}


/**
 * Nota:: Las interfaces y las clases se deben crear en archivos diferentes.
 * Por simplicidad se hará de esta manera
 */
interface Interface1 {

    //Nota: Si un método no tiene nada implementado, kotlin lo tomo como método abstracto
    fun abstractMethod()

    fun methodWithimplementationbyDefault()

}

interface Interface2 {


    val propertyAbstract: Int   // Kotlin lo marca como abstracto ya que no tiene valor asignado

    var propertyWithImplementation: String
    get() = "ByDefault"
    set(value) {this.propertyWithImplementation = value}

    fun hello(){
        Log.w("INTERFACE-2", "Is it working $propertyWithImplementation?, Yay! $propertyAbstract :)")
    }
}