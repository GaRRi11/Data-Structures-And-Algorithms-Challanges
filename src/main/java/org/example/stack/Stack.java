package org.example.stack;

public class Stack <V>{

    private int maxSize;
    private int top;
    private V array[];

    private int currentSize;

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public V[] getArray() {
        return array;
    }

    public void setArray(V[] array) {
        this.array = array;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }
/*
    Java does not allow generic type arrays. So we have used an
    array of Object type and type-casted it to the generic type V.
    This type-casting is unsafe and produces a warning.
    Comment out the line below and execute again to see the warning.
    */

    @SuppressWarnings("unchecked")
    public Stack(int max_size) {
        this.maxSize = max_size;
        this.top = -1;
        array = (V[]) new Object[max_size];
        this.currentSize = 0;
    }

    public int getCapacity() {
        return maxSize;
    }

    public int getMaxSize(){
        return maxSize;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize -1;
    }

    public V top(){
        if (isEmpty()){
            return null;
        }
        return array[top];
    }

    public void push(V value){
        if (isFull()) {
            System.out.println("Stack is Full! ");
            return;
        }
        array[++top] = value;
        currentSize++;
    }

    public V pop(){
        if (isEmpty()){
            return null;
        }
        currentSize--;
        return array[top--];
    }

    public void sortStack(Stack<Integer> stack){
        Stack stack2 = new Stack(stack.getMaxSize());
        int arr [] = new int[stack.getMaxSize()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            stack2.push(arr[i]);
        }
        stack = stack2;
    }

    public void sortStack2(Stack<Integer> stack){
        Stack<Integer> newStack = new Stack<>(stack.getMaxSize());
        while (!stack.isEmpty()){
            Integer value = stack.pop();
            if (!newStack.isEmpty() && value >= newStack.top){
                newStack.push(value);
            }else {
                while (!newStack.isEmpty() && newStack.top > value)
                    stack.push(newStack.pop());
                newStack.push(value);
            }
        }
        while (!newStack.isEmpty()){
            stack.push(newStack.pop());
        }
    }

    public int [] nextGreaterElement(int [] arr){
        int[] result = new int[arr.length];
        int counter= 0;
        Stack stack = new Stack(arr.length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > arr[i] && arr[j] > stack.top){
                    result[counter] = arr[j];
                    stack.push(arr[j]);
                    counter++;
                    break;
                }
            }
        }
        // 4 6 3 2 8 1
        // 6 8 8 8 -1 -1
        stack.push(arr[0]);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > stack.top){
                stack.push(arr[i]);
            }else {

            }
        }
        return result;
    }



}


