package nullsafetyandexceptions

/*
Zadanie 4
W osobnej klasie, zaimplementuj funkcję
fun theSameLengthAndNonNull(word1: String?, word2: String?): Boolean
która zwraca true < = > word1 oraz word2 mają taką samą długość i nie są null
*/

class zadanie {

    /*        fun theSameLengthAndNonNull(word1: String?, word2: String?): Boolean {
            if (word1 != null && word2 != null) {
                if (word1.length.equals(word2.length))
                { return true
                } else return false
            }
            return false
        }
    }*/
    fun theSameLengthAndNonNull(word1: String?, word2: String?): Boolean {
        try {
            return (word1!!.length === word2!!.length)
        } catch (e: NullPointerException) {
            return false
        }
    }
    /*
    fun theSameLengthAndNonNull(word1: String?, word2: String?): Boolean {
        try {
            if (word1!!.length===word2!!.length) {
                return true
            }
        } catch (e: NullPointerException) {
            return false
        }
       return  false
    }
}
*/


    fun main() {

        var zadanie = zadanie()

        println(zadanie.theSameLengthAndNonNull("Jacek", "Placedwedwak"))
        println(zadanie.theSameLengthAndNonNull(null, null))
        println(zadanie.theSameLengthAndNonNull(null, "Jacek"))
        println(zadanie.theSameLengthAndNonNull("Krzysiek", "Krzysiej"))

    }


}