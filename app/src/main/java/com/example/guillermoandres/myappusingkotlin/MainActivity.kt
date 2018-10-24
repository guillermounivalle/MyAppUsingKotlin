package com.example.guillermoandres.myappusingkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.Snackbar
import android.widget.Button
import android.widget.Toast
import com.example.guillermoandres.myappusingkotlin.Activities.AndroidExtensionsActivity
import com.example.guillermoandres.myappusingkotlin.Activities.ClickEventeActivity
import com.example.guillermoandres.myappusingkotlin.Activities.ExtensionsFunctions
import com.example.guillermoandres.myappusingkotlin.Activities.IntentsActivity
import com.example.guillermoandres.myappusingkotlin.Activities.ListViewActivity
import com.example.guillermoandres.myappusingkotlin.Activities.PermissionsActivity
import com.example.guillermoandres.myappusingkotlin.Activities.PicassoActivity
import com.example.guillermoandres.myappusingkotlin.Activities.SharedPreferences
import com.example.guillermoandres.myappusingkotlin.Activities.LifeCyclesActivity
import com.example.guillermoandres.myappusingkotlin.others.Functions

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

        /*
        Using Toast
         */
        //Probando Toast
        //Toast.makeText( contexto, "Texto (String)", Duración (Toast.LENGTH_LONG)).show()
        //Toast.makeText( this, "Hola desde el Toast", Toast.LENGTH_LONG).show()

        /*
        Using Snackbar
         */
        //Probando el SnackBar
        //Para esto necesitamos añadir una libreria en el build.gradle del app
        //se agrega com.android.support:design:27.0.0
        //Snackbar es similar al Toast, solo que en vez del contexto, utiliza un view (vista)
        //Para pasar el view, creamos una variable que va a ser un layout
        //En el main activity le damos un iD a un layout cualquiera, en este caso será el principal

        //tipo(casting)      //ID que lo identifica
        //val layout = findViewById<ConstraintLayout>(R.id.constrain)

        //Snackbar.make(view, "Texto (String)", Duración (Snackbar.LENGTH_LONG)).show()
        //Snackbar.make(layout, "Hola desde el Snackbar", Snackbar.LENGTH_LONG).show()

        //Podemos usar tambièn el snackbar a travès de un setAction
        //Snackbar.make(layout, "Hola desde el Snackbar", Snackbar.LENGTH_LONG).setAction("text")
        /*
        Snackbar.make(layout, "Hola desde el Snackbar", Snackbar.LENGTH_LONG).setAction("UNDO"){
            Snackbar.make(layout, "Probando setAction respuesta", Snackbar.LENGTH_LONG).show()
        }.show()
        */

        /*
        Lógica de botones
         */

        val btnLifeCycle = findViewById<Button>(R.id.button_to_cycle)
        val btnClickEvents = findViewById<Button>(R.id.button_to_click)
        val btnAndroidExt = findViewById<Button>(R.id.button_to_android_extensions)
        val btnPicasso = findViewById<Button>(R.id.button_to_picasso)
        val btnListView = findViewById<Button>(R.id.button_to_list_view)
        val btnIntents = findViewById<Button>(R.id.button_to_intents)
        val btnPermission = findViewById<Button>(R.id.button_to_permissions)
        val btnSharedPreferences = findViewById<Button>(R.id.button_to_shared_preferences)
        val btnExtensionsFunctions = findViewById<Button>(R.id.button_to_Extensions_functions)

        btnLifeCycle.setOnClickListener{gotToLifeCycleActivity()}
        btnClickEvents.setOnClickListener{gotToClickEventsActivity()}
        btnIntents.setOnClickListener{gotToIntentsActivity()}
        btnAndroidExt.setOnClickListener{gotToAndroidExt()}
        btnListView.setOnClickListener{gotToListViewActivity()}
        btnPermission.setOnClickListener{gotToPermissionsActivity()}
        btnPicasso.setOnClickListener{gotToPicassoActivity()}
        btnSharedPreferences.setOnClickListener{gotToSharedPreferences()}
        btnExtensionsFunctions.setOnClickListener{gotToExtensionsFunctions()}

    }
        /*
        Using Intent Basic
         */

    fun showToast(){
        Toast.makeText( this, "Hola desde el Toast", Toast.LENGTH_LONG).show()
    }

    fun showSnackBar(){
        val layout = findViewById<ConstraintLayout>(R.id.constrain)
        Snackbar.make(layout, "Hola desde el Snackbar", Snackbar.LENGTH_LONG).show()
        Snackbar.make(layout, "Hola desde el Snackbar", Snackbar.LENGTH_LONG).setAction("UNDO"){
                Snackbar.make(layout, "Probando setAction respuesta", Snackbar.LENGTH_LONG).show()
        }.show()
    }

    private fun gotToLifeCycleActivity()= startActivity(Intent(this, LifeCyclesActivity::class.java))
    private fun gotToClickEventsActivity()= startActivity(Intent(this, ClickEventeActivity::class.java))
    private fun gotToAndroidExt()= startActivity(Intent(this, AndroidExtensionsActivity::class.java))
    private fun gotToPicassoActivity()= startActivity(Intent(this, PicassoActivity::class.java))
    private fun gotToListViewActivity()= startActivity(Intent(this, ListViewActivity::class.java))
    private fun gotToIntentsActivity()= startActivity(Intent(this, IntentsActivity::class.java))
    private fun gotToPermissionsActivity()= startActivity(Intent(this, PermissionsActivity::class.java))
    private fun gotToSharedPreferences()= startActivity(Intent(this, SharedPreferences::class.java))
    private fun gotToExtensionsFunctions()= startActivity(Intent(this, ExtensionsFunctions::class.java))



}
