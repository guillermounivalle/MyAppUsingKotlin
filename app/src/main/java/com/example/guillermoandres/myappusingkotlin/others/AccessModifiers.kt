package com.example.guillermoandres.myappusingkotlin.others

// DOC https://kotlinlang.org/docs/reference/visibility-modifiers.html#classes-and-interfaces

// Para hacer que una clase sea "extendible" hay que marcarla como open.
// En Java es open por defecto y en kotlin es final por defecto, así que no puede ser estendida sin el uso del open


/**
 * Si quisiera que esta clase fuera extendible seria:
 *  open class AccessModifiers{
 *      foo bar
 *  }
 *
 *  Esto debido a que por defecto las clases en kotlin son "final"
 */
open class AccessModifiers {
     //  private       -- Sólo visible dentro de la clase
     //  procteted     -- Sólo visible dentro de la clase y de sus subclases (herencia)
     //  public        -- Visible desde dentro de la clase, de sus subclases y desde afuera

    val propiedad1 = "Publica por defecto"
    private val propiedad2 = "Marcada como privada"
    //Si la clase fuera open, el protected si tendría sentido.
    protected val propiedad3 = "Marcada como protegida" // Es un "private" un poco mas flexible

    private fun showCase(){
        val test = AccessModifiers()
        test.propiedad1   //Tenemos acceso a las tres propiedades ya que estamos adentro del contexto de la clase AccessModifiers
        this.propiedad1   //Estamos accediendo a la propiedad 1 de la clase, no de la instancia

    }

}       //Asi heredamos de una clase en kotlin: "class AccessModifiersChild : AccessModifiers()"
class AccessModifiersChild : AccessModifiers(){
    private fun showCases(){
        propiedad1
        this.propiedad1
        propiedad3
        this.propiedad3
        //Como propiedad2 es privada, no podemos acceder a ella
        //propiedad3 si la podemos ver por que es protecte, no es visible des afuera pero si desde una subclase
    }
}


class AnotherClass {
    private fun showcase(){
        val test = AccessModifiers()
        test.propiedad1
        // Solo tenemos acceso a propiedad1 ya que esta clase no hereda de AccessModifiers, por lo tanto solo
        // podemos acceder a una variable publica de la instancia de la clase AccessModifiers
    }
}