package main;

import java.io.*;
import java.util.Scanner;

public class UnsortedFileHandler {
    public UnsortedFileHandler(){
    }
    /**
     * Writes the times out to the files
     * @param filename - The name of the file to write to
     * @param fileType - The algorithm it writing for
     * @param times - the array of times for all 30 files
     * @throws IOException - if it can't write to the files
     */
    public static void writer(String filename, String fileType, long[] times) throws IOException{
        BufferedWriter output = new BufferedWriter(new FileWriter(filename, true));
        output.write(fileType);
        output.newLine();
        for(int i = 0; i < times.length; i++){
            output.write(times[i] + " ");
        }
        output.newLine();
        output.flush();
        output.close();
    }

    public static String toStringSmallUnsorted(int count){
        return "src/main/unsortedFiles/smallFiles/small" + count + ".txt";
    }
    public static String toStringMediumUnsorted(int count){
        return "src/main/unsortedFiles/mediumFiles/medium" + count + ".txt";
    }
    public static String toStringLargeUnsorted(int count){
        return "src/main/unsortedFiles/largeFiles/large" + count + ".txt";
    }

    /**
     * Runs and writes times for the Large files for all algorithms unsorted
     * @throws IOException
     */
    public void computeLargeUnsorted() throws IOException {
        long[] heapTimes = new long[30];
        long[] mergeTimes = new long[30];
        long[] quickTimes = new long[30];
        for(int i = 1; i <= 30; i++){
            System.out.println();
            int smallSize = 1000000;
            int[] unsortedArray = new int[smallSize];
            try{
                File fp = new File(toStringLargeUnsorted(i));
                Scanner reader = new Scanner(fp);
                int counter = 0;
                String line;
                while(reader.hasNextLine()){
                    if((line = reader.nextLine()) != null){
                        unsortedArray[counter] = Integer.parseInt(line);
                        counter++;
                    }
                }
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }

            sortingHandler sort = new sortingHandler();
            heapTimes[i-1] = sort.runHeapNormal(unsortedArray);

            mergeTimes[i-1] = sort.runMergeNormal(unsortedArray);

            quickTimes[i-1] = sort.runQuickNormal(unsortedArray);

        }
        writer("largeFileTimes.txt", "Large Heapsort Unsorted", heapTimes);
        writer("largeFileTimes.txt", "Large MergeSort Unsorted", mergeTimes);
        writer("largeFileTimes.txt", "Large QuickSort Unsorted", quickTimes);
    }


    /**
     * Runs the algorithms for medium files and writes out the times for unsorted
     * @throws IOException - if it can't write to the file
     */
    public void computeMediumUnsorted() throws IOException {
        long[] heapTimes = new long[30];
        long[] mergeTimes = new long[30];
        long[] quickTimes = new long[30];
        for(int i = 1; i <= 30; i++){
            System.out.println();
            int Size = 100000;
            int[] unsortedArray = new int[Size];
            try{
                File fp = new File(toStringMediumUnsorted(i));
                Scanner reader = new Scanner(fp);
                int counter = 0;
                String line;
                while(reader.hasNextLine()){
                    if((line = reader.nextLine()) != null){
                        unsortedArray[counter] = Integer.parseInt(line);
                        counter++;
                    }
                }
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }

            sortingHandler sort = new sortingHandler();
            heapTimes[i-1] = sort.runHeapNormal(unsortedArray);
            mergeTimes[i-1] = sort.runMergeNormal(unsortedArray);
            quickTimes[i-1] = sort.runQuickNormal(unsortedArray);
        }
        writer("mediumFileTimes.txt", "Medium Heapsort Unsorted", heapTimes);
        writer("mediumFileTimes.txt", "Medium MergeSort Unsorted", mergeTimes);
        writer("mediumFileTimes.txt", "Medium QuickSort Unsorted", quickTimes);
    }

    /**
     * Runs and computes all the small files for the sorting
     * run all files, save times for each algorithm, write all in one shot for unsorted
     * @throws IOException
     */
    public void computeSmallUnsorted() throws IOException {
        long[] heapTimes = new long[30];
        long[] mergeTimes = new long[30];
        long[] quickTimes = new long[30];
        for(int i = 1; i <= 30; i++){
            System.out.println();
            int smallSize = 10000;
            int[] unsortedArray = new int[smallSize];
            try{
                File fp = new File(toStringSmallUnsorted(i));
                Scanner reader = new Scanner(fp);
                int counter = 0;
                String line;
                while(reader.hasNextLine()){
                    if((line = reader.nextLine()) != null){
                        unsortedArray[counter] = Integer.parseInt(line);
                        counter++;
                    }
                }
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }
            sortingHandler sort = new sortingHandler();
            heapTimes[i-1] = sort.runHeapNormal(unsortedArray);
            mergeTimes[i-1] = sort.runMergeNormal(unsortedArray);
            quickTimes[i-1] = sort.runQuickNormal(unsortedArray);
        }
        writer("smallFileTimes.txt", "Small Heapsort Unsorted", heapTimes);
        writer("smallFileTimes.txt", "Small MergeSort Unsorted", mergeTimes);
        writer("smallFileTimes.txt", "Small QuickSort Unsorted", quickTimes);
    }
}
