package main;

import java.io.*;
import java.util.Scanner;

public class SortedFileHandler {
    private String fileType;
    public SortedFileHandler(String fileType){
        this.fileType = fileType;
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
    public static String toStringSmallSorted(int count, String filetype){
        return "src/main/sortedFiles/"+ filetype +"/smallFiles/small" + count + ".txt";
    }
    public static String toStringMediumSorted(int count, String filetype){
        return "src/main/sortedFiles/" + filetype +"/mediumFiles/medium" + count + ".txt";
    }
    public static String toStringLargeSorted(int count, String filetype){
        return "src/main/sortedFiles/" + filetype + "/largeFiles/large" + count + ".txt";
    }

    /**
     * Runs and writes times for the Large files for all algorithms unsorted
     * @throws IOException
     */
    public void computeLargeSorted() throws IOException {
        long[] heapTimes = new long[30];
        long[] mergeTimes = new long[30];
        long[] quickTimes = new long[30];
        for(int i = 1; i <= 30; i++){
            System.out.println();
            int smallSize = 1000000;
            int[] unsortedArray = new int[smallSize];
            try{
                File fp = new File(toStringLargeSorted(i, fileType));
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
        writer("largeFileTimes.txt", "Large Heapsort Sorted " + fileType, heapTimes);
        writer("largeFileTimes.txt", "Large MergeSort Sorted " + fileType, mergeTimes);
        writer("largeFileTimes.txt", "Large QuickSort Sorted " + fileType, quickTimes);
    }


    /**
     * Runs the algorithms for medium files and writes out the times for unsorted
     * @throws IOException - if it can't write to the file
     */
    public void computeMediumSorted() throws IOException {
        long[] heapTimes = new long[30];
        long[] mergeTimes = new long[30];
        long[] quickTimes = new long[30];
        for(int i = 1; i <= 30; i++){
            System.out.println();
            int Size = 100000;
            int[] unsortedArray = new int[Size];
            try{
                File fp = new File(toStringMediumSorted(i, fileType));
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
        writer("mediumFileTimes.txt", "Medium Heapsort Sorted " + fileType, heapTimes);
        writer("mediumFileTimes.txt", "Medium MergeSort Sorted " + fileType, mergeTimes);
        writer("mediumFileTimes.txt", "Medium QuickSort Sorted " + fileType, quickTimes);
    }

    /**
     * Runs and computes all the small files for the sorting
     * run all files, save times for each algorithm, write all in one shot for unsorted
     * @throws IOException
     */
    public void computeSmallSorted() throws IOException {
        long[] heapTimes = new long[30];
        long[] mergeTimes = new long[30];
        long[] quickTimes = new long[30];
        for(int i = 1; i <= 30; i++){
            System.out.println();
            int smallSize = 10000;
            int[] unsortedArray = new int[smallSize];
            try{
                File fp = new File(toStringSmallSorted(i, fileType));
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
        writer("smallFileTimes.txt", "Small Heapsort Sorted " + fileType, heapTimes);
        writer("smallFileTimes.txt", "Small MergeSort Sorted " + fileType, mergeTimes);
        writer("smallFileTimes.txt", "Small QuickSort Sorted " + fileType, quickTimes);
    }
}
