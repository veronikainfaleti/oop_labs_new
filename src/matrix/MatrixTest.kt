package matrix

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class MatrixTest {
    private val matrix1 = Matrix(Array(3){arrayOf(1.0, 2.0, 3.0)})
    private val matrix2 = Matrix(Array(3){ Array(3){1.0} })

    @Test
    fun plus() {
        val matrixplus = matrix1+matrix2
        val matrixactual = Matrix(Array(3){arrayOf(2.0, 3.0, 4.0)})

        assertEquals(matrixactual, matrixplus)
        assertEquals(matrixactual.getDeterminant(), matrixplus.getDeterminant())
    }

    @Test
    fun minus() {
        val matrixminus = matrix1-matrix2
        val matrixactual = Matrix(Array(3){arrayOf(0.0, 1.0, 2.0)})

        assertEquals(matrixactual, matrixminus)
        assertEquals(matrixactual.getDeterminant(), matrixminus.getDeterminant())
    }

    @Test
    fun times1() {
        val matrixtimes = matrix1*matrix2
        val matrixactual = Matrix(Array(3){Array(3){6.0}})

        assertEquals(matrixactual, matrixtimes)
    }

    @Test
    fun times2() {
        val m1 = Matrix(Array(1){ arrayOf(1.0, 2.0, 3.0)})
        val m2 = Matrix(Array(3){ arrayOf(1.0, 2.0, 3.0, 4.0)})
        val matrixtimes = m1*m2
        val matrixactual = Matrix(Array(1){arrayOf(1.0, 2.0, 3.0, 4.0)}) * 6.0

        assertEquals(matrixactual, matrixtimes)
    }

    @Test
    fun getDeterminant() {
        val matrix = Matrix(3).apply {
            this[0,0]=1.0
            this[0,1]=2.0
            this[0,2]=5.0
            this[1,0]=10.0
            this[1,1]=4.0
            this[1,2]=5.0
            this[2,0]=10.0
            this[2,1]=2.0
        }

        assertEquals(-10.0, matrix.getDeterminant())
    }

    @Test
    fun excConstructor() {
        try {
            Matrix(-2,1)
        } catch (e: IllegalArgumentException) {
            assertEquals("Dimensions must be positive.", e.message)
        }
    }

    @Test
    fun excGet() {
        try {
            Matrix(2,1)[3,0]
        } catch (e: IllegalArgumentException) {
            assertEquals("Indices are out of range.", e.message)
        }
    }

    @Test
    fun excSet() {
        try {
            Matrix(2,1).set(2,0,3.0)
        } catch (e: IllegalArgumentException) {
            assertEquals("Indices are out of range.", e.message)
        }
    }

    @Test
    fun excPlus() {
        val m1 = Matrix(2,1)
        val m2 = Matrix(2,2)
        try {
            m1+m2
        } catch (e: IllegalArgumentException) {
            assertEquals("Matrices must have the same dimensions.", e.message)
        }
    }

    @Test
    fun excMinus() {
        val m1 = Matrix(2,1)
        val m2 = Matrix(2,2)
        try {
            m1-m2
        } catch (e: IllegalArgumentException) {
            assertEquals("Matrices must have the same dimensions.", e.message)
        }
    }

    @Test
    fun excTimesMatrix() {
        val m1 = Matrix(2,1)
        val m2 = Matrix(2,2)
        try {
            m1*m2
        } catch (e: IllegalArgumentException) {
            assertEquals("Matrices cannot be multiplied.", e.message)
        }
    }

    @Test
    fun excGetDeterminant() {
        val m1 = Matrix(2,1)
        try {
            m1.getDeterminant()
        } catch (e: IllegalArgumentException) {
            assertEquals("Matrix must be square.", e.message)
        }
    }
}
