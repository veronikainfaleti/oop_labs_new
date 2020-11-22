package figures

fun main() {

    //make triangle
    val triangle = Triangle(
            3.0,
            4.0,
            5.0,
    ).also(block = ::println)
    val triangle2 = Triangle(
            5.0,
    ).also(block = ::println)

    //make circles
    val circle = Circle(2.0,).also(::println);
    val circle2 = Circle(2.0,).also(::println);
    val circle3 = Circle(8.0,).also(::println);

    //make square
    val square = Square(10.0,).also(block = ::println)
    val square2 = Square(3.5,).also(block = ::println)

    //make rectangles
    val rectangle = Rectangle(10.0, 20.0,).also(::println);
    val rectangle2 = Rectangle(3.0, 14.0,).also(::println);

    //list of figures
    ArrayList<Shape>().apply {
        add(rectangle)
        add(rectangle2)
        add(triangle)
        add(triangle2)
        add(circle)
        add(circle2)
        add(circle3)
        add(square)
        add(square2)
    }.apply {
        var perimeter = 0.0 //total perimeter
        var area = 0.0 //total area

        //figure with the largest perimeter
        var largestPerimeterFigure = this[0]
        //figure with the largest area
        var largestAreaFigure = this[0]
        //figure with the smallest perimeter
        var smallestPerimeterFigure = this[0]
        //figure with the smallest area
        var smallestAreaFigure = this[0]

        //iterate over list
        for (figure in this) {
            //get total perimeter and area
            perimeter += figure.getCalcPerimeter()
            area += figure.getCalcArea()

            //get figure with the largest perimeter
            if (figure.getCalcPerimeter()>largestPerimeterFigure.getCalcPerimeter()) {
                largestPerimeterFigure = figure
            }
            //get figure with the smallest perimeter
            if (figure.getCalcPerimeter()<smallestPerimeterFigure.getCalcPerimeter()) {
                smallestPerimeterFigure = figure
            }

            //get figure with the largest area
            if (figure.getCalcArea()>largestAreaFigure.getCalcArea()) {
                largestAreaFigure = figure
            }
            //get figure with the smallest area
            if (figure.getCalcPerimeter()<smallestAreaFigure.getCalcPerimeter()) {
                smallestAreaFigure = figure
            }
        }
        //print all the parameters to the console
        println("\n Total perimeter = $perimeter, " +
                "total area = $area.\n" +
                "Largest perimeter = ${largestPerimeterFigure.getCalcPerimeter()} " +
                "in $largestPerimeterFigure, " +
                "largest area = ${largestAreaFigure.getCalcArea()} " +
                "in $largestAreaFigure.\n" +
                "Smallest perimeter = ${smallestPerimeterFigure.getCalcPerimeter()} " +
                "in $smallestPerimeterFigure, " +
                "smallest area = ${smallestAreaFigure.getCalcArea()} " +
                "in $smallestAreaFigure.\n"
        )
    }
}