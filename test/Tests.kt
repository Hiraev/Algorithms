import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

class Tests {

    val inList1 = listOf(1, 4, 24, 54, -100, 39, 84, 92, 12)
    val outList1 = listOf(39, 84, 92, 12)
    val inList2 = listOf(1, 4, 24, 54, 100, 39, 84, 92, 12)
    val outList2 = listOf(1, 4, 24, 54, 100, 39, 84, 92, 12)
    val inList3 = listOf(9, -12, 23, 4, 0, -9)
    val outList3 = listOf(23, 4, 0)
    val inList4 = listOf(-9, -12, 23, 4, 0, -9, 34, 43, 0, 92, -92, 92)
    val outList4 = listOf(23, 4, 0, -9, 34, 43, 0, 92, -92, 92)
    val inList5 = listOf(-5, 5, -4, 4)
    val outList5 = listOf(5, -4, 4)
    val inList6 = listOf<Int>()
    val outList6 = listOf<Int>()
    val inList7 = listOf(-1, -2, -3, 7, -4, -5, -6)
    val outList7 = listOf(7)
    val inList8 = listOf(1, 2, 3, -79, 4, 5, 6, -80, 34, 4, 12, -99, 3, 1, 2)
    val outList8 = listOf(34, 4, 12)
    val inList9 = listOf(8, -90, 76, 98, 56, 1, 2, -3, 2, 43, 91, -234, 23, 134, 22, 33, -123, 90)
    val outList9 = listOf(76, 98, 56, 1, 2, -3, 2, 43, 91)

    var inList10 = listOf(-1,-2,-3)
    var outList10 = listOf(-1)

    @Test
    fun findTheLargestSubArray() {
        assertEquals(findTheLargestSubArray(inList1), outList1)
        assertEquals(findTheLargestSubArray(inList2), outList2)
        assertEquals(findTheLargestSubArray(inList3), outList3)
        assertEquals(findTheLargestSubArray(inList4), outList4)
        assertEquals(findTheLargestSubArray(inList5), outList5)
        assertEquals(findTheLargestSubArray(inList6), outList6)
        assertEquals(findTheLargestSubArray(inList7), outList7)
        assertEquals(findTheLargestSubArray(inList8), outList8)
        assertEquals(findTheLargestSubArray(inList9), outList9)
        assertEquals(findTheLargestSubArray(inList10), outList10)
    }


    @Test
    fun big() {
        var list = mutableListOf<Int>()
        val r = Random()
        for (i in 0..100_000_000) {
            list.add((Math.pow(-1.0, r.nextInt().toDouble() % 10) * r.nextInt() % 100).toInt())
        }

        print(findTheLargestSubArray(list).size)
    }
}
