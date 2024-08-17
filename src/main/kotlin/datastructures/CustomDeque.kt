package deque

import androidx.compose.runtime.mutableStateListOf
import datastructures.CustomQueue
import interfaces.Deque
import interfaces.Queue

class CustomDeque<T>: Deque<T> {

    private val queue = mutableStateListOf<T>()
    override fun addFirst(element: T): Boolean {
        queue.add(0,element)
        return(queue.getOrNull(0)== element)
    }

    override fun addLast(element: T)=  queue.add(element)

    override fun removeFirst() = queue.removeFirstOrNull()

    override fun removeLast() = if(isEmpty())null else queue.removeLast()
    override fun peekFirst() = queue.getOrNull(0)
    override fun peekLast() = queue.getOrNull(size()-1)
    override fun peek(index: Int) = queue.getOrNull(index)
    override fun isEmpty() = queue.size == 0
    override fun size() = queue.size

    override fun ascendingIterator() = queue.iterator()

    override fun descendingIterator() = queue.asReversed().iterator()

    override fun contains(element: T) = queue.contains(element)
}

fun <T> customDequeOf(vararg elements: T): Deque<T> {
    val listDeque = CustomDeque<T>()
    elements.forEach {
        listDeque.addFirst(it)
    }
    return listDeque
}

