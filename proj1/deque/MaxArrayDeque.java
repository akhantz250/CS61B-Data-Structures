package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> defaultComparator;

    public MaxArrayDeque(Comparator<T> c) {
        defaultComparator = c;
    }

    // uses the default comparator given in the constructor
    public T max() {
        // write out the logic that iterates through the array using the default comparator's compare method
        return max(defaultComparator);
    }

    // uses the comparator given in the argument
    public T max(Comparator<T> c) {
        // write out the logic that iterates through the array using the superclass methods
        // and use the comparator's compare method
        T maxElement = this.get(0);
        for (int i = 0; i < this.size(); i++) {
            T currentElement = this.get(i);
            if (c.compare(currentElement, maxElement) > 0) {
                maxElement = currentElement;
            }
        }
        return maxElement;
    }
}

