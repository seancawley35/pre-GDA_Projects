/*

Points
Define a class for a 2D point (as x and y coordinates), a segment (as two points), a triangle 
(as three points), a rectangle with sides parallel to the coordinate axes (as its diagonal segment: 
the segment going from the bottom left corner to the top right corner).

For the segment: implement a constructor from two points and a member function computing the length of the segment.

For the rectangle: implement member functions computing corner points of the rectangle 
(the bottom right and the top left, in addition to the ones contained in the segment).

For the triangle and the rectangle: implement member functions computing their area 
(Tip: use this formula for the triangle area) and their perimeters.

For the triangle: implement a member function to create a containing rectangle from a triangle (where containing rectangle is the minimal rectangle 
that fully contains the given triangle inside; its bottom left corner coordinates are the minimal coordinates of 
all triangle points coordinates, and its top right corner coordinates are the maximal coordinates of all triangle points coordinates).

Given coordinates of triangle points, output:

The triangle area
The triangle perimeter
The containing rectangle area
The containing rectangle perimeter
Input
The first line of the input contains T: the number of test cases. T test cases follow.

Each test case is a line containing six integer numbers: x1, y1, x2, y2, x3, and y3, where (xi,yi) are the coordinates of the i-th point of the triangle.

Output
For each test case, output one line containing Case #t: Ta Tp Ra Rp, where t is the test case number (starting from 1), Ta is the triangle area, Tp is the triangle perimeter, Ra is the containing rectangle area, Ra is the containing rectangle perimeter. All numbers must be output rounded to 2 decimal digits after the comma (using "%.2f" format string in System.out.printf.)

*/


import java.util.Scanner;

class shapes {

    // Define a class for a 2D point (as x and y coordinates), a segment (as two
    // points), a triangle (as three points),
    // a rectangle with sides parallel to the coordinate axes (as its diagonal
    // segment:
    // the segment going from the bottom left corner to the top right corner).

    static class Point {
        // x-coordinate
        float x_coord;
        // y-coordinate
        float y_coord;

        // Constructor
        Point(float x_coord, float y_coord) {
            this.x_coord = x_coord;
            this.y_coord = y_coord;

        }
    }

    static class Segment {

        Point point1;
        Point point2;

        // Constructor
        Segment(Point point1, Point point2) {

            this.point1 = point1;
            this.point2 = point2;

        }

        // compute length of the segment
        public float length() {
            // Calculate distance
            float length = (float) Math.sqrt(Math.pow((point2.x_coord-point1.x_coord),2) + 
                           Math.pow((point2.y_coord-point1.y_coord),2));
            return length;
        }
    }

    static class Triangle {
        Point point1;
        Point point2;
        Point point3;

        // Constructor
        Triangle(Point point1, Point point2, Point point3) {
            this.point1 = point1;
            this.point2 = point2;
            this.point3 = point3;

        }

        public float area() {
            // Calculate area using the determinant method
            float area = Math.abs(
            (point1.x_coord * (point2.y_coord - point3.y_coord)) 
            + (point2.x_coord * (point3.y_coord - point1.y_coord)) 
            + (point3.x_coord * (point1.y_coord - point2.y_coord))) / 2;
            return area;
        }

        public Rectangle containing_rectangle() {
            // Calculating containing rectangle
            float min_x = Math.min(Math.min(point1.x_coord, point2.x_coord), point3.x_coord);
            float min_y = Math.min(Math.min(point1.y_coord, point2.y_coord), point3.y_coord);
            float max_x = Math.max(Math.max(point1.x_coord, point2.x_coord), point3.x_coord);
            float max_y =Math.max(Math.max(point1.y_coord, point2.y_coord), point3.y_coord);
            Segment diagonal = new Segment(new Point(min_x,min_y), new Point(max_x,max_y));
            return new Rectangle(diagonal);
        }

        public float perimeter() {
            // Calculating triangle perimiter
            float perimeter = new Segment(point1,point2).length() +
                              new Segment(point2,point3).length() +
                              new Segment(point1,point3).length();
            return perimeter;
        }
    }

    static class Rectangle {
        Segment diagonal;

        // Constructor
        Rectangle(Segment diagonal) {
            this.diagonal = diagonal;
        }

        public Point bottom_left_point() {
            return diagonal.point1;
        }

        public Point bottom_right_point() {
            //
            float x_coord = top_right_point().x_coord;
            float y_coord = bottom_left_point().y_coord;
            return new Point(x_coord, y_coord);
        }

        public Point top_left_point() {
            //
            float x_coord = bottom_left_point().x_coord;
            float y_coord = top_right_point().y_coord;
            return new Point(x_coord, y_coord);
        }

        public Point top_right_point() {

            return diagonal.point2;
        }

        public float area() {
            //
            float length = top_right_point().x_coord - bottom_left_point().x_coord;
            float height = top_right_point().y_coord - bottom_left_point().y_coord;
            float area = length * height;
            return area;
        }

        public float perimeter() {
            //
            float length = top_right_point().x_coord - bottom_left_point().x_coord;
            float height = top_right_point().y_coord - bottom_left_point().y_coord;
            float perimeter = (2 * length) + (2 * height);
            return perimeter;
        }
    }

    public static void main(String[] args) {
         // Creating an object of Scanner class
         Scanner sc = new Scanner(System.in);
         int test_nums = sc.nextInt();
         sc.nextLine();
         int test_counter = 1; 
        while (test_counter <= test_nums) {
            String nextLine = sc.nextLine();
            String[] trianglePoints = nextLine.split(" ");
            Triangle t = new Triangle(new Point(Float.parseFloat(trianglePoints[0]),Float.parseFloat(trianglePoints[1])), 
            new Point(Float.parseFloat(trianglePoints[2]),Float.parseFloat(trianglePoints[3])),
            new Point(Float.parseFloat(trianglePoints[4]),Float.parseFloat(trianglePoints[5])));
            Rectangle containingRectangle = t.containing_rectangle();
            System.out.println("Case #" + test_counter + ": " + String.format("%.02f",t.area()) + " " + 
                                                                String.format("%.02f",t.perimeter()) + " " + 
                                                                String.format("%.02f",containingRectangle.area()) + " " + 
                                                                String.format("%.02f",containingRectangle.perimeter()));

            test_counter++;
        }

    }

}

