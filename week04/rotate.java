/*

Rotate
Right rotation of an array means 
rotating the array elements towards the end of the array, 
putting the last element at the beginning of the array. For example:

Original array: 1 2 3 4 5.

Original array rotated right: 5 1 2 3 4 (the first element went to 
the second position, the second element -- to the third position, ..., the last element went to the first position).

Original array rotated right two times: 4 5 1 2 3.

Write a function that performs right rotation of an array the given number of times.

Tip: The TL verdict means that the solution needs too much time to solve the task.
If you are getting this verdict, consider making the solution more efficient. Some 
rotations can be skipped, because rotating an array of size N N times does not change the array.

Input
The first line of the input contains T: the number of test cases. T test cases follow.

Each test case is a line containing R: the number of right rotations to perform, N: 
the size of the array, and N integers: the elements of the array.

Output
For each test case, output one line containing Case #x: A1...An,
where x is the test case number (starting from 1), and A1...An are the elements of the array after rotation.
*/




import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
// Java Program to Rotating Elements One by One

// Main class
class Solution {


    public static void rotate(int[] nums, int k) {

        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {

        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

	// Method 3
	// To print an array
	public static void printArray(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}


	public static void main(String[] args) {

		// Custom input elements
		//int arr[] = { 1, 2, 3, 4, 5 };
		// int i, x;
		//int newArray[] = Arrays.copyOfRange(arr, 2, arr.length);
		//Rotate.printArray(newArray, newArray.length);
		// System.out.println(" ");

		// Calling method 1 and 2
		// System.out.println(" ");
		// System.out.println("Test Test1");
		// System.out.println(" ");
		// Rotate.rightRotate(arr, 2, arr.length);
		// Rotate.printArray(arr, arr.length);
		// System.out.println(" ");
		// System.out.println("Test Test2");
		// System.out.println(" ");
		// Rotate.rightRotate(newArray, 1, newArray.length);
		// Rotate.printArray(newArray, newArray.length);
		// System.out.println(" ");

		// Creating an object of Scanner class
		Scanner sc = new Scanner(System.in);
		// number of test cases
		int num_tests = sc.nextInt();
		//System.out.println("Number of tests = " + num_tests);

		int test_case = 0;

		while (test_case < num_tests) {
            int numRotations = sc.nextInt();
            int arraySize = sc.nextInt();
			// Create array user input
			int[] input_point_values = new int[arraySize];
            // if (numRotations >= 1000000)
            // {
            //     System.out.println("numRotation:" + numRotations);
            // }
			// input user's numbers into each array
			for (int i = 0; i < input_point_values.length; i++) {
				input_point_values[i] = sc.nextInt();
				// System.out.print(input_point_values[i] + "\n");
			}
			
			
            //Solution.rightRotate(input_point_values, numRotations, arraySize);
            Solution.rotate(input_point_values, numRotations);
            //Collections.rotate(Arrays.asList(input_point_values), numRotations);
			System.out.print("Case #" + (test_case + 1) + ": " );
			Solution.printArray(input_point_values, input_point_values.length);
			System.out.println("");
			test_case++;
		}

		return;

	}

}
