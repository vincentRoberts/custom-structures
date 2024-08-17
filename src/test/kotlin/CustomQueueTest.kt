import datastructures.CustomQueue
import datastructures.customQueueOf
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CustomQueueTest {
@Test
fun `enqueue should add elements to the queue`() {

    val queue = customQueueOf<String>()
    val element = "Test"


    queue.enqueue(element)


    assertEquals(1, queue.size())
}

@Test
fun `enqueue set up by constructor should add elements to the queue`() {

    val queue = CustomQueue<String>()
    val element = "Test"


    queue.enqueue(element)


    assertEquals(1, queue.size())
}

@Test
fun `given a queue instantiated with items, when enqueue is called, then it adds the element at the end`() {

    val queue = customQueueOf(1, 2, 3, 4, 5)
    val element = 42


    val result = queue.enqueue(element)


    assertTrue(result)
    assertEquals(1, queue.peek(0))
    assertEquals(2, queue.peek(1))
    assertEquals(3, queue.peek(2))
    assertEquals(4, queue.peek(3))
    assertEquals(5, queue.peek(4))
    assertEquals(element, queue.peek(5))
    }

    @Test
    fun `dequeue should remove and return the first element from the queue`() {

        val queue = customQueueOf<String>()
        val element1 = "Element 1"
        val element2 = "Element 2"
        queue.enqueue(element1)
        queue.enqueue(element2)


        val dequeuedElement = queue.dequeue()


        assertEquals(element1, dequeuedElement)
        assertEquals(1, queue.size())
    }

    @Test
    fun `dequeue on an empty queue should return null`() {

        val queue = customQueueOf<String>()
        val dequeuedElement = queue.dequeue()


        assertNull(dequeuedElement)
    }

    @Test
    fun `peek should return the first element from the queue without removing it`() {
        // Arrange
        val queue = customQueueOf<String>()
        val element = "Test"
        queue.enqueue(element)


        val peekedElement = queue.peek()


        assertEquals(element, peekedElement)
        assertEquals(1, queue.size())
    }

    @Test
    fun `peek on an empty queue should return null`() {

        val queue = customQueueOf<String>()
        val peekedElement = queue.peek()


        assertNull(peekedElement)
    }

    @Test
    fun `isEmpty should return true if the queue is empty`() {

        val queue = customQueueOf<String>()
        val empty = queue.isEmpty()


        assertTrue(empty)
    }

    @Test
    fun `size should return the number of elements in the queue`() {
        val queue = customQueueOf<String>()
        queue.enqueue("Element 1")
        queue.enqueue("Element 2")
        queue.enqueue("Element 3")

        val size = queue.size()

        assertEquals(3, size)
    }

}