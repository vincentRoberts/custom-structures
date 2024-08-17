
package deque

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CustomDequeTest {

    private lateinit var deque: CustomDeque<Int>

    @BeforeEach
    fun setUp() {
        deque = CustomDeque()
    }

    @Test
    fun `test addFirst adds elements to the front`() {

        assertTrue(deque.addFirst(1))
        assertTrue(deque.addFirst(2))
        assertTrue(deque.addFirst(3))


        assertEquals(3, deque.peekFirst())
        assertEquals(1, deque.peekLast())
        assertEquals(3, deque.size())
    }

    @Test
    fun `test addLast adds elements to the end`() {

        assertTrue(deque.addLast(1))
        assertTrue(deque.addLast(2))
        assertTrue(deque.addLast(3))


        assertEquals(1, deque.peekFirst())
        assertEquals(3, deque.peekLast())
        assertEquals(3, deque.size())
    }

    @Test
    fun `test removeFirst removes the front element`() {

        deque.addLast(1)
        deque.addLast(2)
        deque.addLast(3)


        assertEquals(1, deque.removeFirst())
        assertEquals(2, deque.removeFirst())
        assertEquals(3, deque.removeFirst())
        assertNull(deque.removeFirst())  // Empty deque, should return null
    }

    @Test
    fun `test removeLast removes the end element`() {

        deque.addLast(1)
        deque.addLast(2)
        deque.addLast(3)


        assertEquals(3, deque.removeLast())
        assertEquals(2, deque.removeLast())
        assertEquals(1, deque.removeLast())
        assertNull(deque.removeLast())  // Empty deque, should return null
    }

    @Test
    fun `test peekFirst returns the front element without removing it`() {

        deque.addLast(1)
        deque.addLast(2)
        deque.addLast(3)


        assertEquals(1, deque.peekFirst())
        deque.removeFirst()
        assertEquals(2, deque.peekFirst())
        deque.removeFirst()
        assertEquals(3, deque.peekFirst())
        deque.removeFirst()
        assertNull(deque.peekFirst())  // Empty deque, should return null
    }

    @Test
    fun `test peekLast returns the end element without removing it`() {

        deque.addLast(1)
        deque.addLast(2)
        deque.addLast(3)


        assertEquals(3, deque.peekLast())
        deque.removeLast()
        assertEquals(2, deque.peekLast())
        deque.removeLast()
        assertEquals(1, deque.peekLast())
        deque.removeLast()
        assertNull(deque.peekLast())  // Empty deque, should return null
    }

    @Test
    fun `test peek by index returns correct element or null`() {

        deque.addLast(1)
        deque.addLast(2)
        deque.addLast(3)


        assertEquals(1, deque.peek(0))
        assertEquals(2, deque.peek(1))
        assertEquals(3, deque.peek(2))
        assertNull(deque.peek(3))  // Index out of bounds
    }

    @Test
    fun `test contains checks if element is in the deque`() {

        deque.addLast(1)
        deque.addLast(2)
        deque.addLast(3)


        assertTrue(deque.contains(1))
        assertTrue(deque.contains(2))
        assertTrue(deque.contains(3))
        assertFalse(deque.contains(4))
    }

    @Test
    fun `test ascendingIterator iterates in the correct order`() {

        deque.addLast(1)
        deque.addLast(2)
        deque.addLast(3)


        val iterator = deque.ascendingIterator()


        assertTrue(iterator.hasNext())
        assertEquals(1, iterator.next())
        assertTrue(iterator.hasNext())
        assertEquals(2, iterator.next())
        assertTrue(iterator.hasNext())
        assertEquals(3, iterator.next())
        assertFalse(iterator.hasNext())
    }

    @Test
    fun `test descendingIterator iterates in reverse order`() {

        deque.addLast(1)
        deque.addLast(2)
        deque.addLast(3)


        val iterator = deque.descendingIterator()


        assertTrue(iterator.hasNext())
        assertEquals(3, iterator.next())
        assertTrue(iterator.hasNext())
        assertEquals(2, iterator.next())
        assertTrue(iterator.hasNext())
        assertEquals(1, iterator.next())
        assertFalse(iterator.hasNext())
    }
}
