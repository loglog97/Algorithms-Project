package main;

public class heapSort {
    /**
     * Sorts an array using heap sort
     * @param mainArray - the array to be sorted
     */
    public static int[] sort(int[] mainArray) {
        int length = mainArray.length - 1;
        buildHeap(mainArray, length); //turns array into heap

        for(int i = length; i >= 0; i--){
            int tmp = mainArray[0];
            mainArray[0] = mainArray[i];
            mainArray[i] = tmp;

            buildHeap(mainArray, i - 1); //when this is called, whatever numbers have been sorted wont be used when re-heapifying
        }
        return mainArray;
    }

    /**
     * Builds the array as heap using bottom-up method
     * @param mainArray - array to sort
     */
    public static void buildHeap(int[] mainArray, int length){
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
}
