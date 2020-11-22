package matrix
import kotlin.math.pow

class Matrix(private val rows:Int, private val columns:Int = rows) {
    private var matrix: Array<Array<Double>>

    private fun getRowsNumber(): Int = matrix.size
    private fun getColumnsNumber(): Int = matrix[0].size

    operator fun component1() = this.rows
    operator fun component2() = this.columns

    init {
        require(!(rows <= 0 || columns <= 0)) {"Dimensions must be positive."}
        matrix = Array(rows) { Array(columns) {0.0} }
    }
    constructor(matrix:Array<Array<Double>>): this(matrix.size, matrix[0].size) {
        this.matrix = matrix
    }

    operator fun get(i:Int, j:Int): Double {
        require(i in 0 until rows && j in 0 until columns) {"Indices are out of range."}
        return matrix[i][j]
    }

    operator fun set(i:Int, j:Int, value:Double) {
        require(i in 0 until rows && j in 0 until columns) {"Indices are out of range."}
        matrix[i][j]=value
    }

    fun getDimensions(): String {
        return "$rows * $columns"
    }

    private fun isSameDimensions(rightMatrix: Matrix) = (getRowsNumber() == rightMatrix.getColumnsNumber() && getRowsNumber() == rightMatrix.getRowsNumber())

    private fun canMultiply(rightMatrix: Matrix) = getColumnsNumber() == rightMatrix.getRowsNumber()

    operator fun plus(rightMatrix:Matrix): Matrix {
        if (!isSameDimensions(rightMatrix))
            throw IllegalArgumentException("Matrices mast have the same dimensions.")
        val newMatrix = Matrix(getRowsNumber(), getColumnsNumber())
        for(row in 0 until getRowsNumber()) {
            for (column in 0 until getColumnsNumber()) {
                newMatrix[row, column] = this[row,column] + rightMatrix[row, column]
            }
        }
        return newMatrix
    }

    operator fun times(rightMatrix:Matrix): Matrix {
        if(!canMultiply(rightMatrix))
            throw IllegalArgumentException("Matrices cannot be multiplied.")
        val newMatrix = Matrix(getRowsNumber(), rightMatrix.getColumnsNumber())
        (0 until getRowsNumber()).forEach { row ->
            (0 until rightMatrix.getColumnsNumber()).forEach { column ->
                (0 until rightMatrix.getRowsNumber()).forEach {
                    newMatrix[row, column] += this[row, it] * rightMatrix[it, column]
                }
            }
        }
        return newMatrix
    }

    operator fun times(scalar: Double): Matrix {
        val newMatrix = Matrix(getRowsNumber(), getColumnsNumber())
        for(row in 0 until getRowsNumber()) {
            for (column in 0 until getColumnsNumber()) {
                newMatrix[row, column] = this[row, column] * scalar
            }
        }
        return newMatrix
    }

    operator fun minus(rightMatrix: Matrix): Matrix = this + rightMatrix.times(-1.0)

    fun getDeterminant(): Double {
        if (getRowsNumber() != getColumnsNumber())
            throw IllegalArgumentException("Matrix must be square.")
        var determinant = 0.0
        when(getRowsNumber()) {
            1 -> return this[0, 0]
            2 -> return this[0, 0]*this[1, 1] - this[1,0]*this[0,1]
            else -> {
                for (i in 0 until getRowsNumber()) {
                    val minorMatrix = Matrix(this.getRowsNumber()-1)
                    for (j in 1 until getRowsNumber())
                        for (k in 0 until getRowsNumber()) when {
                            k < i -> minorMatrix[j - 1, k] = this[j, k]
                            k > i -> minorMatrix[j - 1, k - 1] = this[j, k]
                        }
                    determinant += this[0, i] * (-1.0).pow(i) * minorMatrix.getDeterminant()
                }
                return determinant
            }
        }

    }

    override fun toString(): String {
        var string = ""
        for(row in 0 until getRowsNumber()) {
            for (column in 0 until getColumnsNumber()) {
                if (column == 0) string += "|"
                string += " ${matrix[row][column]}"
                if (column == getColumnsNumber()-1) string += " |\n"

            }
        }
        return string
    }


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Matrix

        if (rows != other.rows) return false
        if (columns != other.columns) return false
        if (!matrix.contentDeepEquals(other.matrix)) return false

        return true
    }

    override fun hashCode(): Int {
        return matrix.hashCode()
    }
}



