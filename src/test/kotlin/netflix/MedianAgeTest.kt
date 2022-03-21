package netflix

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class MedianAgeTest {

    @Test
    fun `insert odd number of ages`() {
        val medianAge = MedianAge()
        medianAge.insert(5)
        medianAge.insert(2)
        medianAge.insert(10)
        medianAge.insert(7)
        medianAge.insert(3)

        println(medianAge.smallList)
        println(medianAge.largeList)

        assertContentEquals(listOf(2, 3, 5), medianAge.smallList.toList())
        assertContentEquals(listOf(7, 10), medianAge.largeList.toList())
    }

    @Test
    fun `insert even number of ages`() {
        val medianAge = MedianAge()
        medianAge.insert(5)
        medianAge.insert(2)
        medianAge.insert(10)
        medianAge.insert(7)
        medianAge.insert(3)
        medianAge.insert(20)

        assertContentEquals(listOf(2, 3, 5), medianAge.smallList.toList())
        assertContentEquals(listOf(7, 10, 20), medianAge.largeList.toList())
    }

    @Test
    fun `find median for odd number of ages`() {
        val medianAge = MedianAge()
        medianAge.insert(5)
        medianAge.insert(2)
        medianAge.insert(10)
        medianAge.insert(7)
        medianAge.insert(3)

        val actual = medianAge.findMedian()

        assertEquals(5.0, actual)
    }

    @Test
    fun `find median for even number of ages`() {
        val medianAge = MedianAge()
        medianAge.insert(5)
        medianAge.insert(2)
        medianAge.insert(10)
        medianAge.insert(7)
        medianAge.insert(3)
        medianAge.insert(20)

        val actual = medianAge.findMedian()

        assertEquals(6.0, actual)
    }

    @Test
    fun `find median given the same numbers`() {
        val medianAge = MedianAge()
        medianAge.insert(3)
        medianAge.insert(3)
        medianAge.insert(3)
        medianAge.insert(3)

        assertEquals(3.0, medianAge.findMedian())

        medianAge.insert(3)
        assertEquals(3.0, medianAge.findMedian())
    }
}