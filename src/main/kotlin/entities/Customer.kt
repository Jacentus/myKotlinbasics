package entities

class Customer constructor(val firstName: String,
                           val phoneNumber: String? = null,
                            val nationality : String = "Polish") {
// nie trzeba zmuszać do podawania wszystkich wartości. Jeśli definiując obiekt nikt nie poda wartości dla phonenumber to będzie to null
    // w przypadku nationality nie może być to null, jeśli nie będzie wartości, to przyjmie wartość default

   fun logData(){
       println(firstName + " " + if(phoneNumber==null) " with no phone number " else phoneNumber + nationality)
   }



}