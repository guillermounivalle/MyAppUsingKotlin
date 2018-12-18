package com.example.guillermoandres.myappusingkotlin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.guillermoandres.myappusingkotlin.R
import com.example.guillermoandres.myappusingkotlin.models.Person
import com.example.guillermoandres.myappusingkotlin.others.inflate
import kotlinx.android.synthetic.main.list_view_person.view.*


//El adapter lo que hace es tomar el set de personas (la lista de personas), toma el layout que se ha creado
//e imlementarlo en el listview. Toma un elemento de la lista y lo inserta en el layout que se ha personalizado.
//Luego totoma todos lo layous ya personalizados y los implementa en el listview.
class Person_Adapter(val context: Context, val layout: Int, val list: List<Person>) :BaseAdapter(){

    /**
     * Una vez realizamos en el extensionsFunctions la implementación del ViewGroup,
     * Comentaré la linea del --> private val mInflator: LayoutInflater = LayoutInflater.from(context)
     * ya que la extensiónFunctios nos permite llamarla de manera global
     */
     //mInflator lo que hace es habilitarnos poder tomar ese layout y usarlo con
    //los campos nuevos que se colocaron en el layout horizontal
    //private val mInflator: LayoutInflater = LayoutInflater.from(context)

    //Retorna el item de la lista segùn la posiciòn que se le pase.
    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    //Retorna el núemro de Items que existe en la lista recibida. para asì dibujar la cantidad de elementos en el
    //listview
    override fun getCount(): Int {
        return list.size
    }

    //Este mètodo va a ser llamado cada vez que vaya a rellenar cada fila del listview
    //Aquì de colocarà toda la lògica necesaria para realizar esta operaciòn.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view: View
        val viewHolder: PersonViewHolder


        //convertView puede llegar nulo ya que representa cada uno de los items del listview
        //Al refrescar o rellenar el listview va estar vacia, por lo que el convertView Serà nulo la primera vez
        //Luego cuando ya el scroll se mueva y se regrese, ya no serà nulo el liustview. Para no hacer llamadas
        //Innecesarias y haya un mayor perfomance, usamos el Viewhoder
        //Si no es nulo, se usa view.tag as PersonViewHolder para recuperar lo que se guardo cuando era nulo
        if(convertView == null){
            /**
             * La linea a continuación se comenta ya que al usar el ViewGroup de la extensions functions
             * Editamos la linea de código para que quede mecho mas limpio
             */
            //view = mInflator.inflate(layout, parent, false)
            view = parent.inflate(layout)
            viewHolder = PersonViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as PersonViewHolder
        }

        val fullName =  "${list[position].firstname}, ${list[position].lastName}"
        viewHolder.fullName.text = fullName
        viewHolder.age.text = "${list[position].age}"

        return view
    }


}

//Esta clase permite implementar el patrón de diseño ViewHolder en Android
private class PersonViewHolder(view: View) {

    val fullName: TextView = view.textViewName
    val age : TextView = view.textViewAge
}


