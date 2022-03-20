package classesandinterfaces

import entities.Employee

interface EmployeeManager {

    fun addEmployee(employee : Employee)
    fun getAllEmployeesDetails()
    fun getSalarySum() : Double

}