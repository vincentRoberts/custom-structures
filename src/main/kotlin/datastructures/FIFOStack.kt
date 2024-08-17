package datastructures

import interfaces.Stack
import java.util.concurrent.CopyOnWriteArrayList

//KDoc added with ChatGpt

/**
 * A thread-safe implementation of a First-In-First-Out (FIFO) stack.
 *
 * This class uses a [CopyOnWriteArrayList] to store elements, ensuring thread safety
 * at the cost of performance during write operations. The stack operates by
 * pushing elements onto the end of the list and popping them from the beginning,
 * maintaining FIFO order.
 *
 * @param T the type of elements held in this stack
 */
class FIFOStack<T> : Stack<T> {

    private val stack = CopyOnWriteArrayList<T>()

    /**
     * Adds an element to the end of the stack.
     *
     * @param element the element to be added
     */
    override fun push(element: T) {
        stack.add(element)
    }

    /**
     * Adds all elements from the given iterable to the stack.
     *
     * @param items the iterable containing elements to be added
     */
    override fun pushAll(items: Iterable<T>) {
        for (item in items) {
            push(item)
        }
    }

    /**
     * Removes and returns the first element of the stack, following FIFO order.
     *
     * @return the first element of the stack, or `null` if the stack is empty
     */
    override fun pop(): T? {
        if (isEmpty()) {
            return null
        }
        return stack.removeAt(0)
    }

    /**
     * Removes and returns all elements from the stack in FIFO order.
     *
     * @return a list of all elements from the stack, removed in FIFO order
     */
    override fun popAll(): List<T> {
        synchronized(stack) {
            val tempStack = arrayListOf<T>()
            while (!isEmpty()) {
                pop()?.let { tempStack.add(it) }
            }
            return tempStack
        }
    }

    /**
     * Returns the first element of the stack without removing it.
     *
     * @return the first element of the stack, or `null` if the stack is empty
     */
    override fun peek(): T? = stack.firstOrNull()

    /**
     * Returns the element at the specified index in the stack without removing it.
     *
     * @param index the index of the element to return
     * @return the element at the specified index, or `null` if the index is out of bounds
     */
    override fun peek(index: Int): T? = stack.getOrNull(index)

    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    override fun size() = stack.size

    /**
     * Checks if the stack is empty.
     *
     * @return `true` if the stack contains no elements, `false` otherwise
     */
    override fun isEmpty() = size() == 0

    override fun toString(): String = stack.joinToString(separator = "\n")
}

/**
 * Utility function to create a [FIFOStack] initialized with the specified elements.
 *
 * @param T the type of elements held in the stack
 * @param elements the elements to be added to the stack
 * @return a [FIFOStack] containing the specified elements
 */
fun <T> fifoStackOf(vararg elements: T): Stack<T> {
    val listStack = FIFOStack<T>()
    listStack.pushAll(elements.asList())
    return listStack
}
