package main;

import java.io.*;
import java.util.Random;
import java.util.Arrays;

/**
 * Generates Sorted Files
 * @author Logan Cole
 */
public class SortedFileGenerator {
    private String fileType;
    private int flag; //0 if normal, 1 if reverse
    Random rand = new Random();
    public SortedFileGenerator(String fileType, int flag){
        this.fileType = fileType;
        this.flag = flag;
    }

    /**
     * To string for filepaths
     * @param count - file number
     * @param filetype - reverse or normal
     * @return - string for the path
     */
    public static String toStringSmallSorted(int count, String filetype){
        return "sortedFiles\\"+ filetype +"\\smallFiles\\small" + count + ".txt";
    }
    public static String toStringMediumSorted(int count, String filetype){
        return "sortedFiles\\" + filetype +"\\mediumFiles\\medium" + count + ".txt";
    }
    public static String toStringLargeSorted(int count, String filetype){
        return "sortedFiles\\" + filetype + "\\largeFiles\\large" + count + ".txt";
    }
    public String toString(int i){
       return Integer.toString(i);
    }

    /**
     * Generates small files sorted normal/reverse
     * @throws IOException - if it cant write
     */
    public void generateSmallSorted() throws IOException {
        for(int i = 1; i <= 30; i++){
            FileWriter writer = new FileWriter(toStringSmallSorted(i, fileType));
            int[] unsorted = new int[10000];
            for(int j = 0; j < 10000; j++){
                unsorted[j] = rand.nextInt(9999);
            }
            Arrays.sort(unsorted);
            if (flag == 0) {
                for(int j = 0; j < 10000; j++){
                    writer.write(toString(unsorted[j]));
                    writer.write("\n");
                }
            }else{
                for(int k = 9999; k >= 0; k--){
                    writer.write(toString(unsorted[k]));
                    writer.write("\n");
                }
            }
            writer.flush();
            writer.close();
        }
    }

    /**
     * Generates medium sorted files normal/reverse
     * @throws IOException
     */
    public void generateMediumSorted() throws IOException {
        for(int i = 1; i <= 30; i++){
            FileWriter writer = new FileWriter(toStringMediumSorted(i, fileType));
            int[] unsorted = new int[100000];
            for(int j = 0; j < 100000; j++){
                unsorted[j] = rand.nextInt(9999);
            }
            Arrays.sort(unsorted);
            if (flag == 0) {
                for(int j = 0; j < 100000; j++){
                    writer.write(toString(unsorted[j]));
                    writer.write("\n");
                }
            }else{
                for(int k = 99999; k >= 0; k--){
                    writer.write(toString(unsorted[k]));
                    writer.write("\n");
                }
            }
            writer.flush();
            writer.close();
        }
    }

    /**
     * Generates Large Files normal/reverse
     * @throws IOException - if it cant write to file
     */
    public void generateLargeSorted() throws IOException {
        for(int i = 1; i <= 30; i++){
            FileWriter writer = new FileWriter(toStringLargeSorted(i, fileType));
            int[] unsorted = new int[1000000];
            for(int j = 0; j < 1000000; j++){
                unsorted[j] = rand.nextInt(9999);
            }
            Arrays.sort(unsorted);
            if (flag == 0) {
                for(int j = 0; j < 1000000; j++){
                    writer.write(toString(unsorted[j]));
                    writer.write("\n");
                }
            }else{
                for(int k = 999999; k >= 0; k--){
                    writer.write(toString(unsorted[k]));
                    writer.write("\n");
                }
            }
            writer.flush();
            writer.close();
        }
    }
}
