package com.example.guillermoandres.myappusingkotlin.models

import android.os.Parcel
import android.os.Parcelable
import android.util.Size

data class Student(var name: String, var lastName: String, var age: Int, var isDelevoper: Boolean = true ): Parcelable{

    //AndroidStudio 3 nos brinda por defecto la propiedad de usar parcelable para poder
    //serializar los objetos. Esto se muestra comentado mas adelante, lo voy a implementar de manera
    //manual para poder entenderlo.

    /**
     * Parcel es uyn contenedor para un mensaje
     * Puede ser usado para mandar un objeto serializado
     * Su rendimiento mejor que Serializer
     */
    //Por ser un constructor secundario, debe respetar el orden del constructor primario
     constructor(parcel: Parcel): this(
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readByte() !== 0.toByte())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        //Aquí se escribe los valores en el mismo orden en que está en el constructor
        parcel.writeString(name)
        parcel.writeString(lastName)
        parcel.writeInt(age)
        parcel.writeByte(if(isDelevoper) 1 else 0)

    }

    //Describe el tipo de contenido del objeto parcelable
    //0 siempre se usa, el otro valor es 1 o CONTENTS_FILE_DESCRIPTOR
    override fun describeContents()= 0

    companion object CREATOR : Parcelable.Creator<Student> {

        //Esto creará el objeto desde el Parcel, llamando el constructor secundario
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }
        //esto ayudará a serializar arrays de objetos del mismo tipo que esta clase
        override fun newArray(size: Int) = arrayOfNulls<Student?>(size)

    }


    /**
     * parcelable es una interfaz que nos permitye serializar el objeto para que luego pueda ser deserializado en el
     * otro activity y poder usar la información, esto ya que el objeto no se puede pasar en sí.
     * Kotlin por defecto yasnos brinda esta opción sin necesidad de nosotros escribir código
     */

    /**
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readByte() != 0.toByte()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(lastName)
        parcel.writeInt(age)
        parcel.writeByte(if (isDelevoper) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Student> {
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }*/
}