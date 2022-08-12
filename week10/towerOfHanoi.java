import java.io.*;
import java.util.*;
//import java.math.*;
import java.util.Optional;
import java.util.Scanner;


  
public class towerofHanoi {
   public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int testCases = Integer.parseInt(in.next());
       for (int i=1; i < testCases + 1;++i ){
           int diskCount = Integer.parseInt(in.next());
           System.out.println("Case #" + i + ": " );
           hanoi(diskCount, 1, 3, 2);
       }
           
   }
   public static void hanoiTower(int diskCount, int source, int dest, int aux){
       if (diskCount < 1){
            return;
       }
       hanoiTower(diskCount - 1, source, aux, dest);
       System.out.println(source + " " + dest);
       hanoiTower(diskCount - 1, aux, dest, source);

   }


}
