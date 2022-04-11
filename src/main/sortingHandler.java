package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class sortingHandler {

    public String toStringSmall(String sortType, String order, int count){
        return "sortedFiles\\" + sortType + "\\" + order + "\\smallFiles\\small" + count + ".txt";
    }
    public String toStringMedium(String sortType, String order, int count){
        return "sortedFiles\\" + sortType + "\\" + order + "\\mediumFiles\\medium" + count + ".txt";
    }
    public String toStringLarge(String sortType, String order, int count){
        return "sortedFiles\\" + sortType + "\\" + order + "\\largeFiles\\large" + count + ".txt";
    }

    public static void writer(String filename, int[] array) throws IOException{
        BufferedWriter output = new BufferedWriter(new FileWriter(filename));
        for(int i = 0; i < array.length; i++){
            output.write(Integer.toString(array[i]));
            output.newLine();
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
            writer(toStringSmall("heapSort", "normal", count), sortedArray);
        }else if(fileFlag == 2){
            writer(toStringMedium("heapSort", "normal", count), sortedArray);
        }else if(fileFlag == 3){
            writer(toStringLarge("heapSort", "normal", count), sortedArray);
        }

        return (endTime - startTime) / 1000000; //returns miliseconds
    }

    public long runHeapReverse(int[] unsortedArray, int count, int fileFlag) throws IOException {
        long startTime = System.nanoTime();
        int[] sortedArray = heapSort.sort(unsortedArray, 1);
        long endTime = System.nanoTime();

        if(fileFlag == 0){
            writer(toStringSmall("heapSort", "reverse", count), sortedArray);
        }else if(fileFlag == 2){
            writer(toStringMedium("heapSort", "reverse", count), sortedArray);
        }else if(fileFlag == 3){
            writer(toStringLarge("heapSort", "reverse", count), sortedArray);
        }

        return (endTime - startTime) / 1000000; //returns miliseconds
    }

    public long runMergeNormal(int[] unsortedArray, int count, int fileFlag) throws IOException {
        long startTime = System.nanoTime();
        mergeSort.mergeS(unsortedArray, unsortedArray.length, 0);
        long endTime = System.nanoTime();

        if(fileFlag == 0){
            writer(toStringSmall("mergeSort", "normal", count), unsortedArray);
        }else if(fileFlag == 2){
            writer(toStringMedium("mergeSort", "normal", count), unsortedArray);
        }else if(fileFlag == 3){
            writer(toStringLarge("mergeSort", "normal", count), unsortedArray);
        }

        return (endTime - startTime) / 1000000; //returns miliseconds
    }

    public long runMergeReverse(int[] unsortedArray, int count, int fileFlag) throws IOException {
        long startTime = System.nanoTime();
        mergeSort.mergeS(unsortedArray, unsortedArray.length, 1);
        long endTime = System.nanoTime();

        if(fileFlag == 0){
            writer(toStringSmall("mergeSort", "reverse", count), unsortedArray);
        }else if(fileFlag == 2){
            writer(toStringMedium("mergeSort", "reverse", count), unsortedArray);
        }else if(fileFlag == 3){
            writer(toStringLarge("mergeSort", "reverse", count), unsortedArray);
        }

        return (endTime - startTime) / 1000000; //returns miliseconds
    }

    public long runQuickNormal(int[] unsortedArray, int count, int fileFlag) throws IOException {
        long startTime = System.nanoTime();
        //put quicksort call here
        long endTime = System.nanoTime();

        if(fileFlag == 0){
            writer(toStringSmall("quickSort", "Normal", count), unsortedArray);
        }else if(fileFlag == 2){
            writer(toStringMedium("quickSort", "Normal", count), unsortedArray);
        }else if(fileFlag == 3){
            writer(toStringLarge("quickSort", "Normal", count), unsortedArray);
        }

        return (endTime - startTime) / 1000000; //returns miliseconds
    }

    public long runQuickReverse(int[] unsortedArray, int count, int fileFlag) throws IOException {
        long startTime = System.nanoTime();
        //put quicksort call here
        long endTime = System.nanoTime();

        if(fileFlag == 0){
            writer(toStringSmall("quickSort", "reverse", count), unsortedArray);
        }else if(fileFlag == 2){
            writer(toStringMedium("quickSort", "reverse", count), unsortedArray);
        }else if(fileFlag == 3){
            writer(toStringLarge("quickSort", "reverse", count), unsortedArray);
        }

        return (endTime - startTime) / 1000000; //returns miliseconds
    }
}
