package delegations

/*Zadanie 2
Napisz klasę  MainRandGenerator
która implementuje interfejs:
interface RandGenerator {
    fun rand(amount : Int, min: Int, max: Int) : List<Int>
}
Metoda rand powinna zwrócić listę <amount> liczb  wylosowanych z przedziału obustronnie domkniętego [min, max]
Następnie, wykorzystując delegację klas, napisz klasę SpecialRandGenerator
która implementuje metodę rand w ten sposób że w zwróconej liście nie ma powtórzeń. W przypadku niepoprawnych argumentów, rzuć wyjątek IllegalArgumentException*/

interface RandGenerator {
    fun rand(amount : Int, min: Int, max: Int) : List<Int>
}

class MainRandGenerator : RandGenerator {

    override fun rand(amount: Int, min: Int, max: Int): List<Int> {
        if (amount < 0 || min > max) {
            throw IllegalArgumentException("illegal values")
        }
        val amount = ArrayList<Int>() // lista jest mutable !
        for (i in min..max) {
            val randNumber = (1..100).random()
            amount.add(randNumber)
        }
        return amount
    }
}

class SpecialRandGenerator(var randGenerator : RandGenerator) : RandGenerator by randGenerator {

    override fun rand(amount: Int, min: Int, max: Int): List<Int> {
        //randGenerator.rand(amount, min, max) mogę wywołać funkcję z przekazanej klasy

        if (min <=0 || max <= 0) {
            throw IllegalArgumentException("invalid valuses")
        }
        val amount = ArrayList<Int>()
        for (i in min..max) {
            val randNumber = (1..100).random()
            amount.add(randNumber)
        }
        val set = HashSet<Int>()
        for (i in amount) {
            set.add(i)
        }
        // set.toList() mogę też tak :)
        val finalList = ArrayList<Int>()
        for (i in set){
            finalList.add(i)
        }
        return finalList
    }
}

fun main(){

    val mainRandGenerator = MainRandGenerator()

    val specialRandGenerator = SpecialRandGenerator(mainRandGenerator)

    println(specialRandGenerator.rand(100, 1, 5));

}
