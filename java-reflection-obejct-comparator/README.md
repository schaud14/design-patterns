CS542 Design Patterns
FALL 2016
ASSIGNMENT <ASSIGNMENT 5> README FILE

Due Date: <ASSIGNMENT DUE DATE,  Wednesday, December 15, 2016>
Submission Date: <DATE SUBMITED,  Wednesday, December 15, 2016>
Author(s): <Saurabh Chaudhari>
e-mail(s): <schaud14@binghamton.edu>

PURPOSE:
To learn the reflection in Java.

PERCENT COMPLETE:
I believe that we have completed this assignment to 100%.

FILES:
Driver.java
Logger.java         
FileProcessor.java
First.java
Second.java
PopulateObjects.java

SAMPLE OUTPUT:
debug_level : 0
 	[java] Number of unique First objects: 359994
    [java] Total Number of First objects: 498623
    [java] Number of unique Second objects: 100643
    [java] Total Number of Second objects: 501377


TO COMPILE: 
ant -buildfile src/build.xml all

TO RUN:
ant -buildfile src/build.xml run -Darg0=<inputFile> -Darg1=<Debug_value> 
 ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=0

Debug Values:
0: Final Output Only
1: Constructor
2: Entry in Data Structure

TO CLEAN: 
ant -buildfile src/build.xml clean

DATA STRUCTURES USED:
HashMap:
In HashMap we can store unique objects. It does not allow repeatitions.
Also using Object as key and count as value we can store unique objects with their total occurances.
So Single Data Structure is used fot both purposes.