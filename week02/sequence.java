/*
A sequence of Numbers
A002024 is a sequence of numbers, where every natural number K appears K times:
1 2 2 3 3 3 ...

Given the number N, output the first N numbers in this sequence.

Input
The input contains exatly one number N.

Output
Output a single line containing N numbers: the first N elements of the A002024 sequence.
*/

import java.util.Scanner;
import java.lang.Math;


public class Solution {
    public static void main(String[] args) {
    // Display message for better readability
    //System.out.println("enter input ");
    // Creating an object of Scanner class
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();



    
    //System.out.println(" "); 

    // for loop to go through numbers in
    //range given by the user
    for(int i = 0; i<n; i++){
        //double tmp = Math.sqrt(2*i)+(1/2);
        //Integer inverse function to help solve sequuence
        double tmp = (1+Math.sqrt(1+(8*i)))/2;
        int k = (int)Math.floor(tmp);
        System.out.print(k + " ");
    }

  }
}
