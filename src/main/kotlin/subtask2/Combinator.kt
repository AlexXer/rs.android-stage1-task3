package subtask2

import java.math.BigInteger

class Combinator {

    // TODO: Complete the following function
    fun checkChooseFromArray(array: Array<Int>): Int? {
        val m = array[0]
        val n = array[1]
        var res = 0
        while (countCombinations(res,n)!=BigInteger.valueOf(m.toLong()) && res<n){
            res++
        }
        return if (res>=n) null else res
    }


    private fun fact(i:Int):BigInteger = if (i>=1) BigInteger.valueOf(i.toLong())*fact(i-1) else BigInteger.ONE

    private fun countCombinations(m:Int, n:Int):BigInteger=fact(n)/(fact(m)*fact(n-m))
}
