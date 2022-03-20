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

    val vehicle : List<Vehicle> = listOf(MotorBike("SuperMotorBike", 150), Car("Megacar", 200))

    fun(vehicle : Vehicle){
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


    /*Zadanie 4
*  Napisz klasę Employee. Klasa powinna zawierać jeden konstruktor z następującymi atrybutami:
* id (typu Long), address, salary, position - dobierz odpowiednie typy. Wszystkie atrybuty oprócz position są obowiązkowe.
* Position może przyjmować tylko jedną z trzech wartości: Manager, Developer, Tester. Jeśli nie zostanie
* podana wartość position podczas instancjonowania obiektu, wówczas zostaje ustawiona wartość domyślna - Developer.
* Następnie dodaj interfejs EmployeeManager z metodami:
* - do dodawania pracownika
* - taką która wypisuje wszystkie informacje (id, address, salary, position) wszystkich aktualnie dodanych pracowników
* - taką, która zwraca sumę wynagrodzeń wszystkich pracowników
* Dodaj klasę EmployeeManagerImpl, która implementuje ten interfejs.
* Obiekty klasy Employee powinny być przechowywane w liście, która jest składową klasy EmployeeManagerImpl.
* Wykonaj odpowiednie testy.
* Do rozwiązania zadania, nie jest wymagane użycie lambd.
*
* Zadanie 4* (dla osób które zrobiły zasadniczą część)
* Użyj lambd podczas implementacji funkcji interfejsu EmployeeManager.
* */



}