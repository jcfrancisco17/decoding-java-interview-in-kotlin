package netflix

class RatedTitle(val title: Title, var rating: Double) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RatedTitle) return false

        if (title != other.title) return false

        return true
    }

    override fun hashCode(): Int {
        return title.hashCode()
    }

    override fun toString(): String {
        return "RatedTitle(title=$title, rating=$rating)"
    }
}
