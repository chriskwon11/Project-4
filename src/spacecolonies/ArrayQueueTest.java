package spacecolonies;

import queue.EmptyQueueException;
import student.TestCase;

/**
 * Test class for the ArrayQueue.
 * 
 * @author Chris Kwon
 *
 */
public class ArrayQueueTest extends TestCase {
    private ArrayQueue<String> emptyQueue;
    private ArrayQueue<String> fullQueue;


    /**
     * Sets up each test case.
     */
    public void setUp() {
        emptyQueue = new ArrayQueue<String>();
        fullQueue = new ArrayQueue<String>();
        for (int i = 0; i < fullQueue.getLength() - 1; i++) {
            fullQueue.enqueue("" + i);
        }
    }


    /**
     * Testing clear on a full queue
     */
    public void testClear() {
        assertEquals(10, fullQueue.getSize());
        fullQueue.clear();
        assertEquals(0, fullQueue.getSize());
        assertEquals(true, fullQueue.isEmpty());
    }


    /**
     * Testing enqueue and dequeue methods on an
     * originally empty queue.
     */
    public void testEnqueueDequeue() {
        emptyQueue.enqueue("1");
        assertEquals(1, emptyQueue.getSize());
        assertEquals("1", emptyQueue.dequeue());
        assertEquals(0, emptyQueue.getSize());
        emptyQueue.enqueue("1");
        emptyQueue.enqueue("2");
        emptyQueue.enqueue("3");
        emptyQueue.enqueue("4");
        assertEquals(4, emptyQueue.getSize());
        assertEquals("1", emptyQueue.dequeue());
        assertEquals("2", emptyQueue.dequeue());
        assertEquals("3", emptyQueue.dequeue());
        assertEquals(1, emptyQueue.getSize());
    }


    /**
     * Testing the getFront method to retrieve
     * the next object to be dequeued.
     */
    public void testGetFront() {
        emptyQueue.enqueue("1");
        assertEquals("1", emptyQueue.getFront());
        emptyQueue.enqueue("2");
        assertEquals("1", emptyQueue.getFront());
        emptyQueue.dequeue();
        assertEquals("2", emptyQueue.getFront());
    }


    /**
     * Tests isEmpty on an empty queue and a queue
     * with one object
     */
    public void testIsEmpty() {
        assertEquals(true, emptyQueue.isEmpty());
        emptyQueue.enqueue("1");
        assertEquals(false, emptyQueue.isEmpty());
        emptyQueue.dequeue();
        assertEquals(true, emptyQueue.isEmpty());
    }


    /**
     * Testing enqueue on a full array and making
     * sure ensureCapcity doubles the size of the array
     */
    public void testEnqueueFullArray() {
        assertEquals(11, fullQueue.getLength());
        assertEquals(10, fullQueue.getSize());
        fullQueue.enqueue("10");
        assertEquals(22, fullQueue.getLength());
        assertEquals(11, fullQueue.getSize());
    }


    /**
     * Testing toArray for an empty queue. Throws
     * an EmptyQueueException.
     */
    public void testToArrayEmptyQueue() {
        Exception exception = null;
        try {
            emptyQueue.toArray();
            fail("toArray() is not throwing an exception when" + "it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("add() is throwing the wrong type of exceptions",
            exception instanceof EmptyQueueException);
    }


    /**
     * Testing toArray for the full queue.
     */
    public void testToArrayQueue() {
        Object[] array = fullQueue.toArray();
        for (int i = 0; i < fullQueue.getSize(); i++) {
            assertEquals("" + i, array[i]);
        }
    }


    /**
     * Testing toString for an empty queue and a full queue
     */
    public void testToString() {
        assertEquals("[]", emptyQueue.toString());
        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", fullQueue.toString());
    }


    /**
     * Testing equals when the object in comparison is null
     */
    public void testEqualsNull() {
        assertEquals(false, fullQueue.equals(null));
    }


    /**
     * Testing equals when the object in comparison is of a different class
     */
    public void testEqualsDiffClass() {
        assertEquals(false, fullQueue.equals(0));
    }


    /**
     * Testing equals when the object in comparison is of the same class
     * but different queues
     */
    public void testEqualsSameClassDiffQueue() {
        emptyQueue.enqueue("1");
        assertEquals(false, fullQueue.equals(emptyQueue));
    }


    /**
     * Testing equals when the object in comparison is of the same class
     * and same queues
     */
    public void testEqualsSameClassSameQueue() {
        ArrayQueue<String> sameFullQueue = new ArrayQueue<String>();
        for (int i = 0; i < sameFullQueue.getLength() - 1; i++) {
            sameFullQueue.enqueue("" + i);
        }
        assertEquals(true, fullQueue.equals(sameFullQueue));

    }
}
