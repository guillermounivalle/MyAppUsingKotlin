package com.example.guillermoandres.myappusingkotlin.Activities

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import com.example.guillermoandres.myappusingkotlin.R
import com.example.guillermoandres.myappusingkotlin.others.ToolbarActivity
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_intent_extras.*
import kotlinx.android.synthetic.main.activity_picasso.*
import java.lang.Exception

class PicassoActivity : ToolbarActivity() {


    //Primero debemos ir al gradel e incorporar la siguiente libreria: 'com.squareup.picasso:picasso:2.71828'
    //Es la que a la fecha de hoy 07/11/2018 está actualizada.
    //Leer constantemente la documentación ya que hay cambios en la manera como se trabaja algunos
    //métodos

    /**
     * Hay que habilitar los permisos de acceso a internet en el manifiest
     */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picasso)

        //Hay que saber de cual android kotlin extension se está llamando para no tener problemas
        toolbarToLoad(toolbar as Toolbar)
        enabledHomeDisplay(true)

        /**
         * RESOURCE LOADING
        Resources, assets, files, content providers are all supported as image sources.

        Picasso.get().load(R.drawable.landing_screen).into(imageView1);
        Picasso.get().load("file:///android_asset/DvpvklR.png").into(imageView2);
        Picasso.get().load(new File(...)).into(imageView3);
         */
        Picasso.get().load("https://static.pexels.com/photos/288264/pexels-photo-288264.jpeg").fetch()
        buttonLoader.setOnClickListener { loadImages() }
    }

    private fun loadImages(){
        /**
         * Nota: Esta imagen fue pre-cacheada con anterioridad en el constructor, por lo que
         * cargará más rápido que la otra imagen
         */
       Picasso.get()
               .load("https://static.pexels.com/photos/288264/pexels-photo-288264.jpeg")
               .fit()   //Nota: fit() lo que hace es llenar todo el contenedor donde se va a poner la imagen
               .into(ImageTop)  //Aquí le decimos donde la queremos cargar

        /**
         * Este ejemplo es para mostrar como picasso nos permite renderizar una imagen como un circulo,
         * esto con la finalidad de mostrar la gama de posibilidades que nos ofrece Picasso
         * ya que la comunidad tiene mucho código ya hecho para aplicar diferentes caractéristicas
         * a la imagenes
         */
        /**Picasso.get()
                .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
                .fit()
                .transform(CircleTransform()) //Aquí al método transform le pasamos una instancia del archivo CircleTransform.java
                .into(ImageBottom)  //Aquí le decimos donde la queremos cargar
        */

        /**
         *
         * Esta parte del código queda comentada para mostrar el ejemplo de CircleTransform
         * Picasso.get()
                .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
                .fit()   //Nota: fit() lo que hace es llenar todo el contenedor donde se va a poner la imagen
                .into(ImageBottom)  //Aquí le decimos donde la queremos cargar
        */

        /**
         * Ahora vamos a mostrar una animación
         */
        val context: Context = this
        Picasso.get()
                .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
                .fetch(object: Callback {
                    override fun onSuccess() {
                        ImageBottom.alpha = 0f
                        Picasso.get()
                                .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")  //Llamará de la caché
                                .into(ImageBottom)
                                ImageBottom.animate().setDuration(1300).alpha(1f).start()
                    }

                    override fun onError(e: Exception?) {

                    }
                })
    }
}
