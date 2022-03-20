package entities

class Car (brand: String, val maxSpeed: Int, val color: Color = Color.BLACK) : Vehicle(brand)  { //konstruktor z nadklasy

    override fun run() {
        println("Car started")
    }

    override fun stop() {
        println("Car stoped")
    }


}