import java.util.Scanner;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import javax.naming.directory.InvalidAttributesException;
import java.util.*;
 
 
class StackUnderflowException extends RuntimeException {
    // no body is required
}

/** 
 * This is the Stack interface.
 * Do not modify it.
 */
interface Stack<T> {
    /**
     * After calling push, t is the top element of this Stack.
     */
    void push(T t);

    /**
     * peek returns the top element of this Stack, leaving the Stack unchanged,
     * or if the Stack is empty throws a StackUnderflowException.
     */
    T peek();
   
    /**
     * pop remove the top element of this Stack, and returns that element,
     * or if the Stack is empty throws a StackUnderflowException.
     */
    T pop();

    /**
     *
     * @return true iff (if and only if) this Stack is empty, else false.
     */
    boolean isEmpty();

    /**
     * return the size of this Stack.
     */
    int size();
}



/** 
* This interface just fixes the generic type T as String
* Do not modify it.
*/
interface StringStack extends Stack<String> {
    // no body is necessary, as this interface inherits all members of the Stack super-interface
    // but to make it easier to read, we've copied the method names, and added the
    // @Override annotation to show they override the super-interface methods.
    // See the Stack super-interface, above, for the documentation of what each method does.

    @Override
    void push(String s);

    @Override
    String peek();

    @Override
    String pop();

    @Override
    int size();
}

/**
 * Modify this StringStackImpl class, or write your own.
 */
class StringStackImpl implements StringStack {
     /**
      * Constructor: initilalizes a new StringStackImpl instance.
      */
     public LinkedList userList;
     //public LinkedList<String> newStack = new LinkedList<String>();
     public ArrayList<String> newList;
     //int size;
     public StringStackImpl() {
         // TODO
        //  this.newStack = null;
         //this.size = 0;
         this.newList = new ArrayList<>();
     }
     @Override
     public void push(String s) {
         this.newList.add(s);
     }

     @Override
     public String peek() {
        if (newList.isEmpty()){
            return null;
        }
         return this.newList.get(this.size()-1);
     }

     @Override
     public String pop() {
         if (newList.isEmpty()){
            //  return StackUnderflowException;
            return "error";
         }
         String ret = this.peek();
         this.newList.remove(this.size()-1);
         return ret;
     }

     @Override
     public int size() {
         return this.newList.size();
     }
     @Override
     public boolean isEmpty() {
         return this.size() == 0; // TODO
     }
}
 
public class Solution {
 
   /**
    * Instructions:
    *
    * Read lines from System.in until there are no more lines.
    *
    * For each line read, output "valid" or "invalid"
    *
    * Each line consists of arbitrary characters. You can ignore all characters that are not braces.
    *
    *  Braces include:
    *  "(", which is closed by ")"
    *  "[", which is closed by "]"
    *  "{", which is closed by "}"
    *  "<", which is closed by ">"
    *
    * Output valid if the braces on that line are correctly nested,
    * so that each open brace is closed by its corresponding closing brace,
    * and braces are nested "( ( () ) )", not interleaved: "( [ ) ]"
    *
    * For each line, output "valid" if every open symbol in the set "( [ { <"
    * it has a matching corresponding closing symbol ") ] } >", and they are not interleaved;
    * else output "invalid".
    *
    * i.e,
    * "()[]"" is valid,
    * "([])"" is valid,
    * "(cite[24]) is valid,
    *
    * but "([)]" and
    * "(" are invalid.
    *
    * You can implement this using a stack.
    * One possible implementation uses a StringStack; another uses a Stack<Integer>.
    *
    * Copy your StringStack implementation (or Stack<T> implementation)
    * from assignment 1 to here, and use it.
    *
    * One way to solve this is to write a function:
    *     public static boolean isValid(String line, String opens, String closes)
    * which takes a line of the input, and returns whether that line is balanced.
    *
    * Note that this method also takes two additional Strings, a list of open braces and a list of closed braces.
    *
    * It's helpful to be able to turn a String variable "line" into an array of char, which you can do with
    *s
    *      line.toCharArray()
    */
    
  
   /**
    * Exercise your Stack
    * Read lines from System.in
    * For each line, output "valid" for every open symbol in the set "( [ { <"
    * it has a matching closing symbol ") ] } >", and they are not interleaved,
    * else output "invalid".
    *
    * i.e, "()[]"" is valid, "([])"" is valid, "(cite[24]) is valid,
    * but "([)]" and "(" are invalid
    *
    */
   public static void main(String[] args) {
       String openBrackets = "{[(";
       String closedBrackets = "}])";
 
       try (Scanner in = new Scanner(System.in)) {
           while (in.hasNextLine()) {
               // TODO
               String bracket = in.nextLine();
               if (isValid(bracket)){
                   System.out.println("valid");
               }
               else{
                   System.out.println("invalid");
               }
               //System.out.println("--------------------------------");
           }
       }
       return;
   }

    // function to check if brackets are balanced
	static boolean isValid(String entry)
	{
		
		Deque<Character> charStack
			= new ArrayDeque<Character>();

		
		for (int i = 0; i < entry.length(); i++)
		{
			char openBracket = entry.charAt(i);

			if (openBracket == '(' || openBracket == '[' || openBracket == '{')
			{
				// Push the element in the stack
				charStack.push(openBracket);
				continue;
			}

			
			if (charStack.isEmpty())
				return false;
			char check;
			switch (openBracket) {
			case ')':
				check = charStack.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = charStack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = charStack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}

		
		return (charStack.isEmpty());
	}
}
