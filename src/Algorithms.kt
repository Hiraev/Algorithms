import java.math.BigInteger

fun getBigInt(v: Int) = BigInteger.valueOf(v.toLong())

fun findTheLargestSubArray(input: List<Int>): List<Int> {
    var acc = BigInteger.valueOf(0)
    var leftPointer = 0
    var rightPointer = 0
    var checkVal = BigInteger.ZERO
    var checkMode = false
    var maxValue = when (input.isEmpty()) {
        true -> 0
        else -> input[0]
    }

    val arrays = mutableListOf<Triple<BigInteger, Int, Int>>() // (sum, startIndex, endIndex)
    for (i in 0 until input.size) {
        val it = input[i]
        if (it > maxValue) maxValue = it
        if (checkMode) {
            checkVal += getBigInt(it)
            if (checkVal >= BigInteger.ZERO) {
                checkMode = false
                acc += checkVal
                checkVal = BigInteger.ZERO
                rightPointer = i + 1
            }
        } else if (it < 0) {
            if (getBigInt(-it) > acc) {
                if (leftPointer != rightPointer) arrays.add(Triple(acc, leftPointer, i))
                acc = BigInteger.ZERO
                leftPointer = i + 1
                rightPointer = leftPointer
            } else {
                checkMode = true
                checkVal += getBigInt(it)
            }
        } else {
            acc += getBigInt(it)
            rightPointer = i + 1
        }
    }
    arrays.add(Triple(acc, leftPointer, rightPointer))
    val max = arrays.maxBy { it.first }!!
    return when {
        maxValue < 0 -> listOf(maxValue)
        else -> input.subList(max.second, max.third) //от second до third
    }
}
