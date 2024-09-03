package collection.learning;

import java.util.*;

public class SetLearning {
    record Booked(Integer id, Boolean isBooked) { }

    public static void main(String[] args) {
        //Set Learning first, last, pollFirst, pollLast
        NavigableSet<String> set = new TreeSet<>(List.of("BHey", "ZMy", "AName", "KIs", "Pushpinder"));
        String element = "KIs";

        String first = set.first();
        String last = set.last();

        System.out.printf("Sets first element [%s] last element [%s] and set %s%n", first, last, set);

        String firstPoll = set.pollFirst();
        String lastPoll = set.pollLast();


        System.out.printf("Sets first element [%s] last element [%s] and set %s%n", firstPoll, lastPoll, set);
        set.add(firstPoll);
        set.add(lastPoll);

        //Set Learning floor, ceil, lower, high
        String floor = set.floor("KIs");
        String ceil = set.ceiling("KIs");

        System.out.printf("Sets element KIs floor [%s] ceil [%s] and set %s%n", floor, ceil, set);

        String lower = set.lower("KIs");
        String higher = set.higher("KIs");
        System.out.printf("Sets element KIs lower [%s] higher [%s] and set %s%n", lower, higher, set);

        NavigableSet<String> descendingSet = set.descendingSet();
        System.out.printf("Descending Set %s%n", descendingSet);

        Set<String> headSet = set.headSet(element, true);
        System.out.printf("Head Set with element %s %s%n", element, headSet);

        NavigableSet<String> tailSet = set.tailSet(element, true);
        tailSet.add("test");
        System.out.printf("Tail Set with element %s %s%n", element, tailSet);
        System.out.printf("Original Set %s%n", set);

        //Sets union , intersection, diff
        Set<Integer> s1 = new TreeSet<>(List.of(1, 2, 3, 4, 5));
        Set<Integer> s2 = new TreeSet<>(List.of(4, 5, 6, 7, 8));

        NavigableSet<Integer> s1UnionS2 = new TreeSet<>(s1);
        s1UnionS2.addAll(s2);

        System.out.printf("S1 U S2 %s%n", s1UnionS2);

        Set<Integer> s1IntersectionS2 = new TreeSet<>(s1);
        s1IntersectionS2.retainAll(s2);

        System.out.printf("S1 IN S2 %s%n", s1IntersectionS2);

        Set<Integer> s1DiffS2 = new TreeSet<>(s1);
        s1DiffS2.removeAll(s2);

        System.out.printf("S1 - S2 %s%n", s1DiffS2);

        NavigableSet<Integer> subset = s1UnionS2.subSet(3, true, 8, true);
        System.out.printf("Subset %s%n", subset);

        List<Booked> bookingList = List.of(new Booked(1, true),
                new Booked(2, true), new Booked(3, true), new Booked(4, false), new Booked(5, false));
        NavigableSet<Booked> nSet = new TreeSet<>(Comparator.comparing(Booked::hashCode));
        nSet.addAll(bookingList);

        Set<Booked> maxTrueSet = returnMaxTrueBoolSubset(nSet);
        System.out.println("Max True Set" + maxTrueSet);
    }


    public static Set<Booked> returnMaxTrueBoolSubset(NavigableSet<Booked> navigableSet) {
        int curMaxLen=0;
        Booked head=null;
        Set<Booked> result = Set.of();

        for(var it : navigableSet) {
            if(!it.isBooked) { // Boolean value is false
                head = null;
                curMaxLen=0;
                continue;
            }

            if(head == null) {
                head = it;
            }

            curMaxLen++;
            if(curMaxLen > result.size()) {
                result = navigableSet.subSet(head, true, it, true);
            }
        }

        return result;
    }
}
