package org.example.queue;

import org.example.stack.Stack;

public class QueueWithStack <V> {

    int maxSize;

    int frontCounter = 1;



    Stack stack;

    public QueueWithStack(int maxSize){
        this.maxSize = maxSize;
        stack = new Stack(maxSize);
    }

    public void enqueue(V value){
        stack.push(value);
        // Write -- Your -- Code
    }
    public V dequeue(){
        Stack stack1 = new Stack(stack.getMaxSize());

        while (!stack.isEmpty()){
            stack1.push(stack.pop());
        }
        V o = null;
        for (int i = 0; i < frontCounter; i++) {
             o = (V) stack1.pop();
        }
        frontCounter++;
        while (!stack1.isEmpty()){
            stack.push(stack1.pop());
        }
        return o;
    }
    public boolean isEmpty(){
        //Write -- Your -- Code
        return stack.isEmpty();
    }
}
