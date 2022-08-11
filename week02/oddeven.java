/*
Given an integer number, output Odd if it is odd, or Even if it is even.

Input
The input contains exatly one number N.

Output
Output one a single line containing Odd or Even.

*/


import java.util.Scanner;


public class oddeven {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    

        // This method reads the number provided by user input
        int user_num = scan.nextInt();

        // exit scanner after use
        scan.close();

     
        String response = user_num % 2 == 0 ? "Even" : "Odd";
        System.out.println(response);


    }
}
