package deque;

import java.util.Iterator;

public interface Deque<T> {
    void addFirst(T x);

    void addLast(T x);

    T removeFirst();

    T removeLast();

    T get(int n);

    int size();

    void printDeque();

    default boolean isEmpty() {
        return this.size() == 0;
    }

    Iterator<T> iterator();

    boolean equals(Object o);
}
