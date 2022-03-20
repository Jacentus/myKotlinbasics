package classesandinterfaces

import entities.Vehicle

class VehicleManagerImpl : VehicleManager {
    private val vehicles = mutableListOf<Vehicle>()

    override fun getBrands(): Set<String> {  // Set eliminuje powtórzenia, nie ma mowy o porządku
 /*       val brands = mutableSetOf<String>()
        for (v in vehicles) {
            brands.add(v.brand)
        }
        return brands*/

        return vehicles.map { it -> it.brand }.toHashSet()

    }

    override fun addVehicle(v: Vehicle) {
        vehicles.add(v)
    }
}