import org.junit.Test
import kotlin.test.assertEquals

class SumTest {

    @Test
    fun `when given a positive number returns result`() {
        val sum = Sum()
        assertEquals(0, sum.getSumOfIntegersDivisibleByThreeOrFive(1))
        assertEquals(3, sum.getSumOfIntegersDivisibleByThreeOrFive(3))
        assertEquals(8, sum.getSumOfIntegersDivisibleByThreeOrFive(5))
        assertEquals(33, sum.getSumOfIntegersDivisibleByThreeOrFive(10))
        assertEquals(2333416668, sum.getSumOfIntegersDivisibleByThreeOrFive(100000))
    }
}
