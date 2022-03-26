package companionobject

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ListHelperTest{

    @Test
    fun shouldFindDuplicate(){
        //given
        val words = listOf<String>("asercja", "aksjomat", "asercja")

        //when
        val result = ListHelper.containsDuplicate(words)

        //then

        kotlin.test.assertEquals(true, result)

    }


}