package com.example.guillermoandres.myappusingkotlin.Activities

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.widget.Toolbar
import android.widget.Toast
import com.example.guillermoandres.myappusingkotlin.R
import com.example.guillermoandres.myappusingkotlin.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_permissions.*

class PermissionsActivity : ToolbarActivity() {

    /**
     * Le asignamos un valor a esta variable ya que es un código que identifica la clase de permiso
     * que estoy solicitando. Cuando el método onRquestPermissionResult reciba este codigo,
     * se entiende que es el permiso para usar la camara.
     */
    private val requestCameraPermission = 100
    private val requestCameraPhoto = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permissions)

        //Hay que saber de cual android kotlin extension se está llamando para no tener problemas
        toolbarToLoad(toolbar as Toolbar)
        enabledHomeDisplay(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        buttonPhoto.setOnClickListener{getPicturoFromCameraAskingPermissions()}
        buttonPhotoWithoutPermission.setOnClickListener{getPhotoFromCamera()}
    }

    private fun getPhotoFromCamera(){
        //Asegurarse que no hay permiso de camara en el manifest.xml
        //Nota: leer comentario método siguiente
        //Crear intent para capturar la photo
        val photoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        //Comprobar que podemos manejar la captura de photos
        if(photoIntent.resolveActivity(packageManager) !== null){
            startActivityForResult(photoIntent, requestCameraPhoto)
        }else{
            //No hay una activity que pueda manejar el intent ej: Sin camara
            Toast.makeText(this, "No hay aplicación para fotoso el dispositivo no tiene camara", Toast.LENGTH_SHORT).show()
        }

    }

    private fun getPicturoFromCameraAskingPermissions(){
        //Este método se usa para pedir permiso antes de tomar la foto
        //Revisar si el permiso en el manifest.xml está activado, sino
        //se debe colocar, se ha quitado por cuestiones de uso del metodo anterior.
        //<uses-permission android:name="android.permission.CAMERA" />

        /**
         * Añadiendo permisos al manifiest
         * Vamos al manifiest.xml y añadimos el permiso de la camara   --> <uses-permission android:name="android.permission.CAMERA" />
         * Luego comprobamos el permiso de la camara
         */
        //Evaluamos en este contexto si el permiso de la camera está garantizado (PERMISSION_GRANTED)-->0
        //Esto retorna un entero. Sies garantizado retorna 0, sino retorna -1(PERMISSION_DENIED)
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) !== PackageManager.PERMISSION_GRANTED){
            //Si no ha sido aceptado previamente (Para versiones desde la 6.0[API 23] en adelante)
                                                                                 //requestCode: es un relevo para identificar
                                                                                 // el permiso que se está solicitando
                                                                                //En este caso le pusimos valor 100
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 100)
        }else{
            //Si ha sido aceptado previamente o incluye a las versiones anteriores a Android 6.0 [API 23]
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, requestCameraPhoto)

        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            requestCameraPermission -> {
                if(grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    //Permiso aceptado
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(intent, requestCameraPhoto)
                }else{
                    //Permiso denegado
                    Toast.makeText(this, "You can't take a Photo if you don't allow it", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when(requestCode){
            //Aquie se toma la foto y se renderiza en el imageView
            requestCameraPhoto -> {
                //Comprobar si el resultado es bueno
                if(resultCode == Activity.RESULT_OK) {
                    //Obtenemos los extras del intent recibido
                    val extras = data!!.extras
                    //Formamos el bitmap a partir de los extras
                    val imageBitMap = extras.get("data") as Bitmap
                    //Cargamos la foto como bitmap en el imageView
                    imageViewPhoto.setImageBitmap(imageBitMap)
                }else{
                    //La foto no ha sido tomada con éxito
                    Toast.makeText(this, "Phot has failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
