package main;

/**
 * Heap Sort class
 * @author Logan Cole
 */
public class heapSort {
    /**
     * main sort driver
     * @param array - array to sort
     */
    public static void heapsort(int[] array){
        buildMaxHeap(array, array.length - 1);
        for(int i = array.length - 1; i >= 0; i--){
            swap(array, 0, i);
            heapify(array, i - 1, 0);
        }
    }

    /**
     * Turns array back into heap form after swaping root
     * @param array - array to sort
     * @param end - last leaf node
     * @param start - root node
     */
    public static void heapify(int[] array, int end, int start){
        int max = start;
        int left = 2 * start + 1;
        int right = 2 * start + 2;

        if(left < end && array[left] > array[max]){
            max = left;
        }
        if(right < end && array[right] > array[max]){
            max = right;
        }
        if(max != start){
            swap(array, start, max);
            heapify(array, end, max);
        }
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