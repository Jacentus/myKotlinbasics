package entities

class Train constructor(val cartNo : Int, val capacity : Int, val model : String) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Train

        if (cartNo != other.cartNo) return false
        if (capacity != other.capacity) return false
        if (model != other.model) return false

        return true
    }

    override fun hashCode(): Int {
        var result = cartNo
        result = 31 * result + capacity
        result = 31 * result + model.hashCode()
        return result
    }
}