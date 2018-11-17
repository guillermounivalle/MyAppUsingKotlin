package com.example.guillermoandres.myappusingkotlin.others

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.example.guillermoandres.myappusingkotlin.models.IToolbar

open class ToolbarActivity : AppCompatActivity(), IToolbar {

    /**
     * Creamos una interface para trabajar este toolbar, la creamos en el paquete Models
     * y el nombre IToolbar
     * Luego Implementamos esa interface y sus metodos en este activity
     *
     */

    protected var _toolbar: Toolbar? = null

    override fun toolbarToLoad(toolbar: Toolbar) {
        _toolbar = toolbar
        _toolbar?.let{
            setSupportActionBar(_toolbar)
        }
    }

    override fun enabledHomeDisplay(value: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(value)
    }



}
