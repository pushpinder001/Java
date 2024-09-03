package collection.learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsLearning {
    public static void main(String[] args) {
        //nCopies create Ncopies object which is immutable
        List<Integer> l = new ArrayList<>(Collections.nCopies(5, 1));
        l.add(2);
        //System.out.println(l.getClass().getSimpleName());
        System.out.println(l);

        //Returns true
        System.out.println(l.get(0)==l.get(1));

        //Reverse a list in java
        Collections.reverse(l);
        System.out.println("Reversed list " + l);

        //Shuffle list
        Collections.shuffle(l);
        System.out.println("Shuffled list " + l);

        //Collections sort method is also internally calling list method, null mean used natural sort from comparable
        l.sort(null);
        System.out.println("Sorted list " + l);

        //Binary Search
        int element = 3;
        //Binary Search return index
        int ids = Collections.binarySearch(l, element);
        System.out.printf("The binary search on list %s for element %d result is %d%n", l, element, ids);


        //Swapping list element
        Collections.swap(l, 0, l.size()-1);
        System.out.println(l);

        //Max and min methods
        int max = Collections.max(l);
        int min = Collections.min(l);
        System.out.printf("The max element %d min element %d and list is %s%n", max, min, l);

        //Rotate in clockwise
        Collections.rotate(l, 2);
        System.out.printf("The list after rotating by 2 positions is %s%n", l);
    }
}
