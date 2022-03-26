package delegate_properties_lazy_and_observable

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/* powinniśmy przetestować wszystkie publiczne metody klasy testowanej */

class SafeAccountWithPropertyDelegateTest{

    @Test
    fun testToPayWithSuccess(){
        //given
        val a2 = SafeAccountWithPropertyDelegate(2)
        //when
        a2.toPay = 1.0
        //then
        assertEquals(1.0, a2.toPay)
    }

    @Test
    fun testToPayWithFail(){
        //given
        val a2 = SafeAccountWithPropertyDelegate(2)
        //when
        a2.toPay = -1.0
        //then
        assertEquals(0.0, a2.toPay)

    }


}