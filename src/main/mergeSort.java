package main;

/**
 * Merge Sort Clas
 * @author Logan Cole
 */
public class mergeSort {

    /**
     * Merges the two halfs
     * @param main - main.main array
     * @param first - left half
     * @param second - right half
     * @param firstLength - left half length
     * @param secondLength - right half length
     */
    public static void merge(int[] main, int[] first, int[] second, int firstLength, int secondLength){
        int i = 0; //first half
        int j = 0; //second half
        int k = 0; //mainArray
        while(i < firstLength && j < secondLength){
            if(first[i] < second[j]){ //change the sign to sort in reverse order
                main[k] = first[i];
                i++;
            }else{
                main[k] = second[j];
                j++;
            }
            k++;
        }
        while(i < firstLength){
            main[k] = first[i];
            k++;
            i++;
        }
        while(j < secondLength){
            main[k] = second[j];
            j++;
            k++;
        }
    }

    /**
     * Main MergeSort runner
     * @param mainArray - the array to be sorted
     * @param mainLength - the length of the main array
     */
    public static void mergeS(int[] mainArray, int mainLength){
        if(mainLength > 1) {
            int midPoint = mainLength / 2;
            int secondLength = mainLength - midPoint;
            int[] firstHalf = new int[midPoint];
            int[] secondHalf = new int[secondLength];

            for(int i = 0, k = 0; i < mainLength; ++i){
                if(i < midPoint){
                    firstHalf[i] = mainArray[i];
                }else{
                    secondHalf[k] = mainArray[i];
                    k++;
                }
            }

            mergeS(firstHalf, midPoint);
            mergeS(secondHalf, secondLength);

            merge(mainArray, firstHalf, secondHalf, midPoint, secondLength);
        }
    }
}
