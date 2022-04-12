package main;

/**
 * Heap Sort class
 * @author Logan Cole
 */
public class heapSort {
    /**
     * Sorts an array using heap sort
     * @param mainArray - the array to be sorted
     */
    public static int[] sort(int[] mainArray) {
        int length = mainArray.length - 1;
        buildMaxHeap(mainArray, length); //turns array into heap

        for(int i = length; i >= 0; i--){
            swap(mainArray, 0, i);
            buildMaxHeap(mainArray, i - 1); //when this is called, whatever numbers have been sorted wont be used when re-heapifying
        }
        return mainArray;
    }

    /**
     * Builds the array as Max heap using bottom-up method
     * @param mainArray - array to sort
     * @param length - array length - 1
     */
    public static void buildMaxHeap(int[] mainArray, int length){
        int i = (int)Math.floor(length / 2);
        while(i >= 0){
            int k = i;
            int v = mainArray[i];
            boolean isHeap = false;
            while(!isHeap && (2 * k <= length)){
                int j = 2 * k;
                if(j < length){
                    if(mainArray[j] < mainArray[j+1]){
                        j++;
                    }
                }
                if(v >= mainArray[j]){
                    isHeap = true;
                }else{
                    mainArray[k] = mainArray[j];
                    k = j;
                }
            }
            mainArray[k] = v;
            i--;
        }
    }

    /**
     * Normal swap method
     * @param array - array to have values swapped in
     * @param a - index 1
     * @param b - index 2
     */
    public static void swap(int[] array, int a, int b){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}