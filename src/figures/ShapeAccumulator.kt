package figures

class ShapeAccumulator<T: Shape> {
    private val shapes = ArrayList<T>()

    fun add(shape: T) {
        this.shapes.add(shape)
    }

    fun addAll(shapes: Collection<T>) {
        this.shapes.addAll(shapes)
    }

    fun getMaxAreaShape(): Shape {
        var maxAreaShape = this.shapes[0]
        for (figure in shapes) {
            //get figure with the largest area
            if (figure.getCalcArea()>maxAreaShape.getCalcArea()) {
                maxAreaShape = figure
            }
        }

        return maxAreaShape
    }

    fun getMinAreaShape(): Shape {
        var minAreaShape = this.shapes[0]
        for (figure in shapes) {
            //get figure with the smallest area
            if (figure.getCalcArea()<minAreaShape.getCalcArea()) {
                minAreaShape = figure
            }
        }

        return minAreaShape
    }

    fun getMaxPerimeterShape(): Shape {
        var maxPerimeterShape = this.shapes[0]
        for (figure in shapes) {
            //get figure with the largest perimeter
            if (figure.getCalcPerimeter()>maxPerimeterShape.getCalcPerimeter()) {
                maxPerimeterShape = figure
            }
        }

        return maxPerimeterShape
    }

    fun getMinPerimeterShape(): Shape {
        var minPerimeterShape = this.shapes[0]
        for (figure in shapes) {
            //get figure with the smallest perimeter
            if (figure.getCalcPerimeter()<minPerimeterShape.getCalcPerimeter()) {
                minPerimeterShape = figure
            }
        }

        return minPerimeterShape
    }

    fun getTotalArea(): Double {
        var totalArea = 0.0
        for (figure in shapes) {
            //get total area
            totalArea += figure.getCalcArea()
        }

        return totalArea
    }

    fun getTotalPerimeter(): Double {
        var totalPerimeter = 0.0
        for (figure in shapes) {
            //get total perimeter
            totalPerimeter += figure.getCalcPerimeter()
        }

        return totalPerimeter
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ShapeAccumulator<*>

        if (shapes != other.shapes) return false

        return true
    }

    override fun hashCode(): Int {
        return shapes.hashCode()
    }

    override fun toString(): String {
        return "ShapeAccumulator(shapes=$shapes)"
    }


}