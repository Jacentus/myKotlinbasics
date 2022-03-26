package delegate_properties_lazy_and_observable

import kotlin.properties.Delegates

class Box (name: String, n: Int) {

    val name = name
        get() = field // get zwróci wartość pola name

    var n = n       //setter !
        get() = field
        set(value) {
            field = value
        }

    // liczenie leniwe - jeśli ktoś wywoła algorytm, to wartość jest w pamięci i będzie zwracana a nie ponownie liczone
    //cachowanie jest mega ważne ! (przechowywanie w pamięci podręcznej ?!)
    val specialValue: Double by lazy { // silnia
        println("computing has been started") // gdy wywołamy to drugi raz, to to się nie wyświetli, bo wartość jest tzymana w cache
        var result = 0.0
        var fact = 1;
        for (i in 1..n) {
            fact *= i
            result += 1/fact.toDouble()
        }
        result
    }
    // observable demo ! bardzo pomocne
    var information : String by Delegates.observable("[no info]") { // początkowa wartość
        prop, old, new -> // prop odnosi się do INFORMATION !!
        println("Sending email has been started")
        println("Email message: ${prop.name} has been updated from $old to $new")
        println("Sending e-mail completed")
    }


}

fun main(){
    val b1 = Box("box1", 10)
    println(b1.n) // to powłuje wywołanie gettera! Tak samo dla name
    b1.n = 3 // tak mogę zrobić, bo jest var
    //b1.name = "abc" //tak nie mogę bo nie ma settera i jest val

    println(b1.specialValue)

    println(b1.specialValue) // wartość z cache

    //obserwator - wykonuje logikę biznesową, jeśli dojdzie do zmiany wartości jakiegoś obiektu

    println(b1.information) // tu się spodziewam no info, bo wartość się nie zmieniła
    b1.information = "this box contains important value" //a tu wywołam metodę z observable


}