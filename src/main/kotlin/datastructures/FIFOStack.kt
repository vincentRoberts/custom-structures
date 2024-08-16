package datastructures

import interfaces.Stack
import java.util.concurrent.CopyOnWriteArrayList

class FIFOStack<T> : Stack<T> {

    private val stack = CopyOnWriteArrayList<T>()
    override fun isEmpty() = size() == 0

    override fun size() = stack.size

    override fun push(element: T) {
        stack.add(element)
    }

    override fun pushAll(items : Iterable<T>) {
        for (item in items) {
            push(item)
        }
    }

    override fun pop(): T? {
        if (isEmpty()) {
            return null
        }
        return stack.removeAt(size() - 1)
    }

    override fun popAll() : List<T> {
        synchronized(stack) {
            val tempStack = arrayListOf<T>()
            for (item in stack) {
                pop()?.let { tempStack.add(it) }
            }
            return tempStack
        }
    }

    override fun peek(): T? = stack.lastOrNull()

    override fun peek(index: Int): T? = stack.getOrNull(index)
}

fun <T> fifoStackOf(vararg elements: T): Stack<T> {
    val listStack = FIFOStack<T>()
    listStack.pushAll(elements.asList())
    return listStack
}