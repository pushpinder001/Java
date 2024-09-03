package collection.learning;

import java.util.Arrays;

public class StringLearning {
    public static void main(String[] args) {
        String s = "This is my string";

        //String join method
        String s3 = String.join(" ", s, "this is appended string");
        System.out.println(s3);

        //String split method
        String[] splits = s3.split(" ");
        System.out.println("Result of string splits method " + Arrays.toString(splits));

        String s4 = s3.concat(" another string");
        System.out.println("String concat method result [" + s4 + "]");

        //Get reversed string
        System.out.println(getReversedString(s4));

        //Uppercase
        System.out.println(s4.toUpperCase());

        //get Char
        System.out.println(s4.charAt(2));

        //index of
        System.out.println(s4.indexOf(' '));

        //index of with fromIndex
        System.out.println(s4.indexOf( ' ', 5));

        //index of with lastIndexOf
        System.out.println(s4.lastIndexOf( ' '));

        //substring
        System.out.println(s4.substring(s4.indexOf(' ')+1, s4.indexOf(' ', s4.indexOf(' ')+1)));

    }

    public static String getReversedString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
