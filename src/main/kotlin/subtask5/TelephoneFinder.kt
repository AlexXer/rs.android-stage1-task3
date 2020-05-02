package subtask5

class TelephoneFinder {

    // TODO: Complete the following function
    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        val isCorrect = number.matches(Regex(REGEX_PHONENUMBER))
        val neighbourNumbers: ArrayList<String> = arrayListOf()
        var neighbours: Array<Char>
        if (isCorrect) {
            for (digitIndex in number.indices) {
                neighbours = findNeighbour(number[digitIndex])
                for (n in neighbours) {
                    neighbourNumbers.add(number.substring(0, digitIndex) + n + number.substring(digitIndex + 1))
                }
            }
        }
        return if (neighbourNumbers.size == 0 || !isCorrect) null else neighbourNumbers.toTypedArray()
    }


    private fun findNeighbour(ch: Char): Array<Char> =
        when (ch) {
            '1' -> arrayOf('2', '4')
            '2' -> arrayOf('1', '3', '5')
            '3' -> arrayOf('2', '6')
            '4' -> arrayOf('1', '5', '7')
            '5' -> arrayOf('2', '4', '6', '8')
            '6' -> arrayOf('3', '5', '9')
            '7' -> arrayOf('4', '8')
            '8' -> arrayOf('5', '7', '9', '0')
            '9' -> arrayOf('6', '8')
            else -> arrayOf('8')
        }

    companion object {
        const val REGEX_PHONENUMBER = "\\d{0,10}"
    }
}
