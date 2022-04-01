package netflix

import java.time.LocalDateTime

class Title(val title: String, var dateTime: LocalDateTime = LocalDateTime.now()) {

    fun rewatch(): Title {
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