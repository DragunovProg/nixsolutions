package ua.dragunov.linkedlist;

import java.util.AbstractList;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ForwardLinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;



    @Override
    public E get(int index) {
        return node(index).element;
    }

    private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(e, f);
        first = newNode;

        if (f == null) {
            last = newNode;
        }
        size++;
    }

    private void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(e, null);
        last = newNode;

        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    public void addFirst(E e) {
        linkFirst(e);
    }

    public void addLast(E e) {
        linkLast(e);
    }

    private E unlinkFirst(Node<E> firstNode) {
        E firstElement = firstNode.element;
        Node<E> next = firstNode.next;

        firstNode.element = null;
        firstNode.next = null;
        first = next;

        if (next == null) {
            last = null;
        }
        size--;

        return firstElement;
    }

    private E unlink(Node<E> removingNode, Node<E> preRemovingNode) {
        E element = removingNode.element;
        preRemovingNode.next = removingNode.next;

        removingNode.element = null;
        removingNode.next = null;
        if (removingNode.next == null) {
            last = preRemovingNode;
        }
        size--;

        return element;
    }

    public E removeFirst() {
        Node<E> firstNode = first;

        if (firstNode == null) {
            throw new NoSuchElementException();
        }

        return unlinkFirst(firstNode);
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next)
                if (x.next.element == null) {
                    unlink(x.next, x);
                    return true;
                }
            } else {
            for (Node<E> x = first; x != null; x = x.next)
                if (o.equals(x.next.element)) {
                    unlink(x.next, x);
                    return true;
                }
        }

        return false;
    }

    @Override
    public E remove(int index) {
        Node<E> next = first;
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = 0; i < index - 1;i++) {
            next = next.next;
        }

        return unlink(next.next, next);
    }

    public E getFirst() {
        return Optional.of(first.element).orElseThrow(NoSuchElementException::new);
    }

    public E getLast() {
        return Optional.of(last.element).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public int size() {
        return size;
    }

    private Node<E> node(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int count = 0;
        Node<E> next = first;
        for (int i = 0;i < index;i++) {
            next = next.next;
        }

        return next;
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}
