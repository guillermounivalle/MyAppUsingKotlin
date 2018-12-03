package com.example.guillermoandres.myappusingkotlin.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.util.Log
import android.widget.Toast
import com.example.guillermoandres.myappusingkotlin.R
import com.example.guillermoandres.myappusingkotlin.app.preferences
import com.example.guillermoandres.myappusingkotlin.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_intent_extras.*
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferences : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        //Hay que saber de cual android kotlin extension se está llamando para no tener problemas
        //toolbarToLoad(toolbar as Toolbar)
        //enabledHomeDisplay(true)

        buttonSave.setOnClickListener{setValuesSharedPreferences(); cleanEditText();getValuesSharedPreferences();}
        getValuesSharedPreferences()
    }

    private fun getValuesSharedPreferences(){
        if(preferences.name.isNotEmpty() && preferences.age >= 0){
            textViewSharedPreferences.text = "Welcome ${preferences.name}, your age is ${preferences.age}"
        }else{
            textViewSharedPreferences.text = "Welcome, please save your name and your age"
        }
    }

    private fun setValuesSharedPreferences(){
        if(editTextName.text.toString().isNotEmpty() && editTextAge.text.toString().isNotEmpty()){
            preferences.name = editTextName.text.toString()
            preferences.age = editTextAge.text.toString().toInt()
            Toast.makeText(this, "Values have been saved succesfully", Toast.LENGTH_SHORT).show()
        }else{
           Toast.makeText(this, "Please fill the name and the age before saving", Toast.LENGTH_SHORT).show()

        }
    }

    private fun cleanEditText(){
        editTextName.text.clear()
        editTextAge.text.clear()
    }
}
