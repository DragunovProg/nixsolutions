package ua.dragunov.linkedlist;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        ForwardLinkedList<Integer> forwardLinkedList = new ForwardLinkedList<>();
        Iterator<Integer> iterator = forwardLinkedList.iterator();

        forwardLinkedList.add(12);
        forwardLinkedList.add(0);
        forwardLinkedList.add(9);
        forwardLinkedList.add(121);
        forwardLinkedList.addFirst(1000);

        System.out.println(forwardLinkedList.size());
        System.out.println(forwardLinkedList.get(0));
        forwardLinkedList.removeFirst();
        System.out.println(forwardLinkedList.getFirst());
        System.out.println(forwardLinkedList.get(3));
        forwardLinkedList.remove(Integer.valueOf(121));
        System.out.println(forwardLinkedList.getLast());
        forwardLinkedList.remove(2);
        System.out.println(forwardLinkedList.size());
        System.out.println();

        forwardLinkedList.forEach(System.out::println);
        System.out.println();

    }
}
