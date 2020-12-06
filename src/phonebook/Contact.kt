package phonebook

@Suppress("IMPLICIT_CAST_TO_ANY")
class Contact(
        private var firstname: String,
        private var lastname: String,
        private var numbers: MutableSet<Number>, //person's phone numbers
) {
    //get firstname
    operator fun component1() = firstname
    //get lastname
    operator fun component2() = lastname

    //set firstname
    fun setFirstName(firstName: String) {
        firstname = firstName
    }
    //set lastname
    fun setLastName(lastName: String) {
        lastname = lastName
    }

    //get phone numbers of contact
    fun getNumbers(): Set<Number> {
        return numbers.toSet()
    }

    //set phone numbers to contact
    fun setNumbers(numbersSet: Set<Number>) {
        numbers = numbersSet as MutableSet<Number>
    }

    //adds new phone number to listOfNumbers
    fun addPhoneNumber(
            type: NumberType,
            number: String,
    ): Boolean {
        return numbers.add(Number(type, number))
    }

    //adds new phone number to listOfNumbers
    fun addPhoneNumber(
            number: Number
    ): Boolean {
        return numbers.add(number)
    }

    //deletes phone number from listOfNumbers
    fun removePhoneNumber(
            type: NumberType,
            number: String,
    ): Boolean {
        return numbers.remove(Number(type, number))
    }

    //deletes phone numbers from listOfNumbers
    fun removePhoneNumbers() {
        numbers = mutableSetOf()
    }

    //contacts are equal if they have the same first- and last- names
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Contact

        if (firstname != other.firstname) return false
        if (lastname != other.lastname) return false

        return true
    }

    override fun hashCode(): Int {
        var result = firstname.hashCode()
        result = 31 * result + lastname.hashCode()
        result = 31 * result + numbers.hashCode()
        return result
    }

    override fun toString(): String {
        val numbersString = if (numbers.isEmpty()) "No phone numbers have been detected." else numbers
        return "\nName: $firstname $lastname\n$numbersString"
    }


}