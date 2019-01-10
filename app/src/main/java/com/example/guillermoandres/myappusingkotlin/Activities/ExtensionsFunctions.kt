package com.example.guillermoandres.myappusingkotlin.Activities


import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import com.example.guillermoandres.myappusingkotlin.MainActivity
import com.example.guillermoandres.myappusingkotlin.R
import com.example.guillermoandres.myappusingkotlin.others.*
import kotlinx.android.synthetic.main.activity_extensions_functions.*


class ExtensionsFunctions : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extensions_functions)

        //Hay que saber de cual android kotlin extension se está llamando para no tener problemas
        toolbarToLoad(toolbar as Toolbar)
        enabledHomeDisplay(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        //Código a trabajar

        //Para este caso, la extensions functions nos ayuda a crear una función global
        //En este caso un toast. Así solo llamamos a toast(message) y nos evitamos estar
        //Importando el Toast cada vez que lo queramos usar.
        button_Toast.setOnClickListener{ toast("Hola Guillermo") }
                                                                    //El action        //El callback
        button_SnackBar.setOnClickListener{ snackBar("Hola Guillermo", action = "Undo"){toast("Undo!!")}}

        button_LoadByUrl.setOnClickListener{ imageViewLoadedByUrl.loadByUrl("https://udemy-images.udemy.com/course/480x270/1325930_f5f6_3.jpg")}

        button_GoToActivity.setOnClickListener{ goToActivity<MainActivity>()}
    }
}
