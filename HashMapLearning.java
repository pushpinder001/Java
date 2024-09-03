package collection.learning;

import java.util.*;

public class HashMapLearning {
    public static void main(String[] args) {
        //Map static method for initialization which will create immutable map
        NavigableMap<String, List<String>>  m1, m2, m3;

        m1 = new TreeMap<>();
        m2 = new TreeMap<>();

        m1.put("k1", new ArrayList<>(List.of("v1")));
        m1.put("k2", new ArrayList<>(List.of("v2")));

        m2.put("k3", new ArrayList<>(List.of("v3")));
        m2.put("k2", new ArrayList<>(List.of("v4")));

        //merge method
        m3 = new TreeMap<>(m1);
        m2.forEach((k, v) -> {
            m3.merge(k, v, (v1, v2) ->
            {v1.addAll(v2); return v1;});
        });

        System.out.println(m3);

        System.out.println("-".repeat(30));

        System.out.println(m2);


        //getOrDefault
        System.out.println("Get Or Default " + m3.getOrDefault("k4", List.of("Default") ));

        //entries
        System.out.println("Entries " + m3.entrySet());

        //keys
        System.out.println("Keys " + m3.keySet());

        //values
        System.out.println("values " + m3.values());

        //floor
        String floorKey = m3.floorKey("k2");

        //ceiling
        String ceilingKey = m3.ceilingKey("k2");


        //lower
        String lowerKey = m3.lowerKey("k2");

        //higher
        String higherKey = m3.higherKey("k2");

        System.out.printf("Lower Key [%s] Floor Key [%s] Higher Key [%s] Ceiling Key [%s]%n",
                lowerKey, floorKey, higherKey, ceilingKey);

        //higherEntry
        NavigableMap.Entry<String, List<String>> higherEntry = m3.higherEntry("k2");
        System.out.println("Higher Entry k2 " + higherEntry);

        //Desc Map
        var descMap = m3.descendingMap();
        System.out.println("Map m3 " + m3);
        System.out.println("Desc Map m3" + descMap);

        //First
        var first = m3.firstEntry();
        System.out.printf("First entry key %s entry value %s%n", first.getKey(), first.getValue());

        //PollLastEntry
        var lastPollEntry = m3.pollLastEntry();
        System.out.printf("Polled last entry %s and now map m3 is %s%n", lastPollEntry, m3);

        //Adding polled entry back
        m3.put(lastPollEntry.getKey(), lastPollEntry.getValue());

        //headMap
        var headMap = m3.headMap("k2", true);
        System.out.println("Head Map with k2 key " + headMap);

        //SubMap
        var subMap = m3.subMap("k2", true, "k3", true);
        System.out.println("Sub Map with k2, k3 keys inclusive " + subMap);

        //Replace All
        m3.replaceAll((k, v)-> {v.add("Test"); return v;});
        System.out.println("Replace all collection result " + m3);

        //Put If Absent
        m3.putIfAbsent("k4", new ArrayList<>(List.of("v10")));
        System.out.println("Map m3 after put if absent method " + m3);

        //Compute (for updating a single value in map) if null is return then value is removed
        //throw nullpointer exception is value is not present
        m3.compute("k4", (k, v)-> {v.add("v12"); return v;});
        System.out.println(m3);

        //Compute if present
        //Skip the key if value is not present
        m3.computeIfPresent("k5", (k, v)-> {v.add("v15"); return null;});
        System.out.println(m3);

       //Compute if absent run the function in 2nd arg only if the key is not present in map
        m3.computeIfAbsent("k40", k-> new ArrayList<>(List.of("v110")));
        System.out.println(m3);
    }
}
