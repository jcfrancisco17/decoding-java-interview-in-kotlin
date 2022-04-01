package netflix

class BrowseRatings(val limit: Int = 5) {

    private val ratedTitles: ArrayDeque<RatedTitle> = ArrayDeque()
    private val max: ArrayDeque<RatedTitle> = ArrayDeque()

    fun add(title: RatedTitle): Boolean {
        return if (ratedTitles.size < limit) {
            ratedTitles.addFirst(title)
            if (max.isEmpty() || max.last().rating < title.rating) {
                max.addFirst(title)
            } else {
                max.addFirst(max.first())
            }
            true
        } else {
            false
        }
    }

    fun list(): List<RatedTitle> {
        return ratedTitles.toList()
    }

    fun maxRating(): RatedTitle {
        return max.first()
    }

    fun viewPrevious() : RatedTitle? {
        max.removeFirstOrNull()
        return ratedTitles.removeFirstOrNull()
    }

}
