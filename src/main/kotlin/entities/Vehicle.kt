package entities

abstract class Vehicle (val brand : String) {

    abstract fun run()
    abstract fun stop()

    fun printBrand(){
        print(brand)
    }

}