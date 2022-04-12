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
        /* uncomment this to generate the sorted files */
        generateSorted();

        SortedFileHandler sorted = new SortedFileHandler("normal");
        SortedFileHandler sorted2 = new SortedFileHandler("reverse");
        UnsortedFileHandler unsorted = new UnsortedFileHandler();
        //compute unstored files
        //unsorted.computeSmallUnsorted();
        /*unsorted.computeMediumUnsorted();
        unsorted.computeLargeUnsorted();
        //compute already sorted files
        sorted.computeSmallSorted();
        sorted.computeMediumSorted();
        sorted.computeLargeSorted();
        //Start computing reverse sorted files
        sorted2.computeSmallSorted();
        sorted2.computeMediumSorted();
        sorted2.computeLargeSorted(); */
    }
}
