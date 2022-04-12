## Sorting Project
#### by: Logan Cole
#### CSC 310 - Design and Analysis of Algorithms

### Generating Files
This portion I did in C. In the directory of the C files, you should be able to write ```make all``` in the shell to compile the generate executable. The prompt will ask what file type you would like to generate. 1 is to generate small files (10,000 numbers), 2 is for medium files (100,000 numbers) and 3 for large files (1,000,000 numbers).
I wrote it this way to be able to generate certain sizes when needed because the large files take up too much space.  
** **This also only generates the unsorted files.** **  
For generating the sorted versions, this is handled in the java code. In the main Driver.java, uncommenting the line of code placed in there
will run the part to generate the files if needed.

### Compiling the sorting portion
In the ```src/main``` portion of the project is where the sorting pieces live. Running the ```Driver.java``` will run the whole program. It will place the sorted version of each files in ```src/main/sortedFiles/<sorting algorithm>/<normal or reverse>/<file size>```.
It will then place the timings for each size in ```src/main``` under ```<filesize>FileTimes.txt```.

### Understanding the timing files
The timing files contain all the times for both unsorted and sorted(reverse and normal) times in milliseconds.
They are listed in the order in which they ran.

### Project Structure
#### Driver
The main driver for the project contains the main running code, and a commented out piece to generate the 
sorted files. Running this will compile and run all the algorithms on sorted and unsorted pieces.  
In General on my PC it took about 10 minutes give or take.

#### SortedFileGenerator
This generates random numbers for the various file sizes and writes them out for the parser to read.
This data is already included in the project. 

#### SortingHandler
This file handles to timing and running of the algorithms on each file. It calculates the time to be returned
and output to their files.
#### UnsortedFileHandler
This handles parsing and running all the unsorted files and keeps track of the timings to be written out.

#### SortedFileHandler
This handles parsing and running all the sorted files and keeps track of the timings to be written out

#### heapSort.java
This is the main file for heapsort. It runs the algorithm on the given array

#### mergeSort.java
The main code for merge sort. It runs the algorithm on the given array
#### quickSort.java
This is the main file for quick sort. I wasn't able to write my own implementation with the 3-way partition algorithm.
After a lot of headache and running out of time, I decided to use a solution from: https://www.geeksforgeeks.org/3-way-quicksort-dutch-national-flag/

