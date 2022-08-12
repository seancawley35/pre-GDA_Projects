import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;


/** Starter code for the Anagrams problem. */
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // The first number is the number of test cases.
    int numTests = in.nextInt();

    // Read in the next line, which is the comma-separated list of words to put in the anagram
    // grouper. Create an AnagramGrouper for this list of words.
    String[] words = in.next().split(",");
    String[] test_words = {"eat","tea","tan","ate","nat","bat"};
    AnagramGrouper anagrams = new AnagramGrouper(words);
    //anagrams.AnagramGrouper(words);
    //System.out.println(anagrams.AnagramGrouper(test_words));

    // For each test case, read in the word and print how many anagrams it has.
    for (int i = 1; i <= numTests; i++) {
      String word = in.next();
      System.out.printf("Case #%d: %d\n", i, anagrams.getNumberOfAnagrams(word));
    }

    in.close();
  }

  /**
   * Takes a list of words and groups them into anagram groups. An anagram group is a set in which
   * all words are anagrams of each other. For example, "tan, ant, nat" is an anagram group.
   */
  public static class AnagramGrouper {

    HashMap<String,List<String>> anagramMap;

    /** Constructs an AnagramGrouper from the given array of Strings. */
    public AnagramGrouper(String[] words) {
      // TODO: Create a map where the value is a set of words that are anagrams of each other, and
      // the key is the letters of those words alphabetized. Populate it with the given words.
      anagramMap = new HashMap<>();
      for (String s: words){
          String newKey = createKey(s);
          if (!anagramMap.containsKey(newKey)) 
            anagramMap.put(newKey, new ArrayList());
          // save to temp variable
          List<String> wordValues = anagramMap.get(newKey); 
          // check if already in array
          if(!wordValues.contains(s)){
            wordValues.add(s);
          }
      }

      // map = {"aab" : ["baa", "aab", "aba"],
      //  "cde" : ["cde", "dec", "ced"]}

      // map.get("aab") => array ["baa", "aab", "aba"]

      // insert "aba" into hashmap
      // -> sort("aba") => "aab"
      // map.containsKey("aab") => true
      // map.get("aab") => wordArray = ["baa", "aab", "aba"]
      // wordArray.contains("aba") => true
    
     
      

    }

    /**
     * Given a string word, return the number of valid anagrams it has. An anagram is valid if it
     * appears in this AnagramGrouper.
     */
    public int getNumberOfAnagrams(String word) {
      // TODO: implement this function
      char tempArray[] = word.toCharArray();
      // Sorting temp array using
      Arrays.sort(tempArray);
      String sortedWord = new String(tempArray);
      if(anagramMap.containsKey(sortedWord)){
        int anagramCount = anagramMap.get(sortedWord).size();
        return anagramCount;
      }
      return 0;
    }

    /**
     * Creates a key for the given word. The key is a string consisting of the letters in the word
     * in alphabetical order.
     */
    private String createKey(String s) {
      char[] letters = s.toCharArray();
      Arrays.sort(letters);
      return new String(letters);
    }
  }
}
