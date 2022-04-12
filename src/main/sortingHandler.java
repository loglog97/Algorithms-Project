package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class handles the timing and writing out the sorted versions of the files for each algorithm
 * @author Logan Cole
 */
public class sortingHandler {

    /**
     * For the following 3 methods, its a toString to find the correct file to output to
     * @param sortType - the type of sort it did
     * @param order - Reverse or Normal
     * @param count - the file number
     * @return - a string of the path to output to.
     */
    public String toStringSmall(String sortType, String order, int count){
        return "sortedFiles\\" + sortType + "\\" + order + "\\smallFiles\\small" + count + ".txt";
    }
    public String toStringMedium(String sortType, String order, int count){
        return "sortedFiles\\" + sortType + "\\" + order + "\\mediumFiles\\medium" + count + ".txt";
    }
    public String toStringLarge(String sortType, String order, int count){
        return "sortedFiles\\" + sortType + "\\" + order + "\\largeFiles\\large" + count + ".txt";
    }

    /**
     * This writes the sorted version of the array to a file
     * @param filename - the name of the file to write to
     * @param array - the sorted array (either normal or reverse)
     * @param quickSortFlag - only used if reverse quick sort is called (didn't want to duplicated any more code)
     * @throws IOException - if the file can't be written to
     */
    public static void writer(String filename, int[] array, int quickSortFlag) throws IOException{
        BufferedWriter output = new BufferedWriter(new FileWriter(filename));
        if(quickSortFlag != 1){
            for(int i = 0; i < array.length; i++){
                output.write(Integer.toString(array[i]));
                output.newLine();
            }
        }else{
            for(int i = array.length - 1; i >= 0; i--){
                output.write(Integer.toString(array[i]));
                output.newLine();
            }
        }
        output.flush();
        output.close();
    }

    /**
     * runs the sorting algorithms on the small file
     * @param unsortedArray - the array to sort
     * @param count - the file its currently sorting
     * @param fileFlag - tells the code what filetype its sorting. 0 = small, 1 = medium, 2 = large
     */
    public long runHeapNormal(int[] unsortedArray, int count, int fileFlag) throws IOException {
        long startTime = System.nanoTime();
        int[] sortedArray = heapSort.sort(unsortedArray, 0);
        long endTime = System.nanoTime();

        if(fileFlag == 0){
            writer(toStringSmall("heapSort", "normal", count), sortedArray, 0);
        }else if(fileFlag == 2){
            writer(toStringMedium("heapSort", "normal", count), sortedArray, 0);
        }else if(fileFlag == 3){
            writer(toStringLarge("heapSort", "normal", count), sortedArray, 0);
        }

        return (endTime - startTime) / 1000000; //returns miliseconds
    }

    /**
     * Runs Heap Sort in reverse, creates a min heap then sorts
     * @param unsortedArray - array to be sorted
     * @param count - the file number
     * @param fileFlag - the size of the file
     * @return - the time for the algorithm to run
     * @throws IOException - if it can't write out the file
     */
    public long runHeapReverse(int[] unsortedArray, int count, int fileFlag) throws IOException {
        long startTime = System.nanoTime();
        int[] sortedArray = heapSort.sort(unsortedArray, 1);
        long endTime = System.nanoTime();

        if(fileFlag == 0){
            writer(toStringSmall("heapSort", "reverse", count), sortedArray, 0);
        }else if(fileFlag == 2){
            writer(toStringMedium("heapSort", "reverse", count), sortedArray, 0);
        }else if(fileFlag == 3){
            writer(toStringLarge("heapSort", "reverse", count), sortedArray, 0);
        }

        return (endTime - startTime) / 1000000; //returns miliseconds
    }

    /**
     * Runs Normal MergeSort
     * @param unsortedArray - the array to be sorted
     * @param count - the file number
     * @param fileFlag - the file size
     * @return - the time it takes to run the algorithm
     * @throws IOException - if it can't write to the file
     */
    public long runMergeNormal(int[] unsortedArray, int count, int fileFlag) throws IOException {
        long startTime = System.nanoTime();
        mergeSort.mergeS(unsortedArray, unsortedArray.length, 0);
        long endTime = System.nanoTime();

        if(fileFlag == 0){
            writer(toStringSmall("mergeSort", "normal", count), unsortedArray, 0);
        }else if(fileFlag == 2){
            writer(toStringMedium("mergeSort", "normal", count), unsortedArray, 0);
        }else if(fileFlag == 3){
            writer(toStringLarge("mergeSort", "normal", count), unsortedArray, 0);
        }

        return (endTime - startTime) / 1000000; //returns miliseconds
    }

    /**
     * Runs MergeSort in reverse order (largest to smallest)
     * @param unsortedArray - array to be sorted
     * @param count - the number of the file its currently working with
     * @param fileFlag - the size of the file
     * @return - the time it takes to run the algorithm
     * @throws IOException - if it can't write the output
     */
    public long runMergeReverse(int[] unsortedArray, int count, int fileFlag) throws IOException {
        long startTime = System.nanoTime();
        mergeSort.mergeS(unsortedArray, unsortedArray.length, 1);
        long endTime = System.nanoTime();

        if(fileFlag == 0){
            writer(toStringSmall("mergeSort", "reverse", count), unsortedArray, 0);
        }else if(fileFlag == 2){
            writer(toStringMedium("mergeSort", "reverse", count), unsortedArray, 0);
        }else if(fileFlag == 3){
            writer(toStringLarge("mergeSort", "reverse", count), unsortedArray, 0);
        }

        return (endTime - startTime) / 1000000; //returns miliseconds
    }

    /**
     * Runs quick sort in normal order
     * @param unsortedArray - the array to be sorted
     * @param count - the number of the file its currently working with
     * @param fileFlag - the size of the file
     * @return - the time it takes to run the algorithm
     * @throws IOException - if it can't write to the file
     */
    public long runQuickNormal(int[] unsortedArray, int count, int fileFlag) throws IOException {
        long startTime = System.nanoTime();
        quickSort.sort(unsortedArray, 0, unsortedArray.length - 1);
        long endTime = System.nanoTime();

        if(fileFlag == 0){
            writer(toStringSmall("quickSort", "Normal", count), unsortedArray, 0);
        }else if(fileFlag == 2){
            writer(toStringMedium("quickSort", "Normal", count), unsortedArray, 0);
        }else if(fileFlag == 3){
            writer(toStringLarge("quickSort", "Normal", count), unsortedArray, 0);
        }

        return (endTime - startTime) / 1000000; //returns miliseconds
    }

    /**
     * Handles sorting in reverse, I couln't figure out how to reverse sort it by changinge
     * the algorithm, so I sort normally and reverse the output when writing to the file
     * @param unsortedArray - array to be sorted
     * @param count - the number for the file it is sorting
     * @param fileFlag - the size of the file its sorting
     * @return the time for the algorithm to run for that file
     * @throws IOException - if it can't write out to the file
     */
    public long runQuickReverse(int[] unsortedArray, int count, int fileFlag) throws IOException {
        long startTime = System.nanoTime();
        quickSort.sort(unsortedArray, 0, unsortedArray.length - 1);
        long endTime = System.nanoTime();

        if(fileFlag == 0){
            writer(toStringSmall("quickSort", "reverse", count), unsortedArray, 1);
        }else if(fileFlag == 2){
            writer(toStringMedium("quickSort", "reverse", count), unsortedArray, 1);
        }else if(fileFlag == 3){
            writer(toStringLarge("quickSort", "reverse", count), unsortedArray, 1);
        }

        return (endTime - startTime) / 1000000; //returns miliseconds
    }
}
