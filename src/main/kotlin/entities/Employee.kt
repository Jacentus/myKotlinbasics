package entities

data class Employee (val id: Long, var address : String, var salary : Double, var position : Position = Position.Developer) {

/*    override fun toString(): String {
        return "Employee(id=$id, address='$address', salary=$salary, position=$position)"
    }*/

}