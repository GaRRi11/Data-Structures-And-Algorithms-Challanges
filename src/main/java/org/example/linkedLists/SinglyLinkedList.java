package org.example.linkedLists;

public class SinglyLinkedList <T>{

    public class Node{
        public T data;
        public Node nextNode;
    }

    private Node headNode;
    private int size;

    public Node getHeadNode() {
        return headNode;
    }

    public void setHeadNode(Node headNode) {
        this.headNode = headNode;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public SinglyLinkedList(){
        headNode = null;
        size = 0;
    }

    public boolean isEmpty(){
        if (headNode == null){
            return true;
        }
        return false;
    }

    public void insertAtHead(T data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = headNode;
        headNode = newNode;
        size++;
    }

    public void printList(){
        if (isEmpty()){
            System.out.println("empty");
            return;
        }
        Node temp = headNode;
        System.out.println("List : ");
        while (temp.nextNode != null){
            System.out.println(temp.data.toString() + " -> ");
            temp = temp.nextNode;
        }
        System.out.println(temp.data.toString()+ " -> null");
    }

    public void insertAtEnd(T data){
        if (isEmpty()){
            insertAtHead(data);
            return;
        }
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = null;
        Node last = headNode;

        while (last.nextNode != null){
            last = last.nextNode;
        }
        last.nextNode = newNode;
        size++;
    }

    public void insertAfter(T data, T previous){
        //create new node with value data
        Node newNode = new Node();
        newNode.data = data;

        //start from head node
        Node currentNode =  this.headNode;

        //traverse the list until node having data equals to previuos is found
        while (currentNode != null && !currentNode.data.equals(previous)) {
            currentNode = currentNode.nextNode;
        }
        //if such a node was found
        //then point our newNode to currentNode`s next element
        if (currentNode != null){
            newNode.nextNode = currentNode.nextNode;
            currentNode.nextNode = newNode;
            size++;
        }
    }

    boolean searchNode (T data){
        Node currentNode = this.headNode;
        while (currentNode != null){
            if (currentNode.data.equals(data)){
                return true;
            }
            currentNode = currentNode.nextNode;
        }
        return false;
    }

    public void deleteHead(){
        if (isEmpty()){
            return;
        }
        //make the nextNode of the headNode uqual to new headNode
        headNode = headNode.nextNode;
        size--;
    }

    public void deleteByValue(T data){
        Node currentNode = this.headNode;
        Node previousNode = null;

        if (currentNode.data.equals(data)){
            deleteHead();
            return;
        }

        while (currentNode!= null){
            if (data.equals(currentNode.data)){
                previousNode.nextNode = currentNode.nextNode;
                size--;
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        }
    }

//    Array vs. Linked List
//    Memory Allocation
//    The main difference between a linked list and an array is the way they are allocated memory. Arrays instantiate a
//    whole block of memory, e.g., array[1000] gets space to store 1000 elements at the start even if it doesn’t contain
//    any element yet. On the other hand, a linked list only instantiates the portion of memory it uses.
//
//    Insertion and Deletion
//    For lists and arrays, many differences can be observed in the way elements are inserted and deleted. In a linked list,
//    insertion and deletion at head happen in a constant amount of time (O(1)), while arrays take O(n) time to insert or
//    delete a value because you have to shift the array elements left or right after that operation.
//
//    Searching
//    In an array, it takes constant time to access an index. In a linked list, you have to iterate the list from the start
//    until you find the node with the correct value.
//
//    The table given below will summarize the performance difference between linked lists and arrays.
//
//    Operation	         Linked List   Array
//      Access               O(n)       O(1)
//      Insert (at head)     O(1)       O(n)
//      Delete (at head)     O(1)       O(n)
//      Insert (at tail)	 O(n)	    O(n)
//      Delete (at tail)	 O(n)	    O(n)


}
