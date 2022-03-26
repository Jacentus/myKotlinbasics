package delegate_properties_lazy_and_observable

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class PositiveValueDelegate: ReadWriteProperty<Any?, Double> {// implementacja interfejsu

    private var positiveValue: Double = 0.0

    override fun getValue(thisRef: Any?, // referencja na obiekt klasy której dotyczy propercja
                          property: KProperty<*> //
    ): Double {
        return positiveValue
    }

    override fun setValue(thisRef: Any?,
                          property: KProperty<*>,
                          value: Double) {
        // wyciągamy przed nawias to, co było wspólne w setterze. Przed update'm tego licznika

    }
}