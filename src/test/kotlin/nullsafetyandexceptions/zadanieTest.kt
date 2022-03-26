package nullsafetyandexceptions

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class zadanieTest{

    var zadanie = zadanie()

    @Test
    fun testTheSameLengthAndBothNotNull(){
        assertTrue(zadanie.theSameLengthAndNonNull("abc", "abc"))
    }

    @Test
    fun testBothNull(){
        assertFalse(zadanie.theSameLengthAndNonNull(null, null))
    }

    @Test
    fun testFirstNull(){
        assertFalse(zadanie.theSameLengthAndNonNull(null, "abc"))
    }

    @Test
    fun testSecondNull(){
        assertFalse(zadanie.theSameLengthAndNonNull("abc", null))
    }

    @Test
    fun testDifferentSize(){
        assertFalse(zadanie.theSameLengthAndNonNull("abc", "jfiewfiewfa"))
    }



}