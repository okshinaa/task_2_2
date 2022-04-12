package ru.vsu.cs.okshina_v_a;

import java.util.*;

public class MyStack<T> extends Stack<T> implements Iterable<T> {
    private static final String MSG = "Element not found.";
    private Node head;

    public boolean empty() {
        return head == null;
    }

    public T push(T value) {
        this.head = new Node(this.head, value);
        return value;
    }

    public T peek() {
        if (this.head == null) {
            throw new EmptyStackException();
        }
        return this.head.value;
    }

    public T pop() {
        if (this.head == null) {
            throw new EmptyStackException();
        }
        T value = this.head.value;
        this.head = this.head.next;
        return value;
    }

    public void clear() {
        this.head = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (!empty()) {
            int count = 0;
            for (Node cursor = this.head; cursor != null; cursor = cursor.next) {
                if (count++ != 0) {
                    sb.insert(1, ", ");
                }
                sb.insert(1, cursor.value);
            }
        }
        return sb.append("]").toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class Node {
        private Node next;
        private T value;

        Node(Node next, T value) {
            this.next = next;
            this.value = value;
        }
    }

    private class StackIterator implements Iterator<T> {
        private Node cursor = head;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException(MSG);
            }
            T value = cursor.value;
            cursor = cursor.next;
            return value;
        }
    }
}