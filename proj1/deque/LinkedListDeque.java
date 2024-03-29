package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private class Node {
        private T item;
        private Node next;
        private Node prev;

        Node(T item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        Node(Node next, Node prev) {
            this.next = next;
            this.prev = prev;
        }
    }

    private Node sentinel = new Node(null, null);
    private int size;

    public LinkedListDeque() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel.next, sentinel);
        newNode.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node newNode = new Node(item, sentinel, sentinel.prev);
        newNode.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node p = this.sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
    // get n - 1th item in deque
    public T get(int n) {
        if (n < 0 || n > size - 1) {
            return null;
        }
        Node p = sentinel.next;

        for (int i = 0; i != n; i++) {
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(int n) {
        return getRecursiveHelper(n, sentinel.next);
    }

    private T getRecursiveHelper(int n, Node p) {
        // Base case
        if (n > size - 1 || n < 0) {
            return null;
        } else if (n == 0) {
            return p.item;
        }
        // Recursive case
        return getRecursiveHelper(n - 1, p.next);
    }

    @Override
    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        T removed = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return removed;
    }

    @Override
    public T removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        }
        T removed = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return removed;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Deque<?>)) {
            return false;
        }
        Deque<T> other = (Deque<T>) obj;
        if (other.size() != this.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            T otherVal = other.get(i);
            T thisVal = this.get(i);
            if (!thisVal.equals(otherVal)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private int pos;

        LinkedListIterator() {
            pos = 0;
        }

        @Override
        public boolean hasNext() {
            return pos < size;
        }

        @Override
        public T next() {
            T item = LinkedListDeque.this.get(pos);
            pos += 1;
            return item;
        }
    }

}
