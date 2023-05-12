package org.example.stack;

public class TwoStacks <V> {

    //Challenge: Implement Two Stacks Using One Array


    private int maxSize;
    private int top;
    private int count;
    boolean switcher = false;
    private V[] array;

    @SuppressWarnings("unchecked")
    public TwoStacks(int max_size) {
        this.maxSize = max_size;
        array = (V[]) new Object[max_size];//type casting Object[] to V[]
    }

    public boolean isFull(){
        return top == maxSize -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    //insert at top of first stack
    public void push1(V value) {
        if (isFull()) {
            System.out.println("Stack is Full! ");
            return;
        }
        if (switcher){
            array[top] = value;
        }
        array[++top] = value;
        count = 0;
    }

    //insert at top of second stack
    public void push2(V value) {
        if (isFull()) {
            System.out.println("Stack is Full! ");
            return;
        }
        switcher = true;
        count++;
        array[top++] = value;
    }

    //remove and return value from top of first stack
    public V pop1() {
        if (isEmpty()){
            return null;
        }
        if (switcher){
            return array[top - count];
        }
        return array[top--];
    }

    //remove and return value from top of second stack
    public V pop2() {
        if (isEmpty()){
            return null;
        }
        return array[top--];
    }

    //gavigo sad mtavrdeba pirveli da sad iwkeba meore
}
