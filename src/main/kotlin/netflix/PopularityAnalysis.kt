package netflix

object PopularityAnalysis {

    /**
     *
     * ```
     * Given:
     *  1, 2, 2, 3 - a list of scores that increase in trend
     * Then:
     *  Returns `true`
     *
     * Given:
     *  8, 8, 7, 6, 5, 4, 4, 1 - a list of scores that decrease in trend
     * Then:
     *  Returns `true`
     *
     * Given:
     *  4, 5, 6, 3, 4 - a list of scores that both increased and decreased
     * Then:
     *  Returns `false`
     * ```
     *
     *  @return `true` iff the scores only trended in a single direction, either increase or decrease.
     *          `false` if the scores both increased and decreased.
     */
    fun analyze(scores: List<Int>): Boolean {

        /*
        Educative's approach was to start these variables at true. Personally, I lean towards
        starting them at false since at the start of the program, you don't know what the trend
        is yet.
         */
        var increasing = false
        var decreasing = false

        for (index in 0 until scores.size - 1) {
            if (scores[index + 1] > scores[index]) {
                increasing = true
            }
            if (scores[index + 1] < scores[index]) {
                decreasing = true
            }
        }

        /*
        If the scores increased and decreased in the same list, we must return false
         */
        return increasing.xor(decreasing)

    }

}
