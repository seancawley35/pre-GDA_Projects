import java.util.Scanner;


public class order {
    public static void main(String[] args) {
    

    
 
       // Creating an object of Scanner class
       Scanner sc = new Scanner(System.in);



       // Declaring and initializing an array of size 3
       int[] user_nums = new int[3];
       int p;

       
       int n = user_nums.length;

       // place input values in user_nums array
       for (p = 0; p < user_nums.length; p++) {
           user_nums[p] = sc.nextInt();
       }

  

        //insertion sort solution 
        for (int i = 1; i < n; ++i) {
            int key = user_nums[i];
             int j = i - 1;
    
            /* Nested while loop to help sort numbers*/
            while (j >= 0 && user_nums[j] > key) {
                user_nums[j + 1] = user_nums[j];
                j = j - 1;
                }
            user_nums[j + 1] = key;
            }
        
        //print out new sorted list  
        for (p = 0; p < user_nums.length; p++) {
            System.out.print(user_nums[p] + " ");
        }  


        }


    }
