package org.example.queue;

import org.example.stack.Stack;

public class Queue<V> {
    private int maxSize;
    private V[] array;
    private int front;
    private int back;
    private int currentSize;

    public Queue(int maxSize){
        this.maxSize = maxSize;
        array = (V[]) new Object [maxSize];
        front = 0;
        back = 0;
        currentSize = 0;
    }

    public int getMaxSize(){
        return maxSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    public boolean isFull(){
        return currentSize == maxSize;
    }
    public V top(){
        return array[front];
    }

    public void enqueue(V value){
        if (isFull()){
            return;
        }
        back = (back + 1) % maxSize;
        array[back] = value;
        currentSize++;
    }
    public V dequeue(){
        if (isEmpty()){
            return null;
        }

        V temp = array[front];
        front = (front + 1) % maxSize;
        currentSize--;

        return temp;
    }

    void reverseK(Queue<V> queue, int k){
            if (queue.isEmpty() || k <= 0)
                return;
            Stack<V> stack = new Stack<>(k);

            while(!stack.isFull())
                stack.push(queue.dequeue());

            while(!stack.isEmpty())
                queue.enqueue(stack.pop());

            int size = queue.getCurrentSize();
            for(int i = 0; i < size - k; i++)
                queue.enqueue(queue.dequeue());
    }



}
