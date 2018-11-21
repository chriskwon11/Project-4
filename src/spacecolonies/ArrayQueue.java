package spacecolonies;

import queue.EmptyQueueException;
import queue.QueueInterface;

/**
 * This class acts as the main data structure for this project. It
 * implements a queueInterface with a circular array implementation.
 * It provides behavior of a queue, such as enqueue, dequeue, getFront,
 * and isEmpty.
 * 
 * @author Chris Kwon
 *
 * @param <T>
 */
public class ArrayQueue<T> implements QueueInterface<T> {
    private T[] queue;
    private static final int DEFAULT_CAPACITY = 10;
    public static final int MAX_CAPACITY = 100;
    private int enqueueIndex;
    private int dequeueIndex;
    private int size;


    /**
     * Creates a new ArrayQueue, which creates the underlying
     * array that stores the objects. Sets the size to 0 and
     * also sets the indices for enqueue and dequeue.
     */
    public ArrayQueue() {
        @SuppressWarnings("unchecked")
        T[] tempQueue = (T[])new Object[DEFAULT_CAPACITY + 1];
        queue = tempQueue;
        dequeueIndex = 0;
        enqueueIndex = DEFAULT_CAPACITY;
        size = 0;
    }


    /**
     * Essentially calls the constructor again, and in turn creates
     * a new array with no entries and setting that as the underlying
     * storage for new objects. The size is set to 0 and the indices
     * for enqueue and dequeue are also reset.
     */
    @Override
    public void clear() {
        @SuppressWarnings("unchecked")
        T[] tempQueue = (T[])new Object[DEFAULT_CAPACITY + 1];
        queue = tempQueue;
        dequeueIndex = 0;
        enqueueIndex = DEFAULT_CAPACITY;
        size = 0;

    }


    /**
     * Checks to see if the array is empty and if so throws
     * a new EmptyQueueException. If not the entry in the
     * dequeue index is set to null and also returned. The
     * size is decremented and the dequeue index is incremented.
     * 
     * @return Returns the entry that was removed
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        else {
            T front = queue[dequeueIndex];
            queue[dequeueIndex] = null;
            dequeueIndex = this.incrementIndex(dequeueIndex);
            size--;
            return front;

        }
    }


    /**
     * Adds a new entry to the enqueue index of the array. However
     * the method first ensures that the array is not full and if it
     * is, doubles the size of the array. Size is incremented.
     * 
     * @param entry
     *            The entry to be added to the queue.
     */
    @Override
    public void enqueue(T entry) {
        this.ensureCapacity();
        enqueueIndex = this.incrementIndex(enqueueIndex);
        queue[enqueueIndex] = entry;
        size++;

    }


    /**
     * Returns the object in the dequeue index position of the array.
     * 
     * @return The next object to be dequeued
     */
    @Override
    public T getFront() {
        return queue[dequeueIndex];
    }


    /**
     * Checks to see if the array is empty
     * 
     * @return True if empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return this.incrementIndex(enqueueIndex) == dequeueIndex;
    }


    /**
     * Checks to see if the array is full.
     * 
     * @return True if full, false otherwise.
     */
    private boolean isFull() {
        return dequeueIndex == ((enqueueIndex + 2) % queue.length);
    }


    /**
     * If the array is full then the capacity of the array is doubled
     * and its original contents are copied into the array.
     */
    private void ensureCapacity() {
        if (this.isFull()) {
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            int newSize = 2 * oldSize;

            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[])new Object[newSize];
            queue = tempQueue;
            for (int index = 0; index < oldSize - 1; index++) {
                queue[index] = oldQueue[dequeueIndex];
                dequeueIndex = (dequeueIndex + 1) % oldSize;
            }
            dequeueIndex = 0;
            enqueueIndex = oldSize - 2;
        }
    }


    /**
     * Increments the given index such that when it goes over
     * the length of the array it loops over to the beginning.
     * 
     * @param index
     *            Index to be incremented
     * @return Incremented index.
     */
    private int incrementIndex(int index) {
        return ((index + 1) % queue.length);
    }


    /**
     * Returns the number of elements in the array
     * 
     * @return Number of elements
     */
    public int getSize() {
        return size;
    }


    /**
     * Returns the length of the array
     * 
     * @return Length of array
     */
    public int getLength() {
        return queue.length;
    }


    /**
     * Returns an array representation of the ArrayQueue.
     * 
     * @return Array representing the queue.
     */
    public Object[] toArray() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        else {
            @SuppressWarnings("unchecked")
            T[] array = (T[])new Object[size];
            for (int index = 0; index < size; index++) {
                array[index] = queue[dequeueIndex];
                dequeueIndex = this.incrementIndex(dequeueIndex);
            }
            return array;
        }
    }


    /**
     * Returns a string representation of the ArrayQueue.
     * 
     * @return String representing the queue.
     */
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");
        for (int index = dequeueIndex; index != this.incrementIndex(
            enqueueIndex); index = this.incrementIndex(index)) {
            string.append(queue[index]);
            if (index != enqueueIndex) {
                string.append(", ");
            }
        }
        string.append("]");
        return string.toString();
    }


    /**
     * Checks to see if two ArrayQueue's are equal
     * 
     * @param obj
     *            The object to be compared to.
     * @return True, if the contents are the same and in the same order,
     *         false if null, not of the same class, or of different
     *         contents/order.
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        else if (obj.getClass() != this.getClass()) {
            return false;
        }
        else {
            Object[] array = this.toArray();
            @SuppressWarnings("unchecked")
            ArrayQueue<T> other = (ArrayQueue<T>)obj;
            Object[] otherArray = other.toArray();
            if (other.getSize() != this.getSize()) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                Object myElement = array[i];
                Object otherElement = otherArray[i];
                if (!myElement.equals(otherElement)) {
                    return false;
                }
            }
            return true;
        }

    }

}
