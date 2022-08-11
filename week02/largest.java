import java.util.Scanner;


public class largest {


    static int[] user_nums;

       
    public static int greatest(){
        // Initialize maximum element
        int x;
        int max = user_nums[0];
        
        // Traverse array elements from second and
        // compare every element with current max  
        for (x = 1; x < user_nums.length; x++)
            if (user_nums[x] > max)
                max = user_nums[x];
        
        return max;
    
    }


    public static void main(String[] args) {

        // Creating an object of Scanner class
        Scanner sc = new Scanner(System.in);
        int array_size = sc.nextInt();

        // String line = sc.nextLine();
        // String[] tokens = line.split(" ");
        user_nums = new int[array_size];
        for (int i=0; i < array_size; i++) {
            user_nums[i] = sc.nextInt();
        }
        
        System.out.println(greatest());

    }
    
}




