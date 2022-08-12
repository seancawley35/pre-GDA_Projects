// Java program to count frequencies of
// characters in string using Hashmap
import java.io.*;
import java.util.*;

class twoSum {

    public static boolean getTwoSum(int[] numbers, int target) {
        Set<Integer> numbersMap = new HashSet<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (numsMap.contains(complement)) {
                return true;
            } else {
                numbersMap.add(numbers[i]);
                
            }
        }
        return false;
    }

    


	

	// Driver Code
	public static void main(String[] args)
	{
        

        Scanner in = new Scanner(System.in);
        int numTests = in.nextInt();
       

        for (int i = 1; i <= numTests; i++) {
            int target = in.nextInt();
            String[] stringNums = in.nextLine().trim().split(",");
            int[] nums = new int[stringNums.length];
            for(int j = 0; j < stringNums.length; ++j) {
                nums[j] = Integer.valueOf(stringNums[j]);
            }
            System.out.println("Case #" + i + ": " + getTwoSum(nums, target));
		

     
        }
        
        return;
        
	}
}
