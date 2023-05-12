package org.example.linkedLists;

public class DoublyLinkedList<T>{
    public class Node{
        public T data;
        public Node nextNode;
        public Node prevNode;
    }

    public Node headNode;
    public Node tailNode;

    public int size;

    public DoublyLinkedList(){
        this.headNode = null;
        this.tailNode = null;
    }

    public boolean isEmpty(){
        if (headNode == null && tailNode == null){
            return true;
        }
        return false;
    }

    //getter for headNode
    public Node getHeadNode() {
        return headNode;
    }

    //getter for tailNode
    public Node getTailNode() {
        return tailNode;
    }


    public void insertAtHead(T data){
        Node newNode = new Node();
        newNode.data = data;

        newNode.nextNode = this.headNode;
        newNode.prevNode = null;
        if (headNode != null){
            headNode.prevNode = newNode;
        }
        this.headNode = newNode;
        size++;
    }

    public void insertAtHeadWithTailNode(T data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = this.headNode;
        newNode.prevNode = null;
        if (!isEmpty()){
            headNode.prevNode = newNode;
        }else {
            tailNode = newNode;
            this.headNode = newNode;
            size++;
        }
    }

    public void insertAtEndWithTailNode(T data){
        if (isEmpty()){
            insertAtHeadWithTailNode(data);
            return;
        }
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = null;
        newNode.prevNode = tailNode;
        tailNode.nextNode = newNode;
        tailNode = newNode;
        size++;
    }

    public void deleteAtHeadWithTailNode(){
        if (isEmpty()){
            return;
        }
        this.headNode = this.headNode.nextNode;
        if (headNode == null){
            tailNode = null;
        }
        else {
            this.headNode.prevNode = null;
        }
        size--;
    }

    public void deleteAtTailWithTailNode(){
        if (isEmpty()){
            return;
        }
        tailNode = tailNode.prevNode;
        if (tailNode == null){
            headNode = null;
        }else {
            tailNode.nextNode = null;
        }
        size--;
    }

    public void printList(){
        if (isEmpty()){
            System.out.println("List is Empty");
            return;
        }

        Node temp = headNode;
        System.out.println("List : null <- ");
        while (temp.nextNode != null){
            System.out.println(temp.data.toString() + " <-> ");
            temp = temp.nextNode;
        }
        System.out.println(temp.data.toString() + " -> null");
    }

    public void deleteAtHead(){
        if (isEmpty()){
            return;
        }
        headNode = headNode.nextNode;
        headNode.prevNode = null;
        size--;
    }

    public void deleteByValue(T data){
        if (isEmpty()){
            return;
        }
        Node currentNode = this.headNode;

        if (currentNode.data.equals(data)){
            deleteAtHead();
            return;
        }

        while (currentNode != null){
            if (data.equals(currentNode.data)){
                currentNode.prevNode.nextNode = currentNode.nextNode;
                if (currentNode.nextNode != null){
                    currentNode.nextNode.prevNode = currentNode.prevNode;
                    size--;
                }
                currentNode = currentNode.nextNode;
            }
        }
    }

    //Challenge: Find the Length of a Linked List

    public int length(){
        int count = 0;
        Node node = this.headNode;
        while (node!=null){
            count++;
            node = node.nextNode;
        }
        return count;
    }

    //Challenge: Find the Middle Node of a Linked List
    public static <T> Object findMiddle(SinglyLinkedList<T> list){

        if (list.isEmpty()){
            return null;
        }

        SinglyLinkedList.Node current = list.getHeadNode();
        int count = 0;
        while (current != null){
            count++;
            current = current.nextNode;
        }
        if (count%2 == 1){
            count++;
        }

        SinglyLinkedList.Node node = list.getHeadNode();
        for (int i = 1; i < count; i++) {
                if (i == count/2){
                    return node.data;
                }
            node = node.nextNode;
        }

        return -1;
    }

    public static <T> Object findMiddle2(SinglyLinkedList<T> list) {
        //if list is empty, then return null
        if (list.isEmpty())
            return null;

        //both nodes start from the head
        SinglyLinkedList.Node mid = list.getHeadNode();
        SinglyLinkedList.Node current = list.getHeadNode();

        while(mid != null && current != null && current.nextNode != null)
        {
            //current jumps 2 nodes on each iteration
            current = current.nextNode.nextNode;
            //if current is not null (end of list is not reached)
            if(current != null){
                //then mid jumps 1 node
                //mid is always halfway behind current
                mid = mid.nextNode;
            }
        }
        return mid.data;
    }


