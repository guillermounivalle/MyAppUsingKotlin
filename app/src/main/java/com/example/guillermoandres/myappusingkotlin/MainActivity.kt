package com.example.guillermoandres.myappusingkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.Snackbar
import android.widget.Toast
import com.example.guillermoandres.myappusingkotlin.others.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*
        This classes are a learning of kotlin
         */
        //Variables().showCase()
        //Nullable().showCases()  ---> Solo usar para mostrar los posibles Nullpointer Exception
        //Operators().showCases()
        //ControlFlow().showcases()
        //Classes().showCases()
        //Functions().showCases()
        //CompanionObject().showCases()

        //Probando Toast
        //Toast.makeText( contexto, "Texto (String)", Duración (Toast.LENGTH_LONG)).show()
        //Toast.makeText( this, "Hola desde el Toast", Toast.LENGTH_LONG).show()

        //Probando el SnackBar
        //Para esto necesitamos añadir una libreria en el build.gradle del app
        //se agrega com.android.support:design:27.0.0
        //Snackbar es similar al Toast, solo que en vez del contexto, utiliza un view (vista)
        //Para pasar el view, creamos una variable que va a ser un layout
        //En el main activity le damos un iD a un layout cualquiera, en este caso será el principal

                                   //tipo(casting)      //ID que lo identifica
        val layout = findViewById<ConstraintLayout>(R.id.constrain)

        //Snackbar.make(view, "Texto (String)", Duración (Snackbar.LENGTH_LONG)).show()
        //Snackbar.make(layout, "Hola desde el Snackbar", Snackbar.LENGTH_LONG).show()

        //Podemos usar tambièn el snackbar a travès de un setAction
        //Snackbar.make(layout, "Hola desde el Snackbar", Snackbar.LENGTH_LONG).setAction("text")
        Snackbar.make(layout, "Hola desde el Snackbar", Snackbar.LENGTH_LONG).setAction("UNDO"){
            Snackbar.make(layout, "Probando setAction respuesta", Snackbar.LENGTH_LONG).show()
        }.show()




    }
}
