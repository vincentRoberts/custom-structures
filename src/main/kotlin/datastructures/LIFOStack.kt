package datastructures

import interfaces.Stack
import java.util.concurrent.CopyOnWriteArrayList

//**KDoc added with ChatGpt

/**
 * A thread-safe implementation of a Last-In-First-Out (LIFO) stack.
 *
 * This class uses a [CopyOnWriteArrayList] to store elements, ensuring thread safety
 * at the cost of performance during write operations. The stack operates by
 * pushing elements onto the end of the list and popping them from the end, maintaining
 * LIFO order.
 *
 * @param T the type of elements held in this stack
 */
class LIFOStack<T> : Stack<T> {

    private val stack = CopyOnWriteArrayList<T>()

    /**
     * Adds an element to the top of the stack.
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
     * Removes and returns the top element of the stack.
     *
     * @return the top element of the stack, or `null` if the stack is empty
     */
    override fun pop(): T? {
        if (isEmpty()) {
            return null
        }
        return stack.removeAt(size() - 1)
    }

    /**
     * Removes and returns all elements from the stack in LIFO order.
     *
     * @return a list of all elements from the stack, removed in LIFO order
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
     * Returns the top element of the stack without removing it.
     *
     * @return the top element of the stack, or `null` if the stack is empty
     */
    override fun peek(): T? = stack.lastOrNull()

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

    /**
     * Returns a string representation of the stack, with each element on a new line.
     *
     * @return a string representation of the stack
     */
    override fun toString() = buildString {
        stack.forEach { appendLine("$it") }
    }
}

/**
 * Utility function to create a [LIFOStack] initialized with the specified elements.
 *
 * @param T the type of elements held in the stack
 * @param elements the elements to be added to the stack
 * @return a [LIFOStack] containing the specified elements
 */
fun <T> lifoStackOf(vararg elements: T): Stack<T> {
    val listStack = LIFOStack<T>()
    listStack.pushAll(elements.asList())
    return listStack
}
