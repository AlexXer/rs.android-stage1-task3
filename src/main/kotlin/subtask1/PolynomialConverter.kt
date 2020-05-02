package subtask1

import kotlin.math.abs

class PolynomialConverter {

    // TODO: Complete the following function
    fun convertToStringFrom(numbers: Array<Int>): String? {
        val res = arrayListOf<String>()
        if (numbers.isNotEmpty()) {
            for (index in numbers.indices) {
                res.add(when{
                    numbers[index] == 0->""
                    numbers[index] > 0 ->" + "+convertToPolynomialForm(numbers[index],index,numbers.size)
                    else->" - "+convertToPolynomialForm(numbers[index],index,numbers.size)
                })
            }
            if (res[0].contains(" + ")) res[0] = res[0].replace(" + ","")
        }
        return if (numbers.isEmpty()) null else res.joinToString ("")
    }

    private fun convertToPolynomialForm(i: Int, index: Int, length: Int): String =
        when (length - index - 1) {
            0 -> "${if (abs(i) != 1) abs(i) else ""}"
            1 -> "${if (abs(i) != 1) abs(i) else ""}x"
            else -> "${if (abs(i) != 1) abs(i) else ""}x^${length - index - 1}"
        }
}

