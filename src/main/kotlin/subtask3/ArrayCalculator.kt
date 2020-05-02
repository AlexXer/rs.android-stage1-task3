package subtask3

class ArrayCalculator {

    // TODO: Complete the following function
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val items = ArrayList(itemsFromArray.toList().filterIsInstance<Int>())
        var maxProd = 1
        var count = numberOfItems
        if (items.isNotEmpty()) {
            if (numberOfItems >= items.size) {
                for (el in items) {
                    maxProd *= el
                }
            } else {
                var (negative, positive) = items.partition { it < 0 }
                negative = negative.sorted()
                positive = positive.sortedDescending()
                if (negative.size / 2 == 0) {
                    for (index in 0 until numberOfItems) {
                        maxProd *= positive[index]
                    }
                } else {
                    var positiveIndex = 0
                    var negativeIndex = 0
                    while (count != 0) {
                        if (count % 2 == 0) {
                            if (negativeIndex != negative.lastIndex) {
                                if (positive[positiveIndex] * positive[positiveIndex + 1] > negative[negativeIndex] * negative[negativeIndex + 1]) {
                                    maxProd *= positive[positiveIndex] * positive[positiveIndex + 1]
                                    positiveIndex += 2
                                    count -= 2

                                } else {
                                    maxProd *= negative[negativeIndex] * negative[negativeIndex + 1]
                                    negativeIndex += 2
                                    count -= 2
                                }
                            } else {
                                maxProd *= positive[positiveIndex] * positive[positiveIndex + 1]
                                positiveIndex += 2
                                count -= 2
                            }

                        } else {
                            maxProd *= positive[positiveIndex]
                            positiveIndex++
                            count -= 1

                        }

                    }
                }
            }
        } else {
            maxProd = 0
        }
        return maxProd
    }
}
