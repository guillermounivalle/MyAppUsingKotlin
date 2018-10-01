package com.example.guillermoandres.myappusingkotlin.others

import android.util.Log
import java.util.*


class Functions{

    private fun showcase1(){
        // Funciones, parametros y Unit
        //Declaración minima para una función
        //En kotlin todas las funciones devuelven un objeto
        //El valor Unit es devuelto en cualquier función si no se define su tipo de retorno
        //Es lo mismo que cuando en java se usa void

        fun function1(){}
        val result1 = function1()

        fun function2(): Unit {}
        val result2 = function2()

        //Los parametros de la funciones necesitan especificar su tipo

        fun function3(param1: String, param2: String): String{
            return "$param1, $param2"
        }
        val result3 = function3("String 1", "String 2")

        fun function4(param: Int = 5){}
        fun function5(param: Int?){}//Con nulabilidad
    }

    private fun showCase2(){
        // Funciones con funciones con parámetros (callback) y llamadas por lambda
        //Pasamos los parametros y le pasamos el metodo asignando que devuelve
        //Ejemplo funcion(parametro, parametro ...., metodo -> lo que retorna)

        fun printSum(param1: Int, param2: Int, printer:(result:Int)-> Unit){
            printer(param1+ param2)
        }

        printSum(5, 5){result ->
            Log.w("FUNCTIONS-2", "Lambda expression print the sum result (10) -> $result")
        }

        //Si el callback recibe solo un parametro, podemos omitir ese "result" con it
        printSum(12, 12){
            Log.w("FUNCTIONS-2", "Lambda expression print the sum result (10) -> $it")
        }

        // callback con mas parametros
        fun printSum2(param1: Int, param2: Int, printer:(result:Int, param1:Int, param2:Int)-> Unit){
            printer(param1+ param2, param1, param2)
        }

        printSum2(7, 7){ result, param1 , param2 ->
            Log.w("FUNCTIONS-2", "Lambda expression print the sum result (14) -> $result")
        }

        printSum2(7, 7){ result, param1 , param2 ->
            Log.w("FUNCTIONS-2", "Lambda expression print the sum result (14) -> $result")
        }

    }

    private fun showCase3(){
        // Named Arguments

        fun function1(firstName:String, lastName: String, age:Int, city: String, dateOfBirth: Date){
            //
        }

        function1("", "", 27, "", Date())
        //Argumentos nombrados se usan de esta forma
        function1(lastName = "Hernandez", city =  "Cali",age =  27,firstName =  "Guillermo", dateOfBirth = Date())
    }

    private fun showCase4(){
        //Single-expressions function
        fun sum(param1: Int, param2: Int) = param1 + param2
    }

    private fun showCase5(){
        //Variable number of Arguments ( Varargs)
        //varargs implementa ciertas interfases que tienen los arrays
        fun sumAll(vararg numbers: Int) = numbers.sum()

        val result = sumAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)//Tener en cuenta que no se está pasando un array, se está pasando argumentos enteros
        Log.w("FUNCTIONS-5", "varags retornara la suma de los números que es:(55) -> $result")
    }

    private fun showCase6(){
        //Extensions functions
        //Permite extender el lenguaje kotlin de una forma que nos ayuda a ahorra código

        //Si es declara la extension function dentro del método, solo tendremos acceso a él
        //En el mismo contexto de la función, por fuera de la función no lo permite
        //Estamos extendiendo la clase String de kotlin, añadiendole el método welcome
        //Nota: ver al final del código la declaración global
        fun String.welcome(){
            Log.w("FUNCTIONS-6", "Welcome to kotlin and Extension function")
        }
        "".welcome()
    }




    fun showCases(){
        showcase1()
        showCase2()
        showCase3()
        showCase4()
        showCase5()
        showCase6()
        "".welcomeKotlin()
    }
}

//Si se declara aquí se tendrá acceso de manera global en toda la app
//Cuando un método se va a usar mucho en muchas partes, se pueden hacer este tipo de declaraciones
fun String.welcomeKotlin(){
    Log.w("Message", "Welcome to kotlin and Extension function Globally")
}
