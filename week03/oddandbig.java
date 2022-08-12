/*
Odd and Big
Write a function that takes three numbers and returns true if and only if all three numbers are odd and greater than 10. Do so by writing a helper function that determines whether a single number is odd and greater than 10. Call this function for every test case from the main function.

Input
The first line of the input contains T: the number of test cases. T test cases follow.

Each test case is a line containing three numbers: the numbers that should be checked.

Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1), and y is either Yes or No.

*/


import java.util.Scanner;


public class oddandbig {


    static int[] user_nums;
    static int test_cases;



    public static boolean perfect_number(int input_num) {
        int min_num = 10;
        // at least 10
        // must be odd
        // if both <=10 and NOT odd -> 
        if (input_num <= min_num || input_num % 2 == 0)
        {
         return false;
        }
        // else ->
        return true;
    }

    public static boolean perfect_match(){
        // Initialize int element and min_num 
        int x;
        //int max = user_nums[0];
        //int min_num = 10;
        
        // Traverse array elements starting at 
        // the first int in the array
        for (x = 0; x < user_nums.length; x++)
            //compare the int to check it is > 10 and odd
            if (!perfect_number(user_nums[x])){
                return false;
            }
        return true;
        //     if (user_nums[x] <= min_num || user_nums[x] % 2 == 0)
        //     {
        //      return false;
        //     }
        
        // return true;
    
    }


    public static void main(String[] args) {
        int y = 0;
        //System.out.println("Input number of arrays");
        // Creating an object of Scanner class
        Scanner sc = new Scanner(System.in);
        //create number of arrays for input
        int test_size = sc.nextInt();
        //System.out.println("Number of arrays = " + test_size);
        //
        int array_size = 3;
        //System.out.println("Array size = " + array_size);
        

        // test_cases = test_size;
        user_nums = new int[array_size];
      

        // create number of arrays based on user input
        while (y < test_size) {
            // input user's 3 numbers into each array
            for (int i=0; i < array_size; i++) {
                user_nums[i] = sc.nextInt();
            }
            //System.out.println("Case #" + (y+1) +":");
            if(perfect_match()) {
                System.out.println("Case #" + (y+1) +": Yes");
                }
            else {    
            System.out.println("Case #" + (y+1) +": No");
            }
            y++;

        }
        //System.out.println("All Done");

    }
    
}
