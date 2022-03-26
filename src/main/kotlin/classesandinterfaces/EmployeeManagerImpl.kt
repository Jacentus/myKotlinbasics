package classesandinterfaces

import entities.Employee
import entities.Vehicle

class EmployeeManagerImpl : EmployeeManager {

    var employeesList = mutableListOf<Employee>()

    override fun addEmployee(employee: Employee) {
        employeesList.add(employee)
    }

    override fun getAllEmployeesDetails() {
        for (e in employeesList) println(e.toString())
    }

    override fun getSalarySum() : Double {
    //return employeesList.map { employee -> a }
        var sum = 0.0
        for (e in employeesList){
            sum += e.salary
        }
        return sum
    }
}