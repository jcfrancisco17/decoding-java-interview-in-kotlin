package netflix

class MedianAge {
    val smallList = ArrayDeque<Int>()
    val largeList = ArrayDeque<Int>()

    fun insert(age: Int) {

        // The solution in educative used max (parent > child) and min (parent < child) heap
        // data structure for smallList and largeList respectively. They PriorityQueue for this.
        // Since Kotlin stdlib doesn't have a PriorityQueue (afaik), I used ArrayDeque instead and used
        // the natural sorting of the numbers and used ArrayDeque's removeFirst() and removeLast() functions instead
        // of PriorityQueue.poll()

        if (smallList.isEmpty() || smallList.first() >= age) {
            smallList.add(age)
            smallList.sort()
        } else {
            largeList.add(age)
            largeList.sort()
        }

        // Since we chose to insert the first entry in the smallList (see above),
        // if we have odd number of ages, the smallList should be bigger by one entry only
        // if we have even number of ages, both lists should be equal in number.
        if (smallList.size > largeList.size + 1) {
            largeList.add(smallList.removeLast())
            largeList.sort()
        } else if (smallList.size < largeList.size) {
            smallList.add(largeList.removeFirst())
            smallList.sort()
        }
    }

    fun findMedian(): Double {
        return if (smallList.size > largeList.size) {
            smallList.last().toDouble()
        } else {
            (smallList.last() / 2.0) + (largeList.first() / 2.0)
        }
    }

}
