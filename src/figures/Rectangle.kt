package figures

open class Rectangle(
        private val a: Double,
        private val b: Double = a,
) : Shape {

    init {
        require(a>0 && b>0) { "The sides must be positive." }
    }

    override fun getCalcArea(): Double = a*b
    override fun getCalcPerimeter(): Double = 2*(a+b)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Rectangle

        if (a != other.a) return false
        if (b != other.b) return false

        return true
    }

    override fun hashCode(): Int {
        var result = a.hashCode()
        result = 31 * result + b.hashCode()
        return result
    }

    override fun toString(): String {
        return "Figures.Rectangle: a=$a, b=$b\n" +
                "Area = ${getCalcArea()}\n" +
                "Perimeter = ${getCalcPerimeter()}\n"
    }


}