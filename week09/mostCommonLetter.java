// Java program to count frequencies of
// characters in string using Hashmap
import java.io.*;
import java.util.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

class mostCommonLetter {
	public static Character characterCount(String inputString)
	{
		// Creating a HashMap containing char
		// as a key and occurrences as a value
		LinkedHashMap<Character, Integer> charCountMap
			= new LinkedHashMap<Character, Integer>();

		// Converting given string to char array

		char[] strArray = inputString.toCharArray();

		// checking each char of strArray
		for (char c : strArray) {
			if (charCountMap.containsKey(c)) {

				// If char is present in charCountMap,
				// incrementing it's count by 1
				charCountMap.put(c, charCountMap.get(c) + 1);
			}
			else {

				// If char is not present in charCountMap,
				// putting this char to charCountMap with 1 as it's value
				charCountMap.put(c, 1);
			}
		}

	

        int maxValueInMap=(Collections.max(charCountMap.values()));
        ArrayList<Character> cars = new ArrayList<Character>();
        char new_entry;
        char final_result;

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {  // Itrate through hashmap
            if (entry.getValue()==maxValueInMap) {
                new_entry = entry.getKey();
                cars.add(new_entry);
            }
        }
     
        final_result = cars.get(0);
       
        return final_result;

        


	}

	// Driver Code
	public static void main(String[] args)
	{
		

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
            
            String str = String.join("", nextLineWords);
            System.out.println("Case #" + (test_counter) + ": " + characterCount(str));
            
            test_counter++;
        }
        

        

        return;
        
	}
}
