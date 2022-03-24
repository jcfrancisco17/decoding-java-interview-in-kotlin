package netflix

import org.junit.jupiter.api.Test
import java.time.LocalDateTime // AFAIK, there's no equivalent in Kotlin stdlib so had to use Java's
import kotlin.test.assertContentEquals

class MostRecentlyWatchedTitlesTest {

    @Test
    fun `add recently watched titles`() {
        val recentlyWatched = MostRecentlyWatchedTitles(5)

        val title1 = Title("title 1", LocalDateTime.now().plusHours(1))
        val title2 = Title("title 2", LocalDateTime.now().plusHours(2))

        recentlyWatched.add(title1)
        recentlyWatched.add(title2)

        assertTitlesAreSortedByMostRecentlyWatched(listOf(title2, title1), recentlyWatched.getTitles())
    }

    @Test
    fun `limit recently watched titles`() {
        val recentlyWatched = MostRecentlyWatchedTitles(5)

        val title1 = Title("title 1", LocalDateTime.now().plusHours(1))
        val title2 = Title("title 2", LocalDateTime.now().plusHours(2))
        val title3 = Title("title 3", LocalDateTime.now().plusHours(3))
        val title4 = Title("title 4", LocalDateTime.now().plusHours(4))
        val title5 = Title("title 5", LocalDateTime.now().plusHours(5))
        val title6 = Title("title 6", LocalDateTime.now().plusHours(6))

        recentlyWatched.add(title1)
        recentlyWatched.add(title2)
        recentlyWatched.add(title3)
        recentlyWatched.add(title4)
        recentlyWatched.add(title5)
        recentlyWatched.add(title6)

        assertTitlesAreSortedByMostRecentlyWatched(
            listOf(title6, title5, title4, title3, title2),
            recentlyWatched.getTitles()
        )
    }

    @Test
    fun `sort titles by date watched`() {
        val recentlyWatched = MostRecentlyWatchedTitles(5)

        val title1 = Title("title 1", LocalDateTime.now())
        val title2 = Title("title 2", LocalDateTime.now().plusHours(2))
        val title3 = Title("title 3", LocalDateTime.now().plusHours(1))

        recentlyWatched.add(title1)
        recentlyWatched.add(title2)
        recentlyWatched.add(title3)

        assertTitlesAreSortedByMostRecentlyWatched(listOf(title2, title3, title1), recentlyWatched.getTitles())
    }

    @Test
    fun `re-watched title should be listed first`() {
        val recentlyWatched = MostRecentlyWatchedTitles(5)

        val title1 = Title("title 1", LocalDateTime.now().minusHours(3))
        val title2 = Title("title 2", LocalDateTime.now().minusHours(2))
        val title3 = Title("title 3", LocalDateTime.now().minusHours(1))

        recentlyWatched.add(title1)
        recentlyWatched.add(title2)
        recentlyWatched.add(title3)
        recentlyWatched.add(title1.rewatch()) // this should be the first element after a rewatch

        assertTitlesAreSortedByMostRecentlyWatched(listOf(title1, title3, title2), recentlyWatched.getTitles())
    }

    /**
     * Functionality wise, I don't need to make this private function, but I think
     * having a descriptive name of what assertion to expect would be nice.
     */
    private fun assertTitlesAreSortedByMostRecentlyWatched(expected: Collection<Title>, actual: Collection<Title>) {
        assertContentEquals(expected, actual)
    }
}
