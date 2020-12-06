import org.junit.Test
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class MarkdownToHtmlTest {

    @Test
    fun `valid case with h1`() {
        val toHtml = MarkdownToHtml()
        assertEquals("<h1>Test</h1>", toHtml.convert("# Test"))
    }

    @Test
    fun `valid case with h6`() {
        val toHtml = MarkdownToHtml()
        assertEquals("<h6>Test</h6>", toHtml.convert("###### Test"))
    }

    @Test
    fun `valid case with extra spaces`() {
        val toHtml = MarkdownToHtml()
        assertEquals("<h6>Test</h6>", toHtml.convert("    ######   Test    "))
    }

    @Test
    fun `no space raise exception`() {
        val toHtml = MarkdownToHtml()
        assertFailsWith<NoSpaceException> {toHtml.convert("#Test")}
    }

    @Test
    fun `invalid markdown raise exception`() {
        val toHtml = MarkdownToHtml()
        assertFailsWith<IllegalArgumentException> {toHtml.convert("#1## Test")}
    }

    @Test
    fun `No hashes raise exception`() {
        val toHtml = MarkdownToHtml()
        assertFailsWith<NoHashesException> {toHtml.convert("Test")}
    }

    @Test
    fun `too many hashes raise exception`() {
        val toHtml = MarkdownToHtml()
        assertFailsWith<IllegalArgumentException> { toHtml.convert("####### Test") }
    }

}