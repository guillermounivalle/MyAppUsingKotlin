package com.example.guillermoandres.myappusingkotlin.others

import android.app.Activity
import android.content.Intent
import android.content.SyncRequest
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.example.guillermoandres.myappusingkotlin.R
import com.squareup.picasso.Picasso
import java.time.Duration

/**
 * No creamos una clase, pasaremos dirtectamente las functions para que sean globales
 */

fun Int.isNatural() = this >= 0

//  El contexto que se usa es el de la activity                                               //Contexto, Mensaje,  Duración
fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(this,       message, duration).show()

//En este caso le ponemos como nombre snackBar, pero puede ser cualquier nombre
fun Activity.snackBar(message: CharSequence, view: View? = findViewById(R.id.container),
                      duration: Int = Snackbar.LENGTH_SHORT, action: String? = null,
                      actionEvent: (v:View) -> Unit = {}){
    if(view !== null){
        val snackbar = Snackbar.make(view, message, duration)
        if(!action.isNullOrEmpty()){
            snackbar.setAction(action, actionEvent)
        }
        snackbar.show()
    }
}


//Teniendo est, podemos reemplazar el inflater en el adaptador que se creó anteriormente
fun ViewGroup.inflate(layoutId:Int) = LayoutInflater.from(context).inflate(layoutId, this, false)!!

fun ImageView.loadByUrl(url: String) = Picasso.get().load(url).into(this)

/**
 * Cuando no sabemos que vamos a recibir pero si sabemos de qué clase hereda, ponemos <T :  "La clase de la que hereda">
 */
inline fun <reified T : Activity>Activity.goToActivity(noinline init: Intent.() -> Unit = {}){

    val intent = Intent(this, T::class.java)
    intent.init()
    startActivity(intent)
}


fun Activity.goToActivityResul(action:String, requestCode: Int, init: Intent.() -> Unit = {}){
    val intent = Intent(action)
    intent.init()
    startActivityForResult(intent, requestCode)
}