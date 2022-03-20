package basicSyntax

import kotlin.math.PI

fun main() {   //odpowiednik psvm z Javy. Można dodać argumenty, nie trzeba. Funkcje mogą być w plikach, nie klasach.
    // typy var i val

    var number = 1// obiekt/zmienna modyfikowalna. Statyczne typowanie - nie chodzi o niepodawanie typu, tylko o dobór typu na etapie kompilacji a nie uruchamianiu programu.
   //number = "abc" <- tak nie zadziała // Gdy język jest typowany dynamicznie, to dzieje się to na etapie uruchomienia.
    var number2 : Int = 1 // mogę, ale nie muszę podać typu. Var
    println(number)

    val name = "Ala" // mogę, ale nie muszę podać : String VAL służy kontroli, aby nie zmienić wartości.
    // val name = "Kasia" <- nie zadziała. Srednik - można, ale nie trzeba.

    //Zadanie 0 - wspomagając się Kotlinem, oblicz w zmiennej wartość wyrażenia 2 + 4 + 6 + .. + 98 + 100 i wypisz na ekranie wynik
    //Oczywiście nie należy użyć pętli

    val result = 25 * 102;
    println(result)

    var value : Double = 28.0 // to jest klasa. W Kotlinie nie ma typów prostych

    value *= PI // importujemy klasę z Math, mogę też zaimportować klasę Javy...

    println(String.format("%.4f", value)) //% = zapowiedź wartości, f liczby zmiennoprzecinkowej float, .4 liczba cyfr po przecinku. Najpierw format, który ma dwa argumenty: 1) konstrukcja stringa 2) wartość do podstawienia
    println(value.div(2.0).plus(0.03))

    val num2 = -0.0000122f
    var x = 10.01f
    var y = 0.0
    y = x.toDouble() // x = y nie da rady, float vs. double

    val num3 = 1_000_000//L//separatory, lepsza czytelność, to nadal jest Int a z L Long

    if(num3 is Number){
        println("$num3 is number") // dolar odniesienie do zmiennej
    }

    //porównywanie wartości często weryfikowane na rozmowach kwalifikacyjnych

    val v1 = 'A'
    val v2 = 'B' // obiekty - equals i hashcode
    //f(x) = x%10 // reszta z dzielenia, przykładowa funkcja haszująca, nie jest różnowartościowa.
    println("v1 hashcode = ${v1.hashCode()} v2 hashcode = ${v2.hashCode()}") //wywołanie funkcji na obiekcie. Hashcode - identyfikator obiektu.

    println(v1 === v2) // === to porównanie referencji, odpowiednik w javie ==
    println(v1 == v2) // == porównuje wartości, w javie referencje

    println(v1.equals(v2)) //
    println(v1.compareTo(v2)) // leksykograficznie tj alfabetycznie

    //String, Int, Double, Char, Float - optymalizacja. Nie powstaje kopia, mamy pulę tych samych wartości.
    var num5 = -99.99
    var num6 = -99.99  // Num6 będize referencją na wartość na którą referuje num5, nie powstanie kopia wartości (bo ta już istnieje w pamięci)
    println(num5 === num6) // tak samo jak w Javie

    var v3 = "abc" // var mogę przypisywać inne wartości, val nie
    var v4 = "abc" // najpierw te dwa obiekty mają te same referencje
    v4 += "" //zmieniam wartość obiektu v4, więc będą miały inne referencje. Stworzyliśmy nowy obiekt
    println(v3 !== v4) //true !

    val result3 = (true || 2 < 1) && ("word".length == 5) && (false != !true) // true || false && false // false

    println(result3)

    var cityName : String = "Krakow"
    println(cityName[cityName.length - 1]) //wsparcie dla stringów, można je traktować jako tablicę. Zostanie w, bo usuwamy od indexu 0;

    var xy = "abc" // nulle są niebezpieczne, bo na nullach gdy wywołamy metodę wyskakuje NullPointerException
    //xy = null // nie zadeklarowaliśmy, że xy może być nullem. Kotlin nie pozwoli tu wstawić nulla ze względów bezpieczeństwa!
    // trzeba wyraźnie wskazać, że chcę to zrobić - niżej

    var lastName : String? = "Bartnicki" // ? pozwala na podstawienie nulla do zmiennej var
    lastName = null

    println(lastName?.length) // też nie mogę tak zrobić! aby wywołać funkcję na zmiennej oznaczonej ?, to metodę też muszę oznaczyć ?
    println("hello") // pomimo tego, że wywołałem funkcję na nullu, to nie wywali mi programu!

    //dzieki operatorowi !! jesli lastName bedize nullem to poleci wyjatek
    //lastName!! // dalsza część kodu się nie wykona, w przeciwieństwie do użycia operatora ?

    // KONWENCJE KODOWANIA - standard jaki stosuje się w zespole https://kotlinlang.org/docs/coding-conventions.html

}