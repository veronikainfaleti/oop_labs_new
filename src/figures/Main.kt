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
    val shapes = ArrayList<Shape>().apply {
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
            if (figure.getCalcArea()<smallestAreaFigure.getCalcArea()) {
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



    //_______________________________________________________________________//
    //tests for ShapeAccumulator

    println("\n\n\n----------tests for ShapeAccumulator\n")
    val shapeAccumulatorTriangle: ShapeAccumulator<Triangle> = ShapeAccumulator(triangle)
    val maxAreaShape = shapeAccumulatorTriangle.getMaxAreaShape()
    val maxPerimeterShape = shapeAccumulatorTriangle.getMaxPerimeterShape()
    val minAreaShape = shapeAccumulatorTriangle.getMinAreaShape()
    val minPerimeterShape = shapeAccumulatorTriangle.getMinPerimeterShape()
    val totalArea = shapeAccumulatorTriangle.getTotalArea()
    val totalPerimeter = shapeAccumulatorTriangle.getTotalPerimeter()

    //print all the parameters to the console
    println("\n Total perimeter = $totalPerimeter, " +
            "total area = $totalArea.\n" +
            "\nLargest perimeter = ${maxPerimeterShape.getCalcPerimeter()} " +
            "in $maxPerimeterShape, " +
            "\nlargest area = ${maxAreaShape.getCalcArea()} " +
            "in $maxAreaShape.\n" +
            "\nSmallest perimeter = ${minPerimeterShape.getCalcPerimeter()} " +
            "in $minPerimeterShape, " +
            "\nsmallest area = ${minAreaShape.getCalcArea()} " +
            "in $minAreaShape.\n"
    )


    shapeAccumulatorTriangle.addAll(arrayListOf(triangle, triangle2))
    val maxAreaShape2 = shapeAccumulatorTriangle.getMaxAreaShape()
    val maxPerimeterShape2 = shapeAccumulatorTriangle.getMaxPerimeterShape()
    val minAreaShape2 = shapeAccumulatorTriangle.getMinAreaShape()
    val minPerimeterShape2 = shapeAccumulatorTriangle.getMinPerimeterShape()
    val totalArea2 = shapeAccumulatorTriangle.getTotalArea()
    val totalPerimeter2 = shapeAccumulatorTriangle.getTotalPerimeter()

    //print all the parameters to the console
    println("\n Total perimeter = $totalPerimeter2, " +
            "total area = $totalArea2.\n" +
            "\nLargest perimeter = ${maxPerimeterShape2.getCalcPerimeter()} " +
            "in $maxPerimeterShape2, " +
            "\nlargest area = ${maxAreaShape2.getCalcArea()} " +
            "in $maxAreaShape2.\n" +
            "\nSmallest perimeter = ${minPerimeterShape2.getCalcPerimeter()} " +
            "in $minPerimeterShape2, " +
            "\nsmallest area = ${minAreaShape2.getCalcArea()} " +
            "in $minAreaShape2.\n"
    )

    shapeAccumulatorTriangle.add(triangle)
    val maxAreaShape21 = shapeAccumulatorTriangle.getMaxAreaShape()
    val maxPerimeterShape21 = shapeAccumulatorTriangle.getMaxPerimeterShape()
    val minAreaShape21 = shapeAccumulatorTriangle.getMinAreaShape()
    val minPerimeterShape21 = shapeAccumulatorTriangle.getMinPerimeterShape()
    val totalArea21 = shapeAccumulatorTriangle.getTotalArea()
    val totalPerimeter21 = shapeAccumulatorTriangle.getTotalPerimeter()

    //print all the parameters to the console
    println("\n Total perimeter = $totalPerimeter21, " +
            "total area = $totalArea21.\n" +
            "\nLargest perimeter = ${maxPerimeterShape21.getCalcPerimeter()} " +
            "in $maxPerimeterShape21, " +
            "\nlargest area = ${maxAreaShape21.getCalcArea()} " +
            "in $maxAreaShape21.\n" +
            "\nSmallest perimeter = ${minPerimeterShape21.getCalcPerimeter()} " +
            "in $minPerimeterShape21, " +
            "\nsmallest area = ${minAreaShape21.getCalcArea()} " +
            "in $minAreaShape21.\n"
    )


    val shapeAccumulator: ShapeAccumulator<Shape> = ShapeAccumulator(shapes)
    val maxAreaShape3 = shapeAccumulator.getMaxAreaShape()
    val maxPerimeterShape3 = shapeAccumulator.getMaxPerimeterShape()
    val minAreaShape3 = shapeAccumulator.getMinAreaShape()
    val minPerimeterShape3 = shapeAccumulator.getMinPerimeterShape()
    val totalArea3 = shapeAccumulator.getTotalArea()
    val totalPerimeter3 = shapeAccumulator.getTotalPerimeter()

    //print all the parameters to the console
    println("\n Total perimeter = $totalPerimeter3, " +
            "total area = $totalArea3.\n" +
            "\nLargest perimeter = ${maxPerimeterShape3.getCalcPerimeter()} " +
            "in $maxPerimeterShape3, " +
            "\nlargest area = ${maxAreaShape3.getCalcArea()} " +
            "in $maxAreaShape3.\n" +
            "\nSmallest perimeter = ${minPerimeterShape3.getCalcPerimeter()} " +
            "in $minPerimeterShape3, " +
            "\nsmallest area = ${minAreaShape3.getCalcArea()} " +
            "in $minAreaShape3.\n"
    )

}