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
