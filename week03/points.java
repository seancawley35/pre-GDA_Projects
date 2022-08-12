/*

Points
Define class Point, representing a point on the 2-dimensional plane. 
The class should contain two fields, representing the coordinates of these points: x and y.

Define a function that takes two Point objects (with x, y coordinates) and 
returns whichever one is closest to the origin. Do so by defining a method in the Point class that computes the distance to the origin.

Input
The first line of the input contains T: the number of test cases. T test cases follow.

Each test case is a line containing four integer numbers: the x coorinate of the first point, 
followed by the y coordinate of the first point, followed by the x coorinate of the second point, followed by the y coordinate of the second point.

Output
For each test case, output one line containing Case #t: x y, where t is the test case 
number (starting from 1), and x and y are the coordinates of the point closes to the origin.

*/

import java.util.Scanner;


class Solution {

    static class Point {

        int x;
        
        int y;
        // origin
        int origin_x = 0;
        int origin_y = 0;

        // Constructor 
        Point(int x ,int y) {
            this.x = x;
            this.y = y;
        }

        public double distance_to_origin()
        {
            // Calculating distance
            return Math.sqrt(Math.pow(this.x - this.origin_x, 2)
                            + Math.pow(this.y - this.origin_y, 2) * 1.0);
        }
    }

    static int[] input_point_values;


    // method to return which point is closer
    public static Point closet_to_origin(Point point1, Point point2)
    {
        if (point1.distance_to_origin() < point2.distance_to_origin()) {
            return point1;
        }
        return point2;
    }

    public static void main(String[] args) {
        // Creating an object of Scanner class
        Scanner sc = new Scanner(System.in);
        // number of test cases
        int num_tests = sc.nextInt();
        //System.out.println("Number of tests = " + num_tests);

        int test_case = 0;
        while (test_case < num_tests) {
            // Scanner sc_point = new Scanner(System.in);
            // Create array for two points
            input_point_values = new int[4];
            // input user's numbers into each array
            for (int i=0; i < 4; i++) {
                input_point_values[i] = sc.nextInt();
                //System.out.print(input_point_values[i] + "\n");
            }

            Point [] test_array = new Point[2];
            // Traverse array elements starting at 
            // the first int in the array and go two elements at a time
            int point_counter = 0;
            for (int j = 0; j < input_point_values.length; j+=2){
            //store the elements and input them to closet_to_origin
                Point point = new Point(input_point_values[j],input_point_values[j+1]);
                test_array[point_counter] = point;
                point_counter++;
                
            }
            
            Point result = closet_to_origin(test_array[0], test_array[1]);
            System.out.println("Case #" + (test_case+1) + ": " + result.x + " "+ result.y);
            test_case++;
        }

        return;

    }
    
}
