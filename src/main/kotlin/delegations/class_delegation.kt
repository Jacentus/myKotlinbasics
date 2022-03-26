package delegations

import java.text.SimpleDateFormat
import java.util.Date
import java.util.LinkedList

interface  DateTimeGenerator{

    fun generateDate() : String
    fun generateTime() : String
}

class StandardDateTimeGenerator(val messagePrefix: String) : DateTimeGenerator {   //klasa implementuje interfejs

    override fun generateDate(): String {

        val simpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
        val currentDate = simpleDateFormat.format(Date()); // dostaję obiekt z timestampem
        return "${messagePrefix} ${currentDate}"
    }

    override fun generateTime(): String {

        val simpleDateFormat = SimpleDateFormat("HH:mm:ss")
        val currentTime = simpleDateFormat.format(Date())
        return "${messagePrefix} ${currentTime}"
    }
}

class BasicDateTimeGenerator(dateTimeGenerator: DateTimeGenerator) : DateTimeGenerator by dateTimeGenerator {     //jako argument przekazujemy obiekt implementujący interfejs!
// klasa, która ma związek z inną klasą, która implementuje interfejs

    override fun generateDate(): String {
        val simpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
        val currentDate = simpleDateFormat.format(Date()); // dostaję obiekt z timestampem
        return currentDate
    }
}

/////////////////////////////////////////////////////////////////

fun main(){
    val standardDateTimeGenerator = StandardDateTimeGenerator("Current time: ")
    println(standardDateTimeGenerator.generateDate())

    val basicDateTimeGenerator = BasicDateTimeGenerator(standardDateTimeGenerator)    // zmieniam zachowanie obiektu, nowej klasie przekazuję istniejący obiekt, w którym zmieniam zachowanie metody
    println(basicDateTimeGenerator.generateDate()) //dynamiczna zmiana zachowania metody/obiektu

    fun divideBy0(a: Double, b: Double) : Double {
        if (b == null || b.equals(0.0)) {
            throw Exception("invalid value of the second agreement") //jeśli b jest błędne, rzuć wyjątkiem.
        // W Javie nie mógłbym tak zrobić bo Ezxception trzeba łapać, w Kotlinie mogę
        }
    /*     if (!b.equals(0.0)) {
           return null
       }      */  // najgorsze rozwiązanie ;)
        return a.div(b)
    }
/*
    try {
*/
        println(divideBy0(2.0, 2.0))
/*    } catch (ex: Exception) {
        println(ex.message)    // w kotlinie nie muszę, ale mogę obsłużyć.
    }*/

    println("application is running")
    //THOMAS CORMEN - ALGORYTMY
    // Listy (array listy, linked listy), Zbiór (Set), Map/słownik, kolejka, stos


    // NIE WYBIERAĆ STRUKTUR BEZMYŚLNIE - ZASTANOWIĆ SIĘ !!!
    val list1 = ArrayList<String>(); // O(n) ala, kasia, abc (indeks 0, 1, 2)   chcę dodać na początek, to przesuwam wszystko w prawo
    val list2 = LinkedList<String>(); // O(1) ala -> kasia -> abc -> każdy element wskazuje na następny chce dodać na początek,
                                        // to ustawiam po prostu referencję na peirwsyz element - proste i mało operacji

    val hashSet = HashSet<Int>() // implementacja interfejsu Set. Nie mam powtórzeń. Nie jest w kolejności.
    hashSet.add("12".toInt())
    hashSet.add(12) // nie doda się do Setu, bo mają ten sam hashcode
    println(hashSet.size) // hashCode NIE JEST różnowartościowy.

    val set1 = setOf(1, 2 , 3) - setOf(2)  // zadziała
    println(set1)

    val linkedHashSet = LinkedHashSet<Int>()
    for (i in 1.. 100) {
        linkedHashSet.add(i)
    }

    linkedHashSet.forEach{(print("${it} "))} // gdyby ty był zwykły set, to nie ma gwaracji, że będize to w kolejnośsci
    // wszystkie kolekcje oparte na hashowaniu gwarantują nam, że dodawanie wartości (add czy put) oraz sprawdzanie
// czy wartość istnieje mają złożoność O(1)
    println()
    println(set1.contains(3)) // czy wartość należy do zbioru

    val map = HashMap<String, Int>() // klucz: String, wartość: Int. Klucz pełni funkcję identyfikującą wartość. Na podstawie klucza mogę szybko dobrać się do wartości.

    map.put("one", 1)
    map.put("two", 2)

    map.put("one", 111)     // nie mogą być dwie pary o tym samym kluczu. Mapa liczy hashcode i sprawdza. To nadpisze wartosc o tym samym kluczu

    val map2 = mapOf("one" to 1, "two" to 2)  // do mapy wrzuć parę gdzie para to mapowanie klucza one do wartości int
    // LinkedHashMap zapewnia, że kolejność iteracji będzie taka sama jak kolejność wstawiania. TAKA MAPA JEST IMMUTABLE

    val randNumber = (1..100).random()
    println("\n" + randNumber)


}




