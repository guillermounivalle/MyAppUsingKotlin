package com.example.guillermoandres.myappusingkotlin.Activities


import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.example.guillermoandres.myappusingkotlin.R
import com.example.guillermoandres.myappusingkotlin.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_extensions_functions.*


class ExtensionsFunctions : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extensions_functions)

        //Hay que saber de cual android kotlin extension se está llamando para no tener problemas
        toolbarToLoad(toolbar as Toolbar)
        enabledHomeDisplay(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}
