package main;

import java.io.*;
import java.util.Scanner;

public class main {
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

    public static String toStringSmall(int count){
        return "unsortedFiles\\smallFiles\\small" + count + ".txt";
    }
    public static String toStringMedium(int count){
        return "unsortedFiles\\mediumFiles\\medium" + count + ".txt";
    }
    public static String toStringLarge(int count){
        return "unsortedFiles\\largeFiles\\large" + count + ".txt";
    }


    /**
     * Runs and computes all the small files for the sorting
     * run all files, save times for each algorithm, write all in one shot
     * @throws IOException
     */
    public static void computeSmall() throws IOException {
        long[] heapTimes = new long[30];
        long[] mergeTimes = new long[30];
        long[] quickTimes = new long[30];
        long[] heapTimesReverse = new long[30];
        long[] mergeTimesReverse = new long[30];
        long[] quickTimesReverse = new long[30];
        for(int i = 1; i <= 1; i++){
            System.out.println();
            int smallSize = 10000;
            int[] unsortedArray = new int[smallSize];
            try{
                File fp = new File(toStringSmall(i));
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
            heapTimes[i-1] = sort.runHeapNormal(unsortedArray, i, 0);
            heapTimesReverse[i-1] = sort.runHeapReverse(unsortedArray, i, 0);

            mergeTimes[i-1] = sort.runMergeNormal(unsortedArray, i, 0);
            mergeTimesReverse[i-1] = sort.runMergeNormal(unsortedArray, i, 0);

            quickTimes[i-1] = sort.runQuickNormal(unsortedArray, i, 0);
            quickTimesReverse[i-1] = sort.runQuickReverse(unsortedArray, i, 0);
        }

        writer("smallFileTimes.txt", "Small Heapsort Ascending", heapTimes);
        writer("smallFileTimes.txt", "Small Heapsort Reverse", heapTimesReverse);
        writer("smallFileTimes.txt", "Small MergeSort Ascending", mergeTimes);
        writer("smallFileTimes.txt", "Small MergeSort Reverse", mergeTimesReverse);
        //writer("smallFileTimes.txt", "Small QuickSort Ascending", quickTimes);
        //writer("smallFileTimes.txt", "Small QuickSort Ascending", quickTimesReverse);

    }

    public void computeMedium() throws IOException {
        long[] heapTimes = new long[30];
        long[] mergeTimes = new long[30];
        long[] quickTimes = new long[30];
        long[] heapTimesReverse = new long[30];
        long[] mergeTimesReverse = new long[30];
        long[] quickTimesReverse = new long[30];
        for(int i = 1; i <= 1; i++){
            System.out.println();
            int Size = 100000;
            int[] unsortedArray = new int[Size];
            try{
                File fp = new File(toStringSmall(i));
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
            heapTimes[i-1] = sort.runHeapNormal(unsortedArray, i, 1);
            heapTimesReverse[i-1] = sort.runHeapReverse(unsortedArray, i, 1);

            mergeTimes[i-1] = sort.runMergeNormal(unsortedArray, i, 1);
            mergeTimesReverse[i-1] = sort.runMergeNormal(unsortedArray, i, 1);

            //quickTimes[i-1] = sort.runQuickNormal(unsortedArray, i, 1);
            //quickTimesReverse[i-1] = sort.runQuickReverse(unsortedArray, i, 1);

        }
        writer("mediumFileTimes.txt", "Medium Heapsort Ascending", heapTimes);
        writer("mediumFileTimes.txt", "Medium Heapsort Reverse", heapTimesReverse);
        writer("mediumFileTimes.txt", "Medium MergeSort Ascending", mergeTimes);
        writer("mediumFileTimes.txt", "Medium MergeSort Reverse", mergeTimesReverse);
       // writer("mediumFileTimes.txt", "Medium QuickSort Ascending", quickTimes);
       // writer("mediumFileTimes.txt", "Medium QuickSort Ascending", quickTimesReverse);
    }

    public void computeLarge() throws IOException {
        long[] heapTimes = new long[30];
        long[] mergeTimes = new long[30];
        long[] quickTimes = new long[30];
        long[] heapTimesReverse = new long[30];
        long[] mergeTimesReverse = new long[30];
        long[] quickTimesReverse = new long[30];
        for(int i = 1; i <= 1; i++){
            System.out.println();
            int smallSize = 1000000;
            int[] unsortedArray = new int[smallSize];
            try{
                File fp = new File(toStringSmall(i));
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
            heapTimes[i-1] = sort.runHeapNormal(unsortedArray, i, 2);
            heapTimesReverse[i-1] = sort.runHeapReverse(unsortedArray, i, 2);

            mergeTimes[i-1] = sort.runMergeNormal(unsortedArray, i, 2);
            mergeTimesReverse[i-1] = sort.runMergeNormal(unsortedArray, i, 2);

            quickTimes[i-1] = sort.runQuickNormal(unsortedArray, i, 2);
            quickTimesReverse[i-1] = sort.runQuickReverse(unsortedArray, i, 2);

        }
        writer("largeFileTimes.txt", "Large Heapsort Ascending", heapTimes);
        writer("largeFileTimes.txt", "Large Heapsort Reverse", heapTimesReverse);
        writer("largeFileTimes.txt", "Large MergeSort Ascending", mergeTimes);
        writer("largeFileTimes.txt", "Large MergeSort Reverse", mergeTimesReverse);
        writer("largeFileTimes.txt", "Large QuickSort Ascending", quickTimes);
        writer("largeFileTimes.txt", "Large QuickSort Ascending", quickTimesReverse);
    }
    public static void main(String[] args){

        int[] arr = {4,3,2,5,8,10,11,23,0,1,3};
        //quickSort.sort(arr);
        //System.out.println(Arrays.toString(arr));
       /* try{
            computeSmall();
        }catch(IOException e){
            e.printStackTrace();
        } */
    }
}
