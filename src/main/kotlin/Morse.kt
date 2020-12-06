class Morse {

    private val root: Node?

    private var charMap = mapOf(
            'a' to ".-",
            'b' to "-...",
            'c' to "-.-.",
            'd' to "-..",
            'e' to ".",
            'f' to "..-.",
            'g' to "--.",
            'h' to "....",
            'i' to "..",
            'j' to ".---",
            'k' to "-.-",
            'l' to ".-..",
            'm' to "--",
            'n' to "-.",
            'o' to "---",
            'p' to ".--.",
            'q' to "--.-",
            'r' to ".-.",
            's' to "...",
            't' to "-",
            'u' to "..-",
            'v' to "...-",
            'w' to ".--",
            'x' to "-..-",
            'y' to "-.--",
            'z' to "--.."
    )

    init {
        root = Node(' ')
        for (i in charMap.entries) {
            add(i.key, i.value)
        }
    }

    private fun add(ch: Char, signal: String) {
        var currentNode: Node? = root
        for (i in signal.indices) {
            when (signal[i]) {
                '.' -> {
                    if (currentNode?.dot == null) {
                        currentNode?.dot = Node()
                    }
                    currentNode = currentNode?.dot
                }
                '-' -> {
                    if (currentNode?.dash == null) {
                        currentNode?.dash = Node()
                    }
                    currentNode = currentNode?.dash
                }
                else -> return
            }
        }
        currentNode?.key = ch
    }

    fun decode(signal: String): List<Char?> {
        var current: MutableList<Node?> = mutableListOf(root)
        for (i in signal.indices) {
            when (signal[i]) {
                '.' -> {
                    current = current.map { it?.dot }.toMutableList()
                }
                '-' -> {
                    current = current.map { it?.dash }.toMutableList()
                }
                '?' -> {
                    val newList = current.map { it?.dot }.toMutableList()
                    newList.addAll(current.map { it?.dash }.toMutableList())
                    current = newList
                }
            }
        }
        return current.mapNotNull { it?.key }
    }
}

class Node(
        var key: Char? = null,
        var dot: Node? = null,
        var dash: Node? = null)