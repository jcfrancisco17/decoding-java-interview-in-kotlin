package netflix

/**
 * Given the words:
 * duel, dule, deul, speed, spede, cards
 *
 * When grouped:
 *
 * Then the following groups are expected:
 * - duel, dule, deul
 * - speed, spede
 * - cars
 *
 */
class GroupByTitle(private val titles: List<String>) {
    private val groupedTitles: MutableMap<String, MutableList<String>> = mutableMapOf()

    init {
        group()
    }

    private fun group() {
        titles.forEach { title ->
            val key = computeKey(title)
            groupedTitles.computeIfAbsent(key) { mutableListOf() }.add(title)
        }
    }

    fun getGroupedTitles(): List<List<String>> {
        return groupedTitles.values.map { it.toList() }
    }

    fun query(searchWord: String): List<String> {
        return groupedTitles[computeKey(searchWord)]?.toList() ?: emptyList()
    }

    /**
     * The key is computed by counting the occurrences of each character.
     * The count of each character will then be converted to a string using #
     * as the separator. The leftmost number is a while the rightmost number is z.
     *
     * Example:
     * - duel = 0#0#0#1#1#0#0#0#0#0#0#1#0#0#0#0#0#0#0#0#1#0#0#0#0#0
     * - dule = 0#0#0#1#1#0#0#0#0#0#0#1#0#0#0#0#0#0#0#0#1#0#0#0#0#0
     * - aaaaaaaaaaabbbbbbbbbb = 11#10#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0
     *
     * @return The computed key derived from the title
     */
    private fun computeKey(title: String): String {
        val key = IntArray(26)
        key.fill(0)

        title.toCharArray().forEach { character ->
            val index = character - 'a'
            key[index]++
        }

        return key.joinToString(separator = "#")
    }
}