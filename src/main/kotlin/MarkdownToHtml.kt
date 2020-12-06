import java.lang.Exception

class MarkdownToHtml {
    fun convert(header: String): String {
        val trimmedHeader = header.trim()
        val headerParts = trimmedHeader.split("# ")
        when {
            headerParts.size == 2 -> {
                require(headerParts[0].length < 6) { "Too many hashes" }
                require(headerParts[0].matches("#+".toRegex()) || headerParts[0].isEmpty()) { "Invalid markdown" }
                val len = headerParts[0].length + 1
                return "<h$len>${headerParts[1].trim()}</h$len>"
            }
            trimmedHeader.contains("#") -> throw NoSpaceException()
            else -> throw NoHashesException()

        }
    }
}

class NoHashesException : Exception("No hashes")
class NoSpaceException : Exception("No space")