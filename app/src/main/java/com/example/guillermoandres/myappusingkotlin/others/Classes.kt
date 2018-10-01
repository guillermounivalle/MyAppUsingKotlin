package com.example.guillermoandres.myappusingkotlin.others
import android.util.Log

// Clases son públicas y final por defecto
//Si queremos que una clase pueda ser heredada, usamos (open class xxx)

class Classes {

    private fun showCase1(){
            /*
            Constructores: Hay primarios y secundarios
            Primario: Se encuentra en la firma de la declaración de la clase.
            Secundario: Se encuentra dentro de la declaración de la clase
            Crearemos clases dentro de las funciones. No es lo correcto pero es válido para los ejemplos
             */
        class Person1
        class Person2 (var firstName: String)//Constructor primario
        class Person3 (var firstName: String)//Constructor puede ser omitido
        class Person4 (var firstName: String, val lastName: String, var age: Int){
            //Bloque "init": Se ejecuta después del constructor primario pero antes del constructor secundario
            init{
                age = 10
            }
        }
        //Se le pasa los valores por defecto en el constructor
        class Person5(var firstName: String = "Alejandro", val lastName: String= "Vera", var age: Int = 27)

        //Vamos a crear instancia de objetos
        val per1 = Person1() // No hay necesidad de poner "new" como se realiza en java
        val per2 = Person2(firstName = "Guillermo" )
        val per3 = Person3(firstName = "Guillermo")
        val per4 = Person4(firstName = "Guillermo",lastName =  "Hernandez", age =  35)
        val per5_1 = Person5( "Guillermo", "Perez", 28)
        val per5_2 = Person5()
        val per5_3 = Person5(firstName = "Roberto")
        val per5_4 = Person5(age = 52)

    }

    private fun showCase2(){
        /*
        Las clases en Kotlin pueden tener nun consructor primario y varios secundarios
        Los constructores secundarios son los menos usados en kotlin
         */
        open class Person{
            constructor(firstName: String, lastName: String){
                Log.w("CLASSES-2", "Welcome  $firstName $lastName!")
            }
        }

        class Person1 : Person{
            //Cuando se hace herencia y modificaremos el constructor sobreescribiendo el constructor del padre, usamos "super
            constructor(firstName: String) : super (firstName, "Mera")
            constructor(firstName: String, lastName: String) : super (firstName, lastName)
        }
        //val per1 = Person1("Guillermo", "Lora")
        //No tenemos acceso a person.firstName, ver showCase número 5
    }

    private fun showCase3(){
        //Diferencia entre "init" y Constructor secundario

        class Person1{
            //Init se va a ejecutar antes que el constructor secundario
            init{
                Log.w("CLASSES-3", "Welcome to init") // No podemos acceder a firstname o lastName
            }
            constructor(fiirstName: String, lastName: String){
                Log.w("CLASSES-3", "Welcome to Secondary Constructor")
            }

        }

        //En este ejemplo tendremos un bloque "init", un constructor secundario,
        //pero esta vez desde el "init accederemos a las propiedads del constructor
        //Tendriamos un constructor Primario, luego un bloque "init", y luego un constructor secundario
        class Person2(fiirstName: String, lastName: String){

            init{
                //Aquí si se puede acceder a las propiedades
            }
            constructor(): this("Alejandro", "Lora")
        }

        val per1 = Person1("Guillermo", "Lopez")
        val per2 = Person2()//Pasa "Alejandro" y "Lora" como parametros por defecto
        val per3 = Person2("Guillermo", "Kotlin")
    }

    private fun showCase4(){
        //Por qué usamos "val, "var" o nada en el constructor
        class Person1(firstName: String)// No podemos acceder a firstNamen cuando creemos la instancia
        class Person2(var firstName: String)//podemos acceder a firstNamen cuando creemos la instancia y se puede cambiar el valor
        //es mutable
        class Person3(val firstName: String)//podemos acceder a firstNamen cuando creemos la instancia pero no se
        // puede cambiar el valor. Noes mutable

        val per1 = Person1(firstName = "")
        val per2 = Person2(firstName = "")
        val per3 = Person3(firstName = "")
        //per1.firstName : Es un error
        per2.firstName //Funciona porque se guarda como propiedad
        per3.firstName //Funciona porque se guarda como propiedad
    }

    private fun showCase5(){

        //Propiedades   GETTERS AND SETTERS

        class Person1(var firstName: String)

        val per1 = Person1(firstName = "Guillermo")
        per1.firstName // Equivalente a getFirstName() en JAVA
        per1.firstName = "Pedro"// Equivalente a setFirstName("Pedro) en JAVA

        class Person2{
            //field : Representa a la propiedad. Nunca usar this.propiedad
            //get y set estan identados, estan linkeados a la propiedad por lo que no se debe usar this.propiedad
            //Es necesario pasar un constructor para inicializar la propiedad, debe ser un constructor secundario
            var firstName: String
                get() = field.capitalize()
                set(value) {
                  field = value.capitalize()
                }
            constructor(firstname: String){
                this.firstName = firstname
            }
        }
    }

    private fun showCase6(){
        //Herencia e Interfaces
        open class Person1(var name: String)
        open class Person2(open var name: String)
        open class Person3(open var name: String)

        //Si heredamos de Person1, las propiedades no nse pueden llamar de igual forma entre padre e hijo
        // -->class Person11(var name: String): Person1(name)
        //Esdto se puede solventar usando open y override

        class Person22(override var name: String): Person2(name)

        //Implementando Interface
        class Person33(override var name: String, override var age: Int):Person3(name), IPerson{
            override  fun hello(){
                Log.w("CLASSES-6", "Fun Hello() is override")
            }
        }

    }
    private fun showCase7(){
        //override y super
        abstract class Person(open var firstname: String, open var lastName: String){
            abstract fun hello()

            fun welcomeKotlin(){
                Log.w("CLASSES-7", "Welcome to Kotlin")
            }

            open fun welcomeDevelopers(){
                Log.w("CLASSES-7", "Welcome developers")
            }
        }

        class Man(override var firstname: String, override var lastName: String):Person(firstname, lastName){
            override fun hello(){
                Log.w("CLASSES-7", "Hello,  I am $firstname $lastName")
            }
            override fun welcomeDevelopers(){
                super.welcomeDevelopers()
                super.welcomeKotlin()
                    Log.w("CLASSES-7", "Welcome to Kotlin from override")
            }
        }

        val man = Man("Paola", "Perez")
        man.hello()//Fun de la clase Padre, no de la clae abstracta
        man.welcomeKotlin()//Fun de la clase Man, no de la clae abstracta
        man.welcomeDevelopers()//Fun de la clase Man, no de la clae abstracta

    }


    private fun showCase8(){
        //DataClases:Para ahcer un usos correcto se debe seguir tres pasos:
        /*
        El constructor primario necesita al menos un parametro
        Todos los parametros del constructor primario deben ser marcados como "val" o "var"
        las dataclases no pueden ser "abstract, open, sealed or inner"
         */

        data class Person(var firstName: String, var lastName: String)

        val per1 = Person("Alejandro", "Lora")
        val per2 = per1 //Se copia una referencia
        val personString = per1.toString()
        val personCopy = per1.copy()  //Se copia el objeto, se crea un clon del objeto, de todos los valores internos.
        val clone = per1.copy(firstName = "Antonio")//Clona la totalidad de las propiedades menos la propiedad fistName
        val (firstName, lastName) = per1 // Incorpora destructuring. Lo que hace descomponer el objeto en estas variables

        Log.w("CLASSES-8", "Data class toString() ==> $personString")
        Log.w("CLASSES-8", "Data class copy() ==> $personCopy")
        Log.w("CLASSES-8", "per1 debe ser la misma referencia que per2 ==> ${per1 === per2}")//True referencial equality
        Log.w("CLASSES-8", "per1 debe ser diferente que personCopy  ==> ${per1 !== personCopy}")//True referencial equality
        Log.w("CLASSES-8", "per1 debe tener los mismos valores que personCopy==> ${per1 == personCopy}")//True structural equality
        Log.w("CLASSES-8", "per1 debe ser diferente que la referencia del clon ==> ${per1 !== clone}")//True referencial equality
        Log.w("CLASSES-8", "per1 debe ser diferente que propiedad de valores que clone  ==> ${per1 !== personCopy}")//True referencial equality
        Log.w("CLASSES-8", "firstName destructuring debe ser del valor 'Alejandro' ==> $firstName")//True structural equality
        Log.w("CLASSES-8", "lastName destructuring debe ser del valor 'Lora' ==> $lastName")//True structural equality
    }


    private fun showCase9(){
        //ENUM class
        Log.w("CLASSES-9", "ENUM DayOfWeek.MONDAY should be MONDAY ==> ${DaysOfWeek.MONDAY.name}")
        Log.w("CLASSES-9", "ENUM DayOfWeek.MONDAY should be 0 ==> ${DaysOfWeek.MONDAY.ordinal}")
        Log.w("CLASSES-9", "ENUM DayOfWeek.FRIDAY should be FRIDAY ==> ${DaysOfWeek.FRIDAY.name}")
        Log.w("CLASSES-9", "ENUM DayOfWeek.FRIDAY should be 4 ==> ${DaysOfWeek.FRIDAY.ordinal}")
    }


    fun showCases(){
        showCase1()
        showCase2()
        showCase3()
        showCase4()
        showCase5()
        showCase6()
        showCase7()
        showCase8()
        showCase9()

    }

}

interface IPerson {
    var age: Int
    fun hello()
}

enum class DaysOfWeek { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}
