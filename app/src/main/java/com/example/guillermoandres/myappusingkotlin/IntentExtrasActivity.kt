package com.example.guillermoandres.myappusingkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.guillermoandres.myappusingkotlin.Activities.IntentsActivity
import com.example.guillermoandres.myappusingkotlin.models.Student
import kotlinx.android.synthetic.main.activity_intent_extras.*


/**
 * Nota. Cuando se llamò al textViewName, me trajo como extensiòn a list_view_person
 * " import kotlinx.android.synthetic.main.list_view_person.*"
 * Esto sucedio ya que en dos activities estoy usando una variable con el mismo nombre
 * Cada vez que se vaya a usar extensiones para llamar variables, hay que verificar que sea la
 * correcta
*/
class IntentExtrasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_extras)

        buttonBack.setOnClickListener{
            startActivity(Intent(this, IntentsActivity::class.java))
        }

        val isExtraSet = setIntentExtrasFromPreviusActivity()
        val isParcelableSet = setParcelExtraFromPreviusActivity()

        if(!isExtraSet && !isParcelableSet){
            checkBoxDeveloper.visibility = View.INVISIBLE
        }

    }

    private fun setParcelExtraFromPreviusActivity(): Boolean{
        //Para recibir un objeto parcelable
        val student = intent.getParcelableExtra<Student>("Student")
        //student?.let es la manera que en kotlin se evalúa si el valor es nullo o no
        student?.let {
            textViewName.text = student.name
            textViewLastName.text = student.lastName
            textViewAge.text = "${student.age}"  //Se le pasa el valor de la variable pero como texto
            checkBoxDeveloper.text = "Developer"
            checkBoxDeveloper.isChecked = student.isDelevoper
            return true
        }
        return false
    }

    private fun setIntentExtrasFromPreviusActivity(): Boolean{
        /**
         * Aquì se muestra como se rescata el dato enviado desde otro activity
         * Se usa el metodo getStringExtra. Como parametro se le pasa el String definido en el
         * activity donde se enviò el dato
         */
        val name = intent.getStringExtra("name")
        val lastname = intent.getStringExtra("lastname")
        /**
         * getIntExtra recibe un segundo parametro que es un valor default o por defecto, esto es
         * porque este metodo no puede recibir un valor nulo, si lo recibe, entrega un valor por defecto
         * para este caso se usa -1 de tipo Int
         */
        val age = intent.getIntExtra("age", -1)
        /**
         * getBooleanExtra recibe un segundo parametro que es un valor default o por defecto, esto es
         * porque este metodo no puede recibir un valor nulo, si lo recibe, entrega un valor por defecto
         * para este caso se usa false de tipo booleano
         */
        val developer = intent.getBooleanExtra("developer", false)

        if(name!== null && lastname !== null && age >= 0) {
            textViewName.text = name
            textViewLastName.text = lastname
            textViewAge.text = "$age"  //Se le pasa el valor de la variable pero como texto
            checkBoxDeveloper.text = "Developer"
            checkBoxDeveloper.isChecked = developer
            return true
        }
        return false
    }
}
