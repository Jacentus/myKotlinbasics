package companionobject

import com.sun.org.apache.xpath.internal.operations.Bool

/*
Zadanie 3
Wykorzystując wiedzę o companion object napisz klasę ListHelper
która jako argument przyjmuje listę słów. Funkcja powinna zwrócić true jeśli w liście znajduje się duplikat  a false - w przeciwnym wypadku. Na przykład, dla listy ["asercja", "aksjomat", "asercja"] wynikiem powinna być wartość true.
Napisz odpowiedni test jednostkowy.
*/

class ListHelper {

    companion object {
        fun containsDuplicate(words: List<String>): Boolean {
            var hashSet = words.toHashSet();
            if (words.size != hashSet.size) return true;
            else return false
        }
    }

    fun main() {

            var list = ArrayList<String>()

            list.add("asercja")
            list.add("aksjomat")
            list.add("asercja")

            //  println(ListHelper.identifyRepetitions(list))


        }

}