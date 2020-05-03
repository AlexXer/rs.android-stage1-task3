package subtask4

import kotlin.math.floor
import kotlin.math.pow
import kotlin.math.sqrt

class SquareDecomposer {

    // TODO: Complete the following function
    fun decomposeNumber(number: Int): Array<Int>? {
        return decomposeValue(number * number, number - 1)?.toTypedArray()
    }

    private fun decomposeValue(value: Int, first: Int): ArrayList<Int>? {
        for( i in first downTo 1 ) {
            val square = i * i
            val reminder = value - square
            if(reminder == 0 ) {
                return arrayListOf(i)
            }

            if(reminder < 0 ) {
                return null
            }

            var sqrt = floor( sqrt(reminder.toDouble()) ).toInt()
            if(sqrt >= i) {
                sqrt = i - 1
            }
            val decomposed = decomposeValue(reminder, sqrt)
            if(decomposed != null) {
                decomposed.add(i)
                return decomposed
            }
        }
        return null
    }
}
