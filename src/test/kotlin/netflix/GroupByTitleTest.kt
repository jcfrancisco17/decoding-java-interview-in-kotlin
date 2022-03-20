package netflix

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class GroupByTitleTest {

    @Test
    fun `group by title`() {
        val groupByTitle = GroupByTitle(
            listOf("duel", "dule", "speed", "spede", "deul", "cars")
        )

        val actual = groupByTitle.getGroupedTitles()
        val expected = listOf(
            listOf("duel", "dule", "deul"),
            listOf("speed", "spede"),
            listOf("cars")
        )

        assertContentEquals(expected, actual)
    }

    @Test
    fun `query and found a result`() {
        val groupByTitle = GroupByTitle(
            listOf("duel", "dule", "speed", "spede", "deul", "cars")
        )

        val actual = groupByTitle.query("spede")
        val expected = listOf("speed", "spede")

        assertContentEquals(expected, actual)
    }

    @Test
    fun `query and found no result`() {
        val groupByTitle = GroupByTitle(
            listOf("duel", "dule", "speed", "spede", "deul", "cars")
        )

        val actual = groupByTitle.query("abc")
        val expected = emptyList<String>()

        assertContentEquals(expected, actual)
    }
}