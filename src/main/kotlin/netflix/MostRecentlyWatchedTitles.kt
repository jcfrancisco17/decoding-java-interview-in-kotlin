package netflix

class MostRecentlyWatchedTitles(val limit: Int = 3) {

    private val titles = ArrayDeque<Title>()

    fun add(title: Title) {
        if (titles.contains(title)) {
            titles.remove(title)
        }
        titles.add(title)
        titles.sortByDescending { it.dateTime }
        if (titles.size > limit) {
            titles.removeLast()
        }
    }

    fun getTitles(): Collection<Title> {
        return titles.toList()
    }

}


