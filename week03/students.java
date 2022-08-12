/*
Given some information about the student, print this student's report card.

Define a class containing the following information about a student:

F: First name
L: Last name
G1: Grade for the first assignment
G2: Grade for the second assignment
G3: Grade for the third assignment
Define a member function computing the average grade for all assignments.
Define a member function returning the full name of the student. 
Define a member function that outputs the report card in the following format:

L, F: Grades: [G1, G2, G3] (avg: Gavg).

Input
The first line of the input contains T: the number of test cases. T test cases follow.

Each test case is a line containing two strings and three integer numbers: the F, L, G1, G2, G3.

Output
For each test case, output one line containing Case #t: L, F: Grades: [G1, G2, G3] 
(avg: Gavg), where t is the test case number other fields are described in the statement above. 
The average must be output rounded to one decimal digit after the comma (using "%.1f" format string in System.out.printf).

*/

import java.util.Scanner;


class students {

    static class Student {
       // first name
        String firstName;
        //last name
        String lastName;
        //grade for first assignment
        int G1 = 0;
        //grade for second assignment
        int G2 = 0;
        //grade for third assignment
        int G3 = 0;

        // Constructor 
        Student(String F, String L, int G1 ,int G2, int G3) {
            this.firstName = F;
            this.lastName = L;
            this.G1 = G1;
            this.G2 = G2;
            this.G3 = G3;
        }

        // Define a member function computing the average grade for all assignments.
        // method to return which point is closer
        public float average_grade()
        {
            float grade_point_average = ((float)this.G1 + (float)this.G2 + (float)this.G3)/3;
            return grade_point_average;
        }


        // Define a member function returning the full name of the student.
        public String student_name()
        {
            String student_full_name = this.lastName + ", " + this.firstName;
            return student_full_name;
        }

        // Define a member function that outputs the report card in the following format:
        // L, F: Grades: [G1, G2, G3] (avg: Gavg).
        public String report_card()
        {
            String student_grades = "[" + this.G1 + ", " + this.G2 + ", " + this.G3 + "]";
            String student_profile = student_name() + ": Grades: " + student_grades + " (avg: " + 
            String.format("%.1f",average_grade()) + ")";
            return student_profile;
        }

        public void print(){
            System.out.println(this.firstName + " " + this.lastName + " " + this.G1 + " " + this.G2 + " " + this.G3);
        }
    }

    public static void main(String[] args) {
        // Create an object of Scanner class
        Scanner sc = new Scanner(System.in);
        int test_nums = sc.nextInt();
        sc.nextLine();
        int test_counter = 1; 
        while (test_counter <= test_nums) {
            String nextLine = sc.nextLine();
            String[] nextLineWords = nextLine.split(" ");
            Student pupil = new Student(nextLineWords[0],nextLineWords[1],Integer.parseInt(nextLineWords[2]),
                            Integer.parseInt(nextLineWords[3]), Integer.parseInt(nextLineWords[4]));
            System.out.println("Case #" + test_counter + ": " + pupil.report_card());
            test_counter++;
        }

        return;

    }
    
}
