package javaintegration

import java.math.BigDecimal

fun main() {

    val num = BigDecimal(1234) //z poziomu kotlina używamy klasy z Javy.
// Istnieje korealcja między wersją kotlina a javy, musimy popatrzeć jaka Java Compiler jest w Settingsach (file  ->settings)
    print(num)

    Logger.logMessage(LogType.WARNING, "warning message")

}