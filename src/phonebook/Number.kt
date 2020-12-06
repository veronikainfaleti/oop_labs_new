package phonebook

data class Number (
        val type: NumberType,
        val number: String,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Number

        if (type != other.type) return false
        if (number != other.number) return false

        return true
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + number.hashCode()
        return result
    }

    override fun toString(): String {
        return "$type: $number"
    }
}