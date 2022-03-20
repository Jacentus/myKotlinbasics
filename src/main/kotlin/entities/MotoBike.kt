package entities

class MotorBike (brand: String, val maxSpeed: Int, val color: Color = Color.BLACK, ) : Vehicle(brand)  { //konstruktor z nadklasy

    override fun run() {
        println("MotorBike started")
    }

    override fun stop() {
        println("MotorBike stoped")
    }


}