package deque;

import java.util.Comparator;

public class MaxArrayDeque<Type> extends ArrayDeque<Type>{
    Comparator <Type> defaultComparator;
    public MaxArrayDeque(Comparator<Type> c) {
        defaultComparator = c;
    }
    // uses the default comparator given in the constructor
    public Type max() {
        // write out the logic that iterates through the array using the default comparator's compare method
        return null;
    }
    // uses the comparator given in the argument
    public Type max(Comparator<Type> c) {
        // write out the logic that iterates through the array using the superclass methods
        // and use the comparator's compare method
        return null;
    }
}

// make additional comparators classes for different types

