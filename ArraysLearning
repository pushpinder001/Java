package collection.learning;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Note:: I have a habit of declaring java arrays in c lang type
 */
public class ArraysLearning {
    public static void main(String[] args) {
        //First way of initializing
        Integer[] a = new Integer[]{1, 4, 2, 5};

        //Second way of initializing
        int[] b = {1, 2, 3};

        //Third way of initializing
        int[] c = new int[5];
        Arrays.fill(c, 5);

        //Printing arrays
        System.out.println(Arrays.toString(c));


        int[][] d = {{1,2}};
        //This will print ref
        System.out.println(Arrays.toString(d));
        //This will print val
        System.out.println(Arrays.deepToString(d));

        //natural sorting order
//        Arrays.sort(a);
//        System.out.println(Arrays.toString(a));

        //Custom comparator
        Arrays.sort(a, Comparator.comparing(Integer::intValue).reversed());
        System.out.println("A array after sorting " + Arrays.toString(a));

        //Arrays.asList returns list backed by array
        //Also we can use replaceAll method to replace all elements of array quickly
        Arrays.asList(a).replaceAll(i -> i+1);
        System.out.println("A array after converting it to list and using list replace all method " + Arrays.toString(a));

        Arrays.setAll(a, idx-> a[idx]+1);
        System.out.println("A array after using set all method " + Arrays.toString(a));

    }
}