    //Challenge: Remove Duplicates from a Linked List
    public static <T> void removeDuplicates(SinglyLinkedList<T> list) {

        SinglyLinkedList.Node current = list.getHeadNode();
        SinglyLinkedList.Node checker = list.getHeadNode();
        while (current != null){
            while (checker !=null){
                if (current.data.equals(checker.data)){
                    if (current == list.getHeadNode()){
                        list.deleteHead();
                    }
                    list.deleteByValue((T) current.data);
                }
                checker = checker.nextNode;
            }
            current = checker.nextNode;
        }

    }

    public static <T> void removeDuplicates2(SinglyLinkedList<T> list) {
        SinglyLinkedList<T>.Node current = list.getHeadNode(); // will be used for outer loop
        SinglyLinkedList<T>.Node compare = null;     // will be used for inner loop

        while (current != null && current.nextNode != null) {
            compare = current;
            while (compare.nextNode != null) {
                if (current.data.equals(compare.nextNode.data)) { //check if duplicate
                    compare.nextNode = compare.nextNode.nextNode;
                } else {
                    compare = compare.nextNode;
                }
            }
            current = current.nextNode;
        }
    }

    //Challenge: Union & Intersection of Lists

    public static <T> SinglyLinkedList<T> union(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {

        if (list1.isEmpty())
            return list2;
        if (list2.isEmpty())
            return list1;

        SinglyLinkedList.Node current = list1.getHeadNode();
        SinglyLinkedList result = new SinglyLinkedList();
        while (current != null) {
            result.insertAtEnd(current.data);
            current = current.nextNode;
        }
        current = list2.getHeadNode();
        while (current != null){
            result.insertAtEnd(current.data);
            current = current.nextNode;
        }
        return result;
    }


    public static <T> SinglyLinkedList<T> union2(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {

        //if one of the list is empty then return the other list
        if (list1.isEmpty())
            return list2;
        if (list2.isEmpty())
            return list1;

        //take the head of the first list
        SinglyLinkedList<T>.Node last = list1.getHeadNode();
        //traverse it to the last element
        while (last.nextNode != null) {
            last = last.nextNode;
        }
        //attach the last element of list1 to head of list2
        last.nextNode = list2.getHeadNode();
        //remove duplicates that might have been added now

        return list1;
    }

    public static <T> SinglyLinkedList<T> intersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList.Node current = list1.getHeadNode();
        SinglyLinkedList.Node inner = list2.getHeadNode();
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();

        if (list1.isEmpty())
            return result;
        if (list2.isEmpty())
            return result;

        while (current != null){
            while (inner != null){
                if (current.data.equals(inner.data)){
                    result.insertAtEnd((T) inner.data);
                }
                inner = inner.nextNode;
            }
            current = current.nextNode;
        }
        return result;
    }

    //Challenge: Return the Nth Node from End

    public static <T> Object nthElementFromEnd(SinglyLinkedList<T> list, int n){
        if (list.isEmpty() || n == 0){
            return null;
        }

        SinglyLinkedList.Node current = list.getHeadNode();
        int count = 0;
        while (current != null){
            count++;
            current = current.nextNode;
        }
        int fromEnd = count - n;
        if (fromEnd < 0){
            return null;
        }
        current = list.getHeadNode();
        for (int i = 0; i < count; i++) {
            if (i == fromEnd){
                return current.data;
            }
            current = current.nextNode;
        }
        return -1;

    }


    //Challenge: Find if Doubly Linked-list is a Palindrome

    //step1 gavkot shuaze
    //gavkot or listad
    //step2 shevadarot pirveli listis pirveli aso meore listis bolo asos da ese mivkevt
    public static <T> boolean  isPalindrome(DoublyLinkedList<T> list){
        if (list.isEmpty())
            return false;

        DoublyLinkedList.Node mid = list.getHeadNode();
        DoublyLinkedList.Node current = list.getHeadNode();
        DoublyLinkedList.Node head = list.getHeadNode();
        DoublyLinkedList.Node tail = list.getTailNode();


        while(mid != null && current != null && current.nextNode != null) {
            current = current.nextNode.nextNode;
            if(current != null){
                mid = mid.nextNode;
            }
        }

        boolean checker = false;
        while (head != mid){
            if (head.data.equals(tail.data)){
                checker = true;
                head = head.nextNode;
                tail = tail.prevNode;
            }else {
                checker = false;
            }
        }
        return checker;
    }

}
