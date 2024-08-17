import datastructures.FIFOStack
import datastructures.fifoStackOf
import interfaces.Stack
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class FIFOStackTest {

    @Nested
    inner class PushTests {

        @Test
        fun `push should add elements to the stack`() {

            val stack = fifoStackOf<Int>()


            stack.push(1)
            stack.push(2)
            stack.push(3)


            assertEquals(3, stack.size())
            assertFalse(stack.isEmpty())
        }

        @Test
        fun `stack instantiated with items, when push is called, then it adds the element at the end`() {

            val stack = fifoStackOf(1, 2, 3, 4, 5)
            val element = 42


            stack.push(element)


            assertEquals(1, stack.peek(0))
            assertEquals(2, stack.peek(1))
            assertEquals(3, stack.peek(2))
            assertEquals(4, stack.peek(3))
            assertEquals(5, stack.peek(4))
            assertEquals(element, stack.peek(5))
        }

        @Test
        fun `stack initialized by constructor push should add elements to the stack`() {

            val stack = FIFOStack<Int>()


            stack.push(1)
            stack.push(2)
            stack.push(3)


            assertEquals(3, stack.size())
            assertFalse(stack.isEmpty())
        }

        @Test
        fun `pushAll for lists should add all elements to the stack`() {

            val stack = fifoStackOf<String>()
            val items = listOf("Cat", "Dog", "Mouse", "Horse", "Giraffe")


            stack.pushAll(items)


            assertEquals(5, stack.size())
            assertFalse(stack.isEmpty())
        }

        @Test
        fun `pushAll for sets should add all elements to the stack`() {

            val stack = fifoStackOf<String>()
            val items = setOf("Cat", "Dog", "Mouse", "Horse", "Giraffe")


            stack.pushAll(items)


            assertEquals(5, stack.size())
            assertFalse(stack.isEmpty())
        }
    }

    @Nested
    inner class PopTests {

        @Test
        fun `pop should remove and return the first element from the stack`() {

            val stack = fifoStackOf<Int>()
            stack.push(1)
            stack.push(2)


            val poppedElement = stack.pop()


            assertEquals(1, poppedElement)
            assertEquals(1, stack.size())
        }

        @Test
        fun `pop on an empty stack should return null`() {

            val stack = fifoStackOf<Int>()


            val poppedElement = stack.pop()


            assertNull(poppedElement)
            assertTrue(stack.isEmpty())
        }

        @Test
        fun `popAll should remove and return all elements from the stack in FIFO order`() {

            val stack: Stack<Int> = FIFOStack()
            stack.push(1)
            stack.push(2)
            stack.push(3)


            val poppedElements = stack.popAll()


            assertEquals(listOf(1, 2, 3), poppedElements)
            assertTrue(stack.isEmpty())
        }
    }

    @Nested
    inner class PeekTests {

        @Test
        fun `peek should return the first element from the stack without removing it`() {

            val stack = fifoStackOf<Int>()
            stack.push(1)
            stack.push(2)


            val topElement = stack.peek()


            assertEquals(1, topElement)
            assertEquals(2, stack.size())
        }

        @Test
        fun `peek on an empty stack should return null`() {

            val stack = fifoStackOf<Int>()


            val topElement = stack.peek()


            assertNull(topElement)
            assertTrue(stack.isEmpty())
        }
    }

    @Nested
    inner class SizeTests {

        @Test
        fun `size should return the number of elements in the stack`() {

            val stack = fifoStackOf<Int>()


            assertEquals(0, stack.size())

            stack.push(1)
            assertEquals(1, stack.size())

            stack.push(2)
            assertEquals(2, stack.size())
        }

        @Test
        fun `isEmpty should return true if the stack is empty`() {

            val stack = fifoStackOf<Int>()


            assertTrue(stack.isEmpty())

            stack.push(1)
            assertFalse(stack.isEmpty())
        }
    }
}
