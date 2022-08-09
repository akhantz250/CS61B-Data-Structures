package deque;


import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] itemsArray = (T[]) new Object[8];
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        this.size = 0;
        this.nextLast = 0;
        this.nextFirst = 7;
    }

    public void addLast(T x) {
        int n = itemsArray.length;
        if (size == n ) {
            resize(size * 2);
            n = itemsArray.length;
        }
        itemsArray[nextLast] = x;
        nextLast = (((nextLast + 1) % n) + n) % n;
        size++;
    }

    @Override
    public void addFirst(T x) {
        int n = itemsArray.length;
        if (size == n) {
            resize(size * 2);
            n = itemsArray.length;
        }
        itemsArray[nextFirst] = x;
        nextFirst = (((nextFirst - 1) % n) + n) % n;
        size++;
    }

    // the resize method works correctly for expanding the array.
    // doesn't work yet with shrinking the array.
    private void resize(int capacity) {
        int n = itemsArray.length;
        if (capacity > n) {
            expand(capacity);
        } else {
            shrink(capacity);
        }
    }
    private void expand(int capacity) {
        int n = itemsArray.length;
        int first = (((nextFirst + 1) % n) + n) % n;
        int last = (((nextLast - 1) % n) + n) % n;
        T[] newArray = (T[]) new Object[capacity];
        if (first < last) {
            System.arraycopy(itemsArray, first, newArray, 0, size);
        } else {
            // len from first to end, ie the second part of the array
            int x = size - first;
            System.arraycopy(itemsArray, first, newArray, 0, x);
            System.arraycopy(itemsArray, 0, newArray, x, last + 1);
        }
        // reset the indexes of nextFirst and nextLast
        nextLast = n;
        nextFirst = newArray.length - 1;
        itemsArray = newArray;
    }
    private void shrink(int capacity) {
        int n = itemsArray.length;
        int first = (((nextFirst + 1) % n) + n) % n;
        int last = (((nextLast - 1) % n) + n) % n;
        T[] newArray = (T[]) new Object[capacity];
        if (first < last) {
            System.arraycopy(itemsArray, first, newArray, 0, size);
        } else {
            // copy first to n to front of the new array
            int x = n - first;
            System.arraycopy(itemsArray, first, newArray, 0, x);
            // copy index 0 to last after pos x in new array
            System.arraycopy(itemsArray, 0, newArray, x, last + 1);
        }
        nextLast = size;
        nextFirst = newArray.length - 1;
        itemsArray = newArray;
    }

    @Override
    // Change last index and size
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        int n = itemsArray.length;
        if (size < 0.2 * n && n > 8) {
            resize(n / 4);
        }
        int pos = (((nextLast - 1) % n) + n) % n;
        T removed = itemsArray[pos];
        itemsArray[pos] = null;
        nextLast = pos;
        size--;
        return removed;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        int n = itemsArray.length;
        if (size < 0.2 * n && n > 8) {
            resize(n / 4);
        }
        int pos = (((nextFirst + 1) % n) + n) % n;
        T removed = itemsArray[pos];
        itemsArray[pos] = null;
        nextFirst = pos;
        size--;
        return removed;
    }

    @Override
    public T get(int x) {
        if (x < 0 || x >= size) {
            return null;
        }
        int n = itemsArray.length;
        int first = (((nextFirst + 1) % n) + n) % n;
        int pos = (((first + x) % n) + n) % n;
        return itemsArray[pos];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        int n = itemsArray.length;
        int first = (((nextFirst + 1) % n) + n) % n;
        int last = (((nextLast - 1) % n) + n) % n;
        for (int i = first; i != last; i++) {
            if (i >= n) {
                i = (((i) % n) + n) % n;
            }
            System.out.print(itemsArray[i] + " ");
        }
        System.out.print(itemsArray[last]);
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
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

    private class ArrayDequeIterator implements Iterator<T> {
        private int pos;

        ArrayDequeIterator() {
            pos = 0;
        }

        @Override
        public boolean hasNext() {
            return pos < size;
        }

        @Override
        public T next() {
            T item = ArrayDeque.this.get(pos);
            pos += 1;
            return item;
        }
    }
}
