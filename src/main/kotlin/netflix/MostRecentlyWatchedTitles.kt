package netflix

import java.time.LocalDateTime

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


class Title(val title: String, var dateTime: LocalDateTime = LocalDateTime.now()) {


    fun rewatch() : Title {
        return Title(this.title, LocalDateTime.now())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Title) return false

        if (title != other.title) return false

        return true
    }

    override fun hashCode(): Int {
        return title.hashCode()
    }

    override fun toString(): String {
        return "Title(title='$title')"
    }
}