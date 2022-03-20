package entities

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.IntData

// secondary constructors
class Box {
// jesli nie podam jawnie modyfikatora to ten modyfikator jest domyślnie PUBLIC

    var stringdata: String = "" // public.var dlatego ze bedizemy to modyfikowac
    var intdata = 0

    constructor(stringdata: String){
        this.stringdata = stringdata
    }

    constructor(stringdata: String, intData: Int){
        this.stringdata = stringdata
        this.intdata = intdata
    }

    fun resetAllData() {
        stringdata = ""
        intdata = 0
    }

    private fun f() {

    }

    override fun toString(): String {
        return "Box(stringdata='$stringdata', intdata=$intdata)"
    }

}