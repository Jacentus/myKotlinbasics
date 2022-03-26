package generics

// odpowiednik Singleton (wzorzec projektowy, aby nie było więcej niż jednej instancji danej klasy. Thread safe)
object SimpleLogger {}


class AbstractTrio<A, B, C> (val value1: A, val value2: B, val value3 : C) {
    override fun toString(): String {
        return "AbstractTrio(value1=$value1, value2=$value2, value3=$value3)"
    }
}

interface Producer<out T> { // T może być tylko typem zwracanym
    // out dodaje też znaczenie w hierarchi typów, jak w Javie - upperbound, mogę podstawić za dane rodziców
    fun produce(): T // dozwolone dzięki OUR
    //fun produce(arg : T) ; T // to już nie, bo tylko out. Jeśli usunę out z deklaracji interfejsu, to zadziałą
}

// A<out T> to w Javie odpowiednikiem tego jest List<? extends T>
fun fun1(obj: Producer<String>){
    val ref : Producer<Any> = obj // Any to jak Object w Java
    // adres obj i ref są takie same
}

//A<in T> to w Javie odpowiednikiem jest <? super T> // lowerbound??
interface Consumer<in T> {
    fun consume(el: T)
}

fun fun2(obj: Consumer<Any>){
    val ref : Consumer<Double> = obj // to jest możliwe bo double dziedziczy po any
    // adres obj i ref są takie same
}


fun <T: Number> allNumbersDuplicate (item: T, n: Int) : List<T> {
    val result = ArrayList<T>()
    repeat(n) {
        result.add(item)
    }
    return result
}

fun main() {

    val list: List<Any> = listOf(32, 34, "String", 0.323) // lista obiektów każdej klasy
    val list2: List<*> = listOf("abc", 42, 0.5)// większy znak zapytania. Nie wiemy jakiego typu są obiekty

    fun gg(l : MutableList<Any>) {
        l.add('A') // przekazywanie przez referencję
        l.add("String")
        l[0]
    }

    fun gg2 (l : MutableList<*>){ // * Nothing. zabezpiecza przed modyfikacją. W tym przypadku - readOnly
        //l.add('A')
        //l.add("String")
        l[0]
    }

}

// ZAPAMIĘTAĆ RÓŻNICE !!! NIE MA DOCIĄGANIA BIBLIOTEK,
// WIELE RZECZY WCIĄGNIĘTYCH. OBJEKTOWY FUNKCYJNY. ZALETY MECHANIZMÓW I SENS ICH UŻYCIA
// JESLI JEST MALO CZASU W PROJEKCIE NA PISANIE, TO MOŻNA UŻYĆ KOTLINA BO JEST ZWIĘZŁY
// DEFAULTOWE RZECZY, NIEMODYFIKOWALNOŚC, SŁOWA KLUCZOWE TYPU DATA
// ŁATWA INTEGRACJA