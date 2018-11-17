package com.example.guillermoandres.myappusingkotlin.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.guillermoandres.myappusingkotlin.R
import com.example.guillermoandres.myappusingkotlin.models.Student
import kotlinx.android.synthetic.main.activity_intent.*

class IntentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        //Se puede llamar directamente los botonoes sin necesidad de hacer
        //un find. Eso es gracias a "import kotlinx.android.synthetic.main.activity_intent.*"
        //HAy que tener en cuenta que se haga referencia al layout, en este caso activity_intent
        buttonIntentsExtras.setOnClickListener{goIntentExtras()}
        buttonIntentsFlags.setOnClickListener{goIntentFlags()}
        buttonIntentsObject.setOnClickListener{goIntentObject()}
    }

    private fun goIntentExtras(){
        val intent = Intent(this, IntentExtrasActivity::class.java)
        /**El mètodo putExtra recibe un keyValue. El primer valor siempre va ser un String identificativo
        Se le da un nombre a ese iD y donde se vaya a llamar, se llama con ese iD para rescatar ese valor
         En este caso se llamarà en IntentExtraActtivity.
         Como segundo parametro acepta diferentes tipos de datos primitivos.
        En el siguiente ejemplo se puede ver que se le pasa diferente tipos de datos en el segundo parametro*/

        intent.putExtra("name", "Guillermo")
        intent.putExtra("lastname", "Hernàndez")
        intent.putExtra("age", 34)
        intent.putExtra("developer", true)
        startActivity(intent)
    }


    private fun goIntentFlags(){
        val intent = Intent(this, IntentExtrasActivity::class.java)
        //intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY
        /**
         * FLAG_ACTIVITY_NO_HISTORY evita que las activities se guerden en la pila, lo que permite que a la
         * hora de regresar con el botón back del dispositivo, se muestren todas las activities que se
         * usaron. Es decir, no se guardan en el stack.
         * Hay otra serie de flags que se pueden usar para no guardar en el stack, no permitir animación
         * cuando se cambie de activity, entre otras
         * También se puede usar finish() despues del startActivity(), esto destrye el activity
         * donde se ejecuta ese finish
         */
        startActivity(intent)
        finish()
    }


    private fun goIntentObject(){
        //Pasar on objeto directamente desde un Intent
        val intent = Intent(this, IntentExtrasActivity::class.java)
        val student = Student("Guillermo", "Hernández", 34, false)
        intent.putExtra("Student", student)
        startActivity(intent)
    }
}
