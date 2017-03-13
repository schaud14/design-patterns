CS542 Design Patterns
FALL 2016
ASSIGNMENT <ASSIGNMENT 1> README FILE

Due Date: <ASSIGNMENT DUE DATE,  Tuesday, August 30, 2016>
Submission Date: <DATE SUBMITED,  Tuesday, August 30, 2016>
Author(s): <Saurabh Chaudhari> 
e-mail(s): <schaud14@binghamton.edu> 

PURPOSE:
The purpose of this assignment is to allocate exactly three courses to each of 12 studends who have given their preferences for all four courses as input file. This program accomplishes this to goal while minimizing the average preference score.

PERCENT COMPLETE:
I believe that I have completed this assignment to 95-100%.

FILES:
Courses.java    ... This file represents the Courses.
Students.java   ... This file repesents the Students.
Driver.java     ... This file main function of the code and has the algorithm to allocate the courses to students
README.txt      ... This is the Readme File which gives the more details about the code.

SAMPLE OUTPUT: (in output File)
Student_1 A B C
Student_2 A B C
Student_3 A B D
.
.
.
Student_10 B A D
Student_11 B C D
Student_12 C D A
Average preference_score is: 6.083333333333333

TO COMPILE: 
First extract the code then use:
javac Driver.java   ... this will compile the code.

TO RUN:
java Driver <input_filename> <output_filename>

BIBLIOGRAPHY:
References for IO Operations:
https://docs.oracle.com/javase/7/docs/api/java/io/BufferedWriter.html
https://docs.oracle.com/javase/7/docs/api/java/io/BufferedReader.html

CODE EXPLANATION:
This code runs in four iterations over all studends.
In first iteration the code allocates the first preference of the courses mentioned by the students till the course get full once it gets full the second preference is considered.
In second iteration the code allocates the second preference of the courses mentioned by the students till the course get full once it gets full the third preference is considered.
In third iteration the code allocates the third preference of the courses mentioned by the students till the course get full once it gets full the fourth preference is considered.
In fourth iteration the code allocates the fourth preference of the courses mentioned by the students if it is required.

DATA STRUCTURES USED:
I have used simple array of objects of students and courses to represent them respectively.

COMPLEXITY:
Code iterates 4 time over the array of objects of n studends.
So the Complexity is 4*O(n) ~ O(n).

