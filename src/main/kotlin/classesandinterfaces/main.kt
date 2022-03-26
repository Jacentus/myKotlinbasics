package classesandinterfaces

import entities.*

//class A

fun main() {

    val p1 = Point3D(-0.1, 2.3, 5.0)
    println(p1.x) // dzięki VAL w konstruktorze mam dostęp

    val customer1 = Customer("Jacek", "+48 606 223 456")
    Customer("Kasia", nationality = "German").logData() //obiekt anonimowy
    customer1.logData()

    val train1 = Train(23, 34567, "Ciuchcia")
    val train2 = Train(30, 5000, "Drezyna")
    val train3 = Train(30, 5000, "Drezyna")

    println(train1.hashCode())
    println(train2.hashCode())
    println(train3.hashCode())

    println(train1.equals(train2))
    println(train2.equals(train3)) // jeśli nie nadpiszę metod hashcode i equals, to będą równe bo będzie porównywał referencje, a nie wartości

    val box1 = Box("test", 11)
    println(box1)
    box1.resetAllData()
    println(box1)

    val vehicle: List<Vehicle> = listOf(MotorBike("SuperMotorBike", 150), Car("Megacar", 200))

    fun(vehicle: Vehicle) {
        vehicle.run()
    }

    val vehicleManager = VehicleManagerImpl()
    vehicleManager.addVehicle(MotorBike("SuperMotorBike", 150))
    vehicleManager.addVehicle(Car("Megacar", 200))
    vehicleManager.addVehicle(Car("Megacar", 200))

    println(vehicleManager.getBrands())

    var player1 = Player("stefan", true)
    println(player1) // dzięki data przed klasą Player mam toString


    var employee = Employee(100, "Krzemowa", 100.00)
    var employee2 = Employee(50, "Abrahama", 5000.0, Position.Manager)

    var employeeManager = EmployeeManagerImpl()
    employeeManager.employeesList = mutableListOf<Employee>(employee, employee2)

    employeeManager.getAllEmployeesDetails()

    employeeManager.addEmployee(Employee(10, "Długa", 1000.0, Position.Tester))

    employeeManager.getAllEmployeesDetails()
    println(employeeManager.getSalarySum())

    // player1.name = "Jerzy" nie mogę, bo dałem VAL (!)

// w kotlinie klasy defaultowo są final, a gdy chcemy inaczej, trzeba użyć open
    open class A constructor(a: Int, b: String?) {
        public fun f() {}
    }

    class B(a: Int, b: String?, c: String?) : A(a, b)

    //modyfikatory dostępu
    open class C {
        val name = "test"
        private val number = 1
        internal open val x =
            'a' //składowa x jest dostępna tylko w ramach tego samego modułu (moduł = zbiór skompilowanych źródeł)

        protected open fun f() {}
    }

}