/*
Reverse
Write a function that takes a string 
and reverses every word in it. Reversed word is a word which is written from back to front.

Input
The first line of the input contains T: the number of test cases. T test cases follow.

Each test case is a line containing one or more words. Every word is a sequence 
of small latin characters. The words are separated by a single space character.

Output
For each test case, 
output one line containing Case #x: S, 
where x is the test case number (starting from 1), and S is the corresponding string with all words reversed.

*/



import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class Solution {

    public static String reversedWords(String x) {

        if (x == null || x.isEmpty()) {
            return x;
        }

        StringBuilder wordResults = new StringBuilder();
        String[] words = x.split(" ");

        for (int i = 0; i < words.length; i++) {
            wordResults.append(reversed(words[i]));
            if (i != words.length - 1) {
                wordResults.append(" ");
            }
        }
        return wordResults.toString();

    }

    public static String reversed(String y) {
        return new StringBuilder(y).reverse().toString();
    }

    // static int[] input_words;

    public static void main(String[] args) {
        // Creating an object of Scanner class
        Scanner sc = new Scanner(System.in);
        int test_nums = sc.nextInt();
        int test_counter = 0;
        while (test_counter <= test_nums) {
            String nextLine = sc.nextLine();
            String[] nextLineWords = nextLine.split(" ");
            if (test_counter == 0) {
                test_counter++;
                continue;
            }
            
            String str = String.join(" ", nextLineWords);
            System.out.println("Case #" + (test_counter) + ": " + reversedWords(str));
            
            test_counter++;
        }
        

        

        return;

    }

}
