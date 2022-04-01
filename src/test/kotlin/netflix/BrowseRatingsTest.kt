package netflix

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BrowseRatingsTest {

    @Test
    fun `record ratings`() {
        val ratings = BrowseRatings(5)
        val title1 = RatedTitle(Title("title 1"), 5.0)
        val title2 = RatedTitle(Title("title 2"), 4.0)

        ratings.add(title1)
        ratings.add(title2)

        println(ratings.list())
        assertContentEquals(listOf(title2, title1), ratings.list())
    }

    @Test
    fun `limit number of titles`() {
        val ratings = BrowseRatings(3)
        val title1 = RatedTitle(Title("title 1"), 5.0)
        val title2 = RatedTitle(Title("title 2"), 4.0)
        val title3 = RatedTitle(Title("title 3"), 6.0)
        val title4 = RatedTitle(Title("title 4"), 2.0)

        assertTrue(ratings.add(title1))
        assertTrue(ratings.add(title3))
        assertTrue(ratings.add(title2))
        assertFalse(ratings.add(title4))

        assertContentEquals(listOf(title2, title3, title1), ratings.list())
    }

    @Test
    fun `track max rating`() {
        val ratings = BrowseRatings()
        val title1 = RatedTitle(Title("title 1"), 5.0)
        val title2 = RatedTitle(Title("title 2"), 4.0)
        val title3 = RatedTitle(Title("title 3"), 6.0)
        val title4 = RatedTitle(Title("title 4"), 2.0)

        ratings.add(title1)
        assertEquals(title1, ratings.maxRating()) //title 1 as first entry is max by default

        ratings.add(title2)
        assertEquals(title1, ratings.maxRating()) //title 1 rating is greater than title 2

        ratings.add(title3)
        assertEquals(title3, ratings.maxRating()) //title 3 replace title 1

        ratings.add(title4)
        assertEquals(title3, ratings.maxRating()) //title 3 rating is greater than title 4
    }

    @Test
    fun `view previous ` () {
        val ratings = BrowseRatings(7)
        val title1 = RatedTitle(Title("title 1"), 5.0)
        val title2 = RatedTitle(Title("title 2"), 0.0)
        val title3 = RatedTitle(Title("title 3"), 2.0)
        val title4 = RatedTitle(Title("title 4"), 4.0)
        val title5 = RatedTitle(Title("title 5"), 6.0)
        val title6 = RatedTitle(Title("title 6"), 3.0)
        val title7 = RatedTitle(Title("title 7"), 10.0)

        ratings.add(title1)
        ratings.add(title2)
        ratings.add(title3)
        ratings.add(title4)
        ratings.add(title5)
        ratings.add(title6)
        ratings.add(title7)

        assertEquals(title7, ratings.maxRating())
        assertContentEquals(listOf(title7, title6, title5, title4, title3, title2, title1), ratings.list())

        ratings.viewPrevious()

        assertEquals(title5, ratings.maxRating())
        assertContentEquals(listOf(title6, title5, title4, title3, title2, title1), ratings.list())
    }

}