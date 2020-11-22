package figures

class Square(private val a: Double,) : Rectangle(a) {
    override fun toString(): String {
        return "Figures.Square: a=$a\n" +
                "Area = ${getCalcArea()}\n" +
                "Perimeter = ${getCalcPerimeter()}\n"
    }
}