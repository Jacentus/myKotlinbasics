package entities

/* data class! Najczęściej dla klas encyjnych. Dzięki temu:
- automatycznie dodamy equals, hashode, toString...
- ...copy()
*/
data class Player(val name: String, var active:Boolean) {



}