
/*
Extremes
Given an array, count how many elements in the array are 
equal to the maximal or to the minimal value of the array.

Input
The first line of the input contains T: 
the number of test cases. T test cases follow.

Each test case is a line containing N: the number of
elements in the array, followed by N integers: the elements of the array.

Output
For each test case, output one line containing Case #x: y, 
where x is the test case number (starting from 1), and y is 
the number of elements in the array which are equal to the maximal or to the minimal value of the array.

*/


import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class extremes {

    //for testing
    static Integer[] num = { 2, 4, 7, 5, 9 };
    static int[] num2 = { 10, 4, 27, 6, 14, 4, 7, 12, 27, 11 };

    /* Function to sort array using insertion sort */
    public static int[] sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /*
             * Move elements of arr[0..i-1], that are
             * greater than key, to one position ahead
             * of their current position
             */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public static int min(int[] array) {

        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
        // int min = Collections.min(Arrays.asList(num));
        // return min;
    }

    public static int max(int[] array) {
        int max = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;

        // int max = Collections.max(Arrays.asList(num));
        // return max;
    }

    public static int countFreq(int arr[]) {
        // boolean visited[] = new boolean[n];
        int[] sortedArray = sort(arr);
        int n = sortedArray.length;
        int max_num = max(sortedArray);
        int min_num = min(sortedArray);

        int res = 0;
        for (int i = 0; i < n; i++)
            if (max_num == sortedArray[i] || min_num == sortedArray[i])
                res++;
        return res;

    }

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void main(String[] args) {
    

        Scanner scan = new Scanner(System.in);

        int num_tests = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= num_tests; i++) {
            int nums = scan.nextInt();
            
            int[] user_input = new int[nums];

            for (int j = 0; j <= nums - 1; j++) {
                user_input[j] = scan.nextInt();
            }
        
            System.out.printf("Case #%d: %s\n", i, countFreq(user_input));

            // \n creates a new line

        }

        scan.close();




    return;

}

}

