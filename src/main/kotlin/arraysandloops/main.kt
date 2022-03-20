package arraysandloops

import kotlin.math.abs

//fun f(arg : Int) {} //funkcja która nic nie zwraca, a przyjmuje jeden argument. Nazywa sie Unit, odpowiednik void

// funkcja przyjmuje wartość n i dopóki n jest
// wieloktgornością liczby dziesięć zwracamy jej ułamek dziesiętny i zwiększamy licznik o 1
fun calculateZerosAtTheEndOfNumber(arg: Int): Int {
    var k = 0
    var n = abs(arg) // zera nie obrabia
    while (n % 10 == 0) {
        n /= 10
        k++
    }
    return k
}

//    Napisz funkcję, która przyjmuje jako argument liczbę całkowitą i zwraca sumę jej cyfr.
//    Na przykład, dla liczby 4201, funkcja powinna zwrócić 7

fun mySumNumbers(arg: Int): Int { // NIE ROBIĆ NIEPOTRZEBNYCH
    var n = abs(arg)
    var string = n.toString() // konwersje kosztują ! Zły nawyk. Unikać konwersji.
    var result = 0
    for (i in string) {
        result += i.digitToInt();
    }
    return result
}

fun prepareSequence(n: Int): Array<String?> {
    val array =
        arrayOfNulls<String?>(n) // ciąg wartości zainicjowany nullami! To nie jest immutable. Stała ilość elementów
    for (i in 0..n - 1) { // teraz wypełniamy to wartościami
        array[i] = "word" + i
    }
    return array
} //w tablicy może być null, to oznacza znak zapytania. Array jest immutable, to nie jest lista do której można coś dodać. Tablicę zmienialną robimy inaczej


fun sumNumbers(arg: Int): Int {
    var sum = 0
    var n = Math.abs(arg) //ZANIM COŚ ZROBIĘ, SPRAWDZAM CZY KTOŚ TEGO JUŻ NIE ZROBIŁ
    while (n > 0) {
        sum += n % 10
        n /= 10
    }
    return sum
}
/*Zadanie 2
Napisz funkcję, która przyjmuje jako argument tablice liczb całkowitych np. 150, -51, 24, 101, 105
i zwraca największą liczbę podzielną przez 5.
Dla podanego powyżej fragemntu, program powinien wypisać na ekranie 150
Jeśli funkcja otrzyma pustą tablicę, powinna zwrócić null*/

fun maxNumDivBy5(values: Array<Int>): Int? {
    if (values.isEmpty()) {
        return null
    }
    var max = 0
    for (v in values) {
        if (v % 5 == 0 && v > max) { // nie jest odporne na liczby ujemne!! Sprawdź z rozwiązaniem trenera
            max = v
        }
    }
    return max
}


fun main(args: Array<String>) { //podajemy jako argument wykonania programu tablicę,
    // edytujemy konfigurację w opcjach Run (koło startu programu u góry)

    println("wynik: " + calculateZerosAtTheEndOfNumber(345600000)) // testy automatyczne = testy jednostkowe

    println("wynik: " + sumNumbers(2020))
    println("wynik " + sumNumbers(-123))
    println("wynik " + sumNumbers(1456))

    /*fun f(){
        fun g() {
            //ZAGNIEŻDŻANIE FUNKCJI
        }
    }*/

    if (!args.isEmpty()) {
        println(args[0])
    }

    for (i in 10..20) {
        // print("$i")
    }

    for (i in 10 downTo 2 step 2) {
        // print("$i")
    }

    val array1 =
        arrayOf(12, 31, 14, 51, 16, 71) // deklaracja tablicy. arrayOf zwraca immutable array (nie można dodać wartości)
    var sum = 0
    for (v in array1) {
        sum += v
    }
    println("pierwsze " + sum)
    println("drugie " + array1.sum())

    //println(prepareSequence(15)) //to nie jest List! Zwykły array pokaże adres tablicy
    for (v in prepareSequence(15)) {
        print(v + " ")
    }
    println()
    println(maxNumDivBy5(arrayOf(-150, -51, -24, -101, -105, -200)))


    // listy - stosujemy gdy OK jest dla nas, że mogą być powtórzenia. Jeśli nie, to zbiór. lISTA - ciąg wartości, każdy ma index. W zbiorze nie ma indeksu.
    var immutableList = listOf<String>("abcde", "abc", "xyvz")
    println(immutableList) // drukuje całą listę, bo niejawnie println wywołuje metodę toString
    //immutableList.set("abc")

    val mutableList = mutableListOf<Double>(1.0, -1.0, - 0.5, -3.0, -5.0) // val nie zabezpieczy listy przed dodawaniem!
    //mutableList.set(1, 1.69)
    //mutableList.add(10.01)
    //println(mutableList)

    // chcemy przygotować listę z wartościami z listy immutableList ale w odwrotnej kolejności (odwrócić wyrazy) i o długości większej niż 4
    //paradygmat funkcyjny. it zmienna iteracyjna od iterate
    //funkcja anonimowa, nie ma nazwy, jest tylko na użytej tej funkcji filter
    // predykat to funkcja, której wynikiem musi być wartość logiczna
    // map to przekształcenie sturmienia strumień do ciąg wartości jaka zwróciła funkcja filter.
    // a więc weź listę, przefiltruj, przefiltrowaną listę zmapuj (zmień)
    val result = immutableList
        .filter { it -> it.length >= 4 }
        .map { it.reversed() }
    println(result)

    // paradygmat funkcyjny w kotlinie mozna stosować na zwyklej tablicy (array)
    // inicjowanie tablicy przy pomocy lambdy !
    val intArray = IntArray(10){3*it} //defaultowo od zera. Wniosek - wyrażeń można używać podczas inicjalizacji
    intArray.forEach { it -> println(it) }

    // funkcje zagnieżdżone - po co? Hermetyzacja. Jeśli coś jest pomocnicze, to powinno mieć zamknięty scope.
    fun sumValuesLessZero(nums : List<Double>) :Double{
        return nums.filter { it -> it < 0 }.reduce { acc, d -> acc + d  } // działa jak w Javie tylko klamerki zamiast nawiasów
    } // iteruje przez liste, odsiewam elementy większe od zera, mam strumień i dodaję do akumulatora kolejne elementy. Powstanie suma ujemnych

    println(sumValuesLessZero(mutableList))

    //Zadanie 3
    //    Napisz funkcję, która przyjmuje trzy argumenty listę napisów, liczbę a typu Int, liczbę b typu Int
    //    Funkcja powinna zwrócić kontatenację tych napisów z listy, których długość należy do przedziału <a, b>
    //    warunki a < b
    val testArray = arrayOf("Jacek", "Tomasz", "Walentyna", "Krzysztof", "abc", "top", "java")

    fun concat(array : Array<String>, start : Int, stop : Int) : String? {
        var string = array.filter { it -> it.length in start..stop }.reduce{a, b-> b + a }
        return string
    }
    println("abc" + "cbd") // nieoptymalne! Lepiej stringBuilder lub StringBuffer jeśli wielowątkowo
    println(concat(testArray, 4, 8))

}