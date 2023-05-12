package org.example;

import org.example.graphs.Graph;
import org.example.stack.Stack;

public class Main {


    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            String input = scanner.nextLine();
//
//            if (input.equals("hello")){
//                System.out.println("hello hello");
//            }
//        }
//
//    int [] array = new int [] {1, 2, 4, 5, 10, 6, 3};
//    int [] array1 = new int[] {1, 3, 4, 5};
//    int [] array2 = new int[] {2, 6, 7, 8};
//
//
//        for (int i = 0; i < 3; i++) {
//            System.out.println(methods.mergeArrays(array1,array2)[i]);
//        }
//
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                for (int k = 0; k < 5; k++) {
//                    System.out.println(i +"  "+ j+"  "+ k);
//                }
//            }
//        }
//
//        int [] first = new int[] {10, -1, 20, 4, 5, -9, -6};
//        int [] second = new int[] {66,2,6,7,8,77};
//        int [] a = new int[] {1,2,3,4,5,6,7};
//
//        ArrayAlgorithms[] az = new ArrayAlgorithms[4];
//
//
//        int [] result = ArrayAlgorithms.findSum(first,81);
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }
//
//        System.out.println(methods.findMinimum(first));

//        System.out.println(methods.findFirstUnique(first));
//        System.out.println(methods.findSecondMaximum(second));
//
//        methods.reArrange(first);
//
////        methods.maxMin(a);
//        System.out.println(methods.ArrayChallenge(2466));
//        String l = "vqgwd";
//        l.split(" ");


//        for (int i = 0; i < first.length; i++) {
//            System.out.println(a[i]);
//        }
//
//        SinglyLinkedList s = new SinglyLinkedList();
//        s.insertAtEnd(1);
//        s.insertAtEnd(2);
//        s.insertAtEnd(3);
//        s.insertAtEnd(4);
//        s.insertAtEnd(5);
//        s.printList();
//        s.deleteByValue(4);
//        s.printList();
//
//        DoubleLinkedList d = new DoubleLinkedList();
//        d.insertAtEndWithTailNode(1);
//        d.insertAtEndWithTailNode(2);
//        d.insertAtEndWithTailNode(3);
//        d.insertAtEndWithTailNode(4);
//        d.insertAtEndWithTailNode(5);
//
//
//        System.out.println(d.length());
//
//        Stack stack = new Stack(5);
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//        stack.pop();
////        stack.push(6);
//        System.out.println(9%8);
//
//        int [] array = new int[]{1,2,3,4,5,6};
//        ArrayAlgorithms arrayAlgorithms = new ArrayAlgorithms();
//        arrayAlgorithms.rotateArray(array);
//
//        QueueWithStack q = new QueueWithStack(5);
//        q.enqueue(1);
//        q.enqueue(2);
//        q.enqueue(3);
//        q.enqueue(4);
//        q.enqueue(5);
//
//        q.dequeue();
////        q.enqueue(6);
        Stack stack = new Stack(5);
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
////        stack.sortStack(stack);
//        int [] arr = new int[]{4,6,3,2,8,1};
//         int [] result = stack.nextGreaterElement(arr);
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[0]);
//        }

        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        System.out.println(g.bfs(g));




    }

}


