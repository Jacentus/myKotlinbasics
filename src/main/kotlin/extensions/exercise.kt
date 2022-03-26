package extensions

import java.util.*

/*
Zadanie 1
Napisz klasę SimpleLogger, która zawiera funkcję log, której argumentem jest komunikat.
Metoda powinna przy pomocy println wypisać na ekranie bieżącą datę, godzinę  oraz komunikat np, jeśli komunikat
to “Connection to the database has been interrupted”, po wywołaniu metody, na ekranie powinno pojawić się
na przykład:
Tue Oct 26 17:11:24 CEST 2021  ----  Connection to the database has been interrupted
Wskazówka - do uzyskania bieżącego czasu, możesz użyć
Calendar.getInstance().time
Następnie, dodaj “extension function” o nazwie surroundedLog, która przyjmuje jako argument
komunikat oraz wypisuje na ekranie 3 linie gdzie pierwsza linia to ciąg n dowolnych znaków (separatorów),
w drugiej linii znajduje się komunikat, a w trzeciej znowu ciąg n znaków (separatorów).
Uwaga: n powinno wynosić tyle ile znaków jest w komunikacie. Na przykład:
-------------------------------------------
Connection to database has been interrupted
-------------------------------------------*/

class SimpleLogger {

    fun log(message: String) {
        var time = Calendar.getInstance().time
        println(time.toString() + " ---- " + message);   // obczaj jak to można zmienić
    }
}

    fun main() {   // w momencie używania klasy mogę dopisać funkcję do tej klasy

        val simpleLogger = SimpleLogger()
        simpleLogger.log("Connection to database has been interupted")

        fun SimpleLogger.surroundedLog(message: String) {
            /*fun separator (n : Int) {
                for(i in 1 .. n) {
                    print("-")
                }
            }*/
            fun separator(n : Int) {
                print("-".repeat(n))
            }
            val messageLength = message.length
            separator(messageLength)
            print("\n" + message + "\n")
            separator(messageLength)
        }

        simpleLogger.surroundedLog("Connection has been interupted")

    }