import org.junit.Test
import kotlin.test.assertEquals

class MorseTest {

    @Test
    fun `when given a full signal then returns valid result`() {
        val morse = Morse()
        assertEquals(listOf('b'), morse.decode("-..."))
        assertEquals(listOf('f'), morse.decode("..-."))
        assertEquals(listOf('z'), morse.decode("--.."))
        assertEquals(listOf('y'), morse.decode("-.--"))
    }

    @Test
    fun `when given a partial signal then returns list of valid results`() {
        val morse = Morse()
        assertEquals(listOf('g', 'o'), morse.decode("--?"))
        assertEquals(listOf('d', 'g'), morse.decode("-?."))
    }
}
