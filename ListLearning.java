package collection.learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListLearning {
    public static void main(String[] args) {
        //Creating a mutable list
        //List.of return a immutable list
        List<String> l = new ArrayList<>(List.of("My", "Name", "Is", "Pushpinder"));

        l.sort(null);
        System.out.printf("List after natural sorting order is %s%n", l);

        l.sort(Comparator.comparing(String::length).thenComparing(s-> s.toString()));

        System.out.printf("List after passing custom comparator is %s%n", l);

        l.replaceAll(String::toUpperCase);
        System.out.println("String after applying urinary operator " + l);

        //Swap element in list
        Collections.swap(l, 0, l.size()-1);
        System.out.println("List after swapping list element at 1st and last index " + l);

        //Rotate list by 2 position
        Collections.rotate(l, -2);
        System.out.println("List after rotating list element at -2 pos " + l);

        //Adding test value in list if string is of length 2
        var it = l.listIterator(l.size());

        while(it.hasPrevious()) {
            var previous = it.previous();
            if(previous.length()==2) {
                it.add("Test");
            }
        }
        System.out.println("Adding Test element in list before strings of len 2 " + l);

        l.removeIf(s->s.length()<3);
        System.out.println("String after applying remove if " + l);


    }
}
