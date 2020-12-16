package phonebook

class Phonebook(private val contacts: MutableSet<Contact>) {
    //add one contact into phonebook
    fun addContact(contact: Contact): Boolean {
        return contacts.add(contact)
    }

    //add list of contacts to phonebook
    fun addContact(contacts_: MutableList<Contact>): Boolean {
        for (contact in contacts_) {
            val contactDuplicate = contacts.find { it == contact }
            if (contactDuplicate != null) {
                val set = contact.getNumbers() + contactDuplicate.getNumbers()
                contact.setNumbers(set)
                contacts.remove(contactDuplicate)
            }
            contacts.add(contact)
        }
        return true
    }

    //remove contact from phonebook by finding exact same contact if exists
    fun removeContact(contact: Contact): Boolean {
        return contacts.remove(contact)
    }

    //remove contact by index
    fun removeContact(index: Int): Boolean {
        require(index in 0 until contacts.size) { "Index out of bounds." }
        return contacts.remove(contacts.elementAt(index))
    }

    //get contact by index. if index is null function returns all contacts of phonebook
    fun getContact(index: Int?): Any {
        return if (index!=null) {
            require(index in 0 until contacts.size) { "Index out of bounds." }
            contacts.elementAt(index)
        }
        else contacts.toSet()
    }

    //find contact that contains str
    fun find(str: String): List<Contact> {
        val listOfContacts = mutableListOf<Contact>()
        for (contact in contacts) {
            if(contact.component1().contains(str) || contact.component2().contains(str) || contact.getNumbers().any { it.number.contains(str) })
                listOfContacts.add(contact)
        }
        return listOfContacts.toList()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Phonebook

        if (contacts != other.contacts) return false

        return true
    }

    override fun hashCode(): Int {
        return contacts.hashCode()
    }

    override fun toString(): String {
        return "\n" +
                "-------------------------" +
                "Phonebook" +
                "-------------------------" +
                "\nContacts:$contacts\n" +
                "-----------------------------------------------------------"
    }


}