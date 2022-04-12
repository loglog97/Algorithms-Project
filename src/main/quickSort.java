package main;

/**
 * Quick Sort algorithm - can't sort in reverse like the other algorithms (I couldn't figure it out and didn't want to break it)
 * @author Logan Cole
 */
public class quickSort{
    static int i, j;
    /**
     * Start of Quick Sort
     * @param mainArray - unsorted array
     * @param left - left index (at start is 0)
     * @param right - right index (at start is length - 1)
     */
    public static void sort(int mainArray[], int left, int right){
        if(left < right){
            i = 0; j = 0;
            partition(mainArray, left, right);

            sort(mainArray, left, j);
            sort(mainArray, i, right);
        }
    }

    /**
     * 3 way partitioning (similar to Dutch-Flag Problem)
     * @param mainArray - to be sorted array
     * @param left - left index
     * @param right - right index
     */
    public static void partition(int mainArray[], int left, int right){
        int leftCount = left - 1;
        int rightCount = right;
        int endValue = mainArray[right];
        i = left; j = right - 1;
        boolean isDone = false;

        while (!isDone) {
            while (mainArray[i] < endValue){
                i++;
            }
            while (endValue < mainArray[j]){
                if (j == left){ //if it reaches the beginning of the array
                    break;
                }
                j--;
            }
            if (i >= j){
                isDone = true;
                continue; //should skip everything after this (i hope)
            }
            swap(mainArray, i, j);
            if (mainArray[i] == endValue) {
                leftCount++;
                swap(mainArray, i, leftCount);
            }
            if (mainArray[j] == endValue) {
                rightCount--;
                swap(mainArray, rightCount, j);
            }
        }
        swap(mainArray, i, right); //move pivot

        j = i - 1;
        i++;
        for (int lCount = left; lCount < leftCount; lCount++){
            swap(mainArray, lCount, j);
            j--;
        }
        for (int rCount = right - 1; rCount > rightCount; rCount--){
            swap(mainArray, i, rCount);
            i++;
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
