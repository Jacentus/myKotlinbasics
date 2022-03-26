package extensions

class Rectangle(val a: Double, val b: Double) { // wzorce są po to aby nie modyfikować istniejących klas. Powinniśmy separować od siebie zadania
                                                // klasa jest domyślnie finalna
    fun area(): Double {
        return a * b
    }
}

    fun main(){   // w momencie używania klasy mogę dopisać funkcję do tej klasy

        fun Rectangle.perimeter(): Double {
            return 2*(a + b)
        }


    fun Rectangle.area() : Double { // to nie jest to samo co override! nie zadziała
        return 1.0
    }

    val rectangle1 = Rectangle(3.0, 2.0)
    println("Area of the rectangle is ${rectangle1.area()}")

        fun String.evenLength() : Boolean {
            return this.length % 2 == 0
        }

        println("test".evenLength())

}

