import java.math.BigInteger

fun getBigInt(v: Int) = BigInteger.valueOf(v.toLong())

fun findTheLargestSubArray(input: List<Int>): List<Int> {
    var sum = BigInteger.ZERO
    var currentMax = Triple(BigInteger.ZERO, 0, 0)
    var pointer = 0
    for ((index, elem) in input.withIndex()) {
        sum += getBigInt(elem)
        if (sum > BigInteger.ZERO) {
            if (currentMax.first < sum) {
                currentMax = Triple(sum, pointer, index + 1)
            }
        } else {
            sum = BigInteger.ZERO
            pointer = index + 1
        }
    }
    return input.subList(currentMax.second, currentMax.third)
}
