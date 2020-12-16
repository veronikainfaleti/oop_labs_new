package phonebook

import kotlin.test.assertEquals


fun main() {
    //test contact
    println(Contact("1","23", mutableSetOf(Number(NumberType.MOBILE, "123"), Number(NumberType.HOME, "+123"))))
    //some contacts
    val addPhoneNumber = Contact("1", "23", mutableSetOf(Number(NumberType.MOBILE, "123")))
    addPhoneNumber.addPhoneNumber(NumberType.MOBILE, "88005553535") //true
    addPhoneNumber.removePhoneNumber(NumberType.MOBILE, "123") //true
    addPhoneNumber.removePhoneNumber(NumberType.MOBILE, "1") //false
    val addPhoneNumber2 = Contact("3", "23", mutableSetOf(Number(NumberType.MOBILE, "890")))

    //add contacts to phonebook
    val phonebook = Phonebook(mutableSetOf(addPhoneNumber, addPhoneNumber2))
    phonebook.removeContact(Contact("0", "0", mutableSetOf()))//.also(::println) //false

    //working
    try {
        phonebook.removeContact(10)
    } catch (e: IllegalArgumentException)
    {
        assertEquals("Index out of bounds.", e.message)
    }

    //more contacts
    val addPhoneNumber3 = Contact("first", "23", mutableSetOf(
            Number(NumberType.HOME, "7572344"),
            Number(NumberType.HOME, "7572346"),
    ))
    val spam = Contact("spam", "spam", mutableSetOf(
            Number(NumberType.MOBILE, "+79681851359"),
            Number(NumberType.MOBILE, "84951363782"),
    ))

    //adding contacts
    phonebook.addContact(addPhoneNumber3)
    phonebook.addContact(spam)
    phonebook.addContact(spam) //will not work because spam already exists in phonebook
    phonebook.addContact(mutableListOf(
            addPhoneNumber, //duplicate, will not be included
            spam, //duplicate, will not be included
            Contact(
                    "1",
                    "23",
                    mutableSetOf(
                            Number(NumberType.MOBILE, "123"), //duplicate, will not be included
                            Number(NumberType.MOBILE, "1234") //new number, will be included
                    )
            )
    ))

    //get phonebook
    //-------------------------Phonebook-------------------------
    //Contacts:[
    //Name: 3 23
    //[MOBILE: 890],
    //Name: first 23
    //[HOME: 7572344, HOME: 7572346],
    //Name: spam spam
    //[MOBILE: +79681851359, MOBILE: 84951363782],
    //Name: 1 23
    //[MOBILE: 123, MOBILE: 1234, MOBILE: 88005553535]]
    //-----------------------------------------------------------
    println(phonebook)


    //test find by string function

    /*result:
    * contains '23': [
    * Name: 3 23
    * [MOBILE: 890],
    * Name: first 23
    * [HOME: 7572344, HOME: 7572346],
    * Name: 1 23
    * [MOBILE: 123, MOBILE: 1234, MOBILE: 88005553535]]
    * */
    val stringToContain = "23"
    val contacts = phonebook.find(stringToContain)
    if(phonebook.find(stringToContain).isNotEmpty())
        println("\n\ncontains '$stringToContain': $contacts")
    else println("No contact contains $stringToContain\n\n")

    /*result:
    * No contact contains '235'
    * */
    val stringToNotContain = "235"
    val contacts2 = phonebook.find(stringToNotContain)
    if(phonebook.find(stringToNotContain).isNotEmpty())
        println("\n\ncontains '$stringToNotContain': $contacts2")
    else println("\nNo contact contains '$stringToNotContain'\n\n")


    //get contact test

    /*result:
    * Name: first 23
    * [HOME: 7572344, HOME: 7572346]
    * */
    phonebook.getContact(1).also(::println) //get first contact

    //result - all contacts
    phonebook.getContact(null).also(::println) //get all contacts



    //get contact and change name, then set contact
    //
    //-------------------------Phonebook-------------------------
    //Contacts:[
    //Name: firstname lastname
    //[MOBILE: 777],
    //Name: first 23
    //[HOME: 7572344, HOME: 7572346],
    //Name: spam spam
    //[MOBILE: +79681851359, MOBILE: 84951363782],
    //Name: 1 23
    //[MOBILE: 123, MOBILE: 1234, MOBILE: 88005553535]]
    //-----------------------------------------------------------
    val changeNameContact: Contact = phonebook.getContact(0) as Contact
    changeNameContact.setFirstName("firstname")
    changeNameContact.setLastName("lastname")
    changeNameContact.setNumbers(setOf(Number(NumberType.MOBILE, "777")))
    phonebook.also(::println)
}