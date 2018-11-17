package com.example.guillermoandres.myappusingkotlin.models

import android.support.v7.widget.Toolbar

interface IToolbar{
    fun toolbarToLoad(toolbar: Toolbar)
    fun enabledHomeDisplay(value: Boolean)
}