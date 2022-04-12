package main;

/**
 * This class handles the timing each algorithm for unsorted and sorted
 * @author Logan Cole
 */
public class sortingHandler {

    /**
     * runs the sorting algorithms on the small file
     * @param unsortedArray - the array to sort
     */
    public long runHeapNormal(int[] unsortedArray){
        long startTime = System.nanoTime();
        int[] sortedArray = heapSort.sort(unsortedArray);
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000; //returns miliseconds
    }

    /**
     * Runs Normal MergeSort
     * @param unsortedArray - the array to be sorted
     * @return - the time it takes to run the algorithm
     */
    public long runMergeNormal(int[] unsortedArray){
        long startTime = System.nanoTime();
        mergeSort.mergeS(unsortedArray, unsortedArray.length);
        long endTime = System.nanoTime();


        return (endTime - startTime) / 1000000; //returns miliseconds
    }

    /**
     * Runs quick sort in normal order
     * @param unsortedArray - the array to be sorted
     * @return - the time it takes to run the algorithm
     */
    public long runQuickNormal(int[] unsortedArray){
        long startTime = System.nanoTime();
        quickSort.sort(unsortedArray, 0, unsortedArray.length - 1);
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000; //returns miliseconds
    }
}
