package netflix

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class TopMoviesTest {

    @Test
    fun `find top movies in order`() {
        val topMovies = TopMovies()
        val actual = topMovies.sort(
            listOf(11, 41, 51),
            listOf(21, 23, 42),
            listOf(25, 56, 66, 72)
        )

        assertContentEquals(listOf(11, 21, 23, 25, 41, 42, 51, 56, 66, 72), actual)
    }

}