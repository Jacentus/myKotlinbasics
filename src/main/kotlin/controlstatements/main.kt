package controlstatements

fun main() { //parametryzowanie programu = wrzucanie argumentów do main

    //val stringInput = readLine()!! // jeśli operacja się nie uda, to rzuć wyjątkiem
    //println(stringInput)
    //val inputStringSize = stringInput.length
    //val result = if(inputStringSize%2 == 0) inputStringSize + 1 else inputStringSize + 2 // wynik if else można podstawieć do zmiennej
    //print(result)

    // when, podobne do switcha, służy też do kontroli reakcji na wyjątki

    val temperature = 60
    when {
        temperature < 10 -> println("Low")
        temperature in 10 .. 20 -> println("Medium") // in x .. y to przedział domknięty
        temperature > 20 -> println("High")
    }

    val name : String = "Marysia" // w bloku when mogę zmieniać wartości obiektów na zewnątrz bloku. Jawnie deklaruję typ, nie zmienia to działania
    var invited : Boolean? //dopuszczam wartość null
    when (name) {
        "Kasia" -> invited = true
        "Basia" -> invited = false
        "Marysia" -> invited = true
        else -> invited = null// jeśli inna wartość to zrób... dopuściłem wcześniej null
    }

    println(invited)

    val num : Int = 2 //podstawienie wyniku when do obiektu
    val res = when(num) {
        1 -> "one"
        2 -> "two"
        3 -> "three"
        else -> "unknown" // wymaga else, aby uniknąć nulla !
    }

    println(res)


}