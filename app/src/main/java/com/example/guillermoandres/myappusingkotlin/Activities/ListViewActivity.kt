package com.example.guillermoandres.myappusingkotlin.Activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.example.guillermoandres.myappusingkotlin.R
import com.example.guillermoandres.myappusingkotlin.R.*
import com.example.guillermoandres.myappusingkotlin.adapters.Person_Adapter
import com.example.guillermoandres.myappusingkotlin.models.Person
import com.example.guillermoandres.myappusingkotlin.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : ToolbarActivity() {


    private lateinit var adapter: Person_Adapter
    private lateinit var personlist: List<Person>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_list_view)


        //Hay que saber de cual android kotlin extension se está llamando para no tener problemas
        toolbarToLoad(toolbar as Toolbar)
        enabledHomeDisplay(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)



        personlist = getPersons()
        adapter = Person_Adapter(this, R.layout.list_view_person, personlist)

        listView.adapter = adapter


    }

    private fun getPersons(): List<Person>{
        val listOfPeople = listOf(
                Person("Pedro", "Gonzales", 23),
                Person("Pedro", "Gonzales", 45),
                Person("Pedro", "Gonzales", 24),
                Person("Pedro", "Gonzales", 76),
                Person("Pedro", "Gonzales", 56),
                Person("Pedro", "Gonzales", 78),
                Person("Pedro", "Gonzales", 89),
                Person("Pedro", "Gonzales", 12),
                Person("Pedro", "Gonzales", 43),
                Person("Pedro", "Gonzales", 21),
                Person("Pedro", "Gonzales", 58),
                Person("Pedro", "Gonzales", 34),
                Person("Pedro", "Gonzales", 89),
                Person("Pedro", "Gonzales", 12),
                Person("Pedro", "Gonzales", 43),
                Person("Pedro", "Gonzales", 21),
                Person("Pedro", "Gonzales", 58),
                Person("Pedro", "Gonzales", 34),
                Person("Pedro", "Gonzales", 89),
                Person("Pedro", "Gonzales", 12),
                Person("Pedro", "Gonzales", 43),
                Person("Pedro", "Gonzales", 21),
                Person("Pedro", "Gonzales", 58),
                Person("Pedro", "Gonzales", 34)
        )
        return listOfPeople
    }
}
