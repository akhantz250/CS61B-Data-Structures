package deque;

import java.util.Iterator;

public interface Deque<T> {
    public void addFirst(T x);
    public void addLast(T x);
    public T removeFirst();
    public T removeLast();
    public T get(int n);
    public int size();
    public void printDeque();

    default public boolean isEmpty() {
        return this.size() == 0;
    }
    public Iterator<T> iterator();
    public boolean equals(Object o);
}
