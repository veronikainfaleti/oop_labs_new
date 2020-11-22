package figures

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ExceptionsTest {
    //---------------
    //exceptions test
    //---------------

    @Test
    fun triangle() {
        //try to make triangle that does not exist
        try {
            Triangle(5.0, 10.0, 19.0).also(block = ::println)
        } catch (e: IllegalArgumentException) {
            assertEquals("The triangle with sides 5.0, 10.0, 19.0 does not exist.", e.message)
        }
    }

    @Test
    fun triangle2() {
        //try to make triangle that does not exist
        try {
            Triangle(-1.0, 10.0, 8.0).also(block = ::println)
        } catch (e: IllegalArgumentException) {
            assertEquals("The triangle with sides -1.0, 10.0, 8.0 does not exist.", e.message)
        }
    }

    @Test
    fun circle() {
        //try to make circle that does not exist
        try {
            Circle(-10.0).also(::println);
        } catch (e: IllegalArgumentException) {
            assertEquals("The circle radius must be positive.", e.message)
        }
    }

    @Test
    fun square() {
        //try to make square that does not exist
        try {
            Square(-10.0, ).also(block = ::println)
        } catch (e: IllegalArgumentException) {
            assertEquals("The sides must be positive.", e.message)
        }
    }
    @Test
    fun rectangle() {
        //try to make rectangle that does not exist
        try {
            Rectangle(10.0, -20.0, ).also(::println);
        } catch (e: IllegalArgumentException) {
            assertEquals("The sides must be positive.", e.message)
        }
    }
}