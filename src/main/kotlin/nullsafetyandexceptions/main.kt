package nullsafetyandexceptions

fun main() {

    //var number : Double = -0.0000001  // domyslnie nie mogę nulla podstawić
    var number : Double? = -0.0000001 // teraz mogę

    var number2 : Int? = null

    //number2.equals(0.01) //= 10 // KOTLIN ostrzega przed niebezpiecznym wyrażeniem
    try {
       //number2!!.equals(0.01) // mogę wymusić
        //tutaj może polecieć wyjątek
    } catch (e : Exception) {
        // najczęściej zapisuje się tu komunikat do pliku z logiem, monitorujemy stan aplikacji w taki sposób
        println(e.message)
        e.printStackTrace()
    }

    var result = if(number2 != null) number2.equals(10) else false // inaczej poleciałby nullpointerexception.

    println(result)


    val names: List<String?> = listOf("abc", null, "xyx") //ok bo znak zapytania
    for (name in names) {
        name?.let {
            println(it)  // it czyli aktualna wartość, tak samo jak name
        }    // jeśli chcę robić coś na czymś,co jest nullem, też daję znac zapytania
    }

    data class Employee (var name: String, var Salary: Double)

    var emp1 = Employee("Asia", 200000.0)
    emp1.apply { this.Salary = 3000000.0 }.apply { this.name = "Zenek" }.let { println(it) } // w przeciwieństwie do let apply zwróci zmieniony obiekt klasy Employee
    //apply - na obiekcie


    try{
        println(h(-10.0))
    } catch (ex : NullPointerException) {
        println(ex)
    } catch (ex : NotPositiveValueExcption) {
        ex.printStackTrace()
    } finally {
        println("FINALLY !!!")
    }

    println("po wyjątku")

}

fun h(x : Double?) : Double {
    if (x!! < 0.0) throw NotPositiveValueExcption()
    return Math.log(x!!) + Math.E + Math.PI // mówię że może pójść null i chcę wyjątek
}

// UNIT == VOID. Funkcja coś robi, nie zwraca. Jeśli NOTHING, to nie robi nic, "dokończymy to"
// UNIT MA JEDNĄ INSTANCJĘ, NOTHING NIE MA ŻADNEJ INSTANCJI
fun notCompleted(): Nothing { //typ informacji, że dana funkcja nic nie zwraca

    throw NotImplementedError()

}

