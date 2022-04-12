package main;


import java.io.IOException;

/**
 * Driver for Sorting Project
 * @author Logan Cole
 */
public class Driver {

    /**
     * Generates Sorted Files
     * @throws IOException
     */
    public static void generateSorted() throws IOException {
        SortedFileGenerator gen = new SortedFileGenerator("normal", 0);
        SortedFileGenerator gen2 = new SortedFileGenerator("reverse", 1);
        gen.generateSmallSorted();
        gen.generateMediumSorted();
        gen.generateLargeSorted();

        gen2.generateSmallSorted();
        gen2.generateMediumSorted();
        gen2.generateLargeSorted();
    }

    public static void main(String[] args) throws IOException {

        //int[] arr = {4,3,2,5,8,10,11,23,0,1,3};
        //quickSort.sort(arr, 0, arr.length - 1);
        //heapSort.sort(arr, 0);
        //System.out.println(Arrays.toString(arr))

        /* uncomment this to generate the sorted files */
        //generateSorted();


    }
}
