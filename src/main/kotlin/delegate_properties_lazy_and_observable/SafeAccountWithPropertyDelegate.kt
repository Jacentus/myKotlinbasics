package delegate_properties_lazy_and_observable

// SEPARACJA - ROZDZIELANIE NA CZĘŚCI NIEZALEŻNE. WYCIĄGAMY LOGIKĘ DO ODSEPAROWANEJ KLASY I ELIMINUJEMY POWTÓRZENIA
class SafeAccountWithPropertyDelegate(val id: Int) {
    var updateCount = 0
    var toPay: Double by PositiveValueDelegate()//
    var debt : Double by PositiveValueDelegate()// chcemy dodać kontrolę wartości
}

// w kotlinie na szczycie hierarchi mamy Any, po niej dziedizczą wszystkie klasy (jak Object w Java)
// znak zapytania oznacza że może być null
