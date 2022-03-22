package netflix

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PopularityAnalysisTest {

    @Test
    fun `identify increasing`() {
        assertTrue(PopularityAnalysis.analyze(listOf(1, 2, 2, 3)))
    }

    @Test
    fun `identify decreasing`() {
        assertTrue(PopularityAnalysis.analyze(listOf(8, 8, 7, 6, 5, 4, 4, 1)))
    }

    @Test
    fun `identify fluctuating`() {
        assertFalse(PopularityAnalysis.analyze(listOf(4, 5, 6, 3, 4)))
    }
}