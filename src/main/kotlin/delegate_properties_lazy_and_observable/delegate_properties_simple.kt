package delegate_properties_lazy_and_observable

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/*

class UnsafeAccount(val id: Int) {

    var updateCount = 0

    var toPay: Double = 0.0
        set(value) { // można źle użyć settera, stąd unsafe
            field = value
            updateCount++
        }
        get() = field

    var debt: Double = 0.0
        set(value) {
            field = value
            updateCount++
        }
        get() = field
}*/

/*
class SaferAccount(val id: Int) {

    var updateCount = 0

    var toPay: Double = 0.0
        set(value) { // można źle użyć settera, stąd unsafe
            if (value>0) {
                field = value
                updateCount++
            }
        }
        get() = field

    var debt: Double = 0.0
        set(value) {
            if (value>0) { // bezpieczniej, bo sprawdzamy
                field = value
                updateCount++
            }
        }
        get() = field
}*/