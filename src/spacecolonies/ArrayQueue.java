package spacecolonies;

import queue.QueueInterface;

public class ArrayQueue<T> implements QueueInterface<T>{
    private T[] queue;
    private static final int DEFATULT_CAPACITY= 10;
    public static final int MAX_CAPACITY = 100;
    private int enqueueIndex;
    private int dequeueIndex;
    private int size;
    
    public ArrayQueue() {
        
    }
    
    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public T dequeue() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void enqueue(T arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public T getFront() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }
}
