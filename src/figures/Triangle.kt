package figures

import kotlin.math.sqrt

class Triangle(
        private val a: Double,
        private val b: Double = a,
        private val c: Double = a,
): Shape {

    init {
        require((a+b>c) && (a+c>b) && (b+c>a))
        { "The triangle with sides $a, $b, $c does not exist." }
    }

    override fun getCalcArea(): Double {
            val p = getCalcPerimeter() / 2
        return sqrt(p * (p - a) * (p - b) * (p - c))
    }

    override fun getCalcPerimeter(): Double = a+b+c

    override fun toString(): String {
        return "Figures.Triangle: a=${a}, b=${b}, c=${c}\n" +
                "Area = ${getCalcArea()}\n" +
                "Perimeter = ${getCalcPerimeter()}\n"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Triangle

        if (a != other.a) return false
        if (b != other.b) return false
        if (c != other.c) return false

        return true
    }

    override fun hashCode(): Int {
        var result = a.hashCode()
        result = 31 * result + b.hashCode()
        result = 31 * result + c.hashCode()
        return result
    }

}