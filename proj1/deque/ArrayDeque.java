package deque;



public class ArrayDeque<Type> implements Deque<Type> {
    private Type[] itemsArray = (Type[]) new Object[8];
    private int size;
    private int nextFirst;
    private int nextLast;
    public ArrayDeque() {
        this.size = 0;
        this.nextLast = 0;
        this.nextFirst = 7;
    }
    public void addLast(Type x) {
        int n = itemsArray.length;
        if (size == n) {
            resize(size * 2);
            n = itemsArray.length;
        }
        itemsArray[nextLast] = x;
        nextLast = (((nextLast + 1) % n) + n) % n;
        size++;
    }
    @Override
    public void addFirst(Type x) {
        int n = itemsArray.length;
        if (size == n) {
            resize(size * 2);
            n = itemsArray.length;
        }
        itemsArray[nextFirst] = x;
        nextFirst = (((nextFirst - 1) % n) + n) % n;
        size++;
    }
    private void resize(int capacity) {
        int n = itemsArray.length;
        int first = (((nextFirst + 1) % n) + n) % n;
        int last = (((nextLast - 1) % n) + n) % n;
        Type[] newArray = (Type[]) new Object[capacity];
        if (first < last) {
         System.arraycopy(itemsArray,first,newArray,0,size);
        } else {
            // len from first to end, ie the second part of the array
            int x = size - first;
            System.arraycopy(itemsArray,first,newArray,0,x);
            System.arraycopy(itemsArray,0,newArray, x,last + 1);
        }
        // reset the indexes of nextFirst and nextLast
        nextLast = n;
        nextFirst = newArray.length - 1;
        itemsArray = newArray;
    }
    @Override
    // Change last index and size
    public Type removeLast() {
        if (size == 0) {
            return null;
        }
        int n = itemsArray.length;
       /* if (n > 8 && (size < n / 4 )) {
            resize(n / 4 );
        }*/
        int pos = (((nextLast - 1) % n) + n) % n;
        Type removed = itemsArray[pos];
        itemsArray[pos] = null;
        nextLast = pos;
        size--;
        return removed;
    }
    @Override
    public Type removeFirst() {
        if (size == 0) {
            return null;
        }
        int n = itemsArray.length;
        /*if (n > 8 && (size < n / 4 )) {
            resize(n / 4 );
        }*/
        int pos = (((nextFirst + 1) % n) + n) % n;
        Type removed = itemsArray[pos];
        itemsArray[pos] = null;
        nextFirst = pos;
        size--;
        return removed;
    }
    @Override
    public Type get(int x) {
        if (x < 0 || x >= size) {
            return null;
        }
        int n = itemsArray.length;
        int first = (((nextFirst + 1) % n) + n) % n;
        int pos = (((first + x) % n) + n) % n;
        return  itemsArray[pos];
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public void printDeque(){
        int n = itemsArray.length;
        int first = (((nextFirst + 1) % n) + n) % n;
        int last = (((nextLast - 1) % n) + n) % n;
        for (int i = first; i != last; i ++) {
            if (i >= n) {
                i = (((i) % n) + n) % n;
            }
            System.out.print(itemsArray[i] + " ");
        }
        System.out.print(itemsArray[last]);
        System.out.println();
    }
}