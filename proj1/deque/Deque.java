package deque;

import java.util.Iterator;

public interface Deque<Type> {
    public void addFirst(Type x);
    public void addLast(Type x);
    public Type removeFirst();
    public Type removeLast();
    public Type get(int n);
    public int size();
    public void printDeque();

    default public boolean isEmpty() {
        return this.size() == 0;
    }
    public Iterator<Type> iterator();
    public boolean equals(Object o);
}
