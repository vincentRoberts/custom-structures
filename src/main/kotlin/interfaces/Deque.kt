package interfaces

interface Deque<T> : CustomDataStructure<T> {

    fun addFirst(element: T): Boolean
    fun addLast(element: T): Boolean
    fun removeFirst(): T?
    fun removeLast(): T?
    fun peekFirst(): T?
    fun peekLast(): T?
    fun peek(index: Int): T?
    fun contains(element: T): Boolean
    fun ascendingIterator() : Iterator<T>
    fun descendingIterator(): Iterator<T>

}