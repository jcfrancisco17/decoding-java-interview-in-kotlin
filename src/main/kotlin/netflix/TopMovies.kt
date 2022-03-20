package netflix

/**
 * Given a list of movie rankings from different countries,
 * combine the lists to make one sorted list
 */
class TopMovies {
    fun sort(vararg lists: List<Int>): Set<Int> {
        return lists.flatMap { it }.toSortedSet()
    }
}
