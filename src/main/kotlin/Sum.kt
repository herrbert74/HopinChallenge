class Sum() {
    fun getSumOfIntegersDivisibleByThreeOrFive(n: Int): Long {
        require(n > 0 && n <= Int.MAX_VALUE)
        var result = 0L
        for (i in 1..n) {
            if (listOf(THREE, FIVE).any { i.rem(it) == 0 }) {
                result += i
            }
        }
        return result
    }
    companion object {
        const val THREE = 3
        const val FIVE= 5
    }
}
