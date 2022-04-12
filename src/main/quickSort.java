package main;

/**
 * Quick Sort 3-way Partition. This code is not mine, I tried to write it but it kept failing and after hours of
 * headaches I had to part with a solution I found online. I understand what its doing, but I couldn't replicate it.
 * Credit: https://www.geeksforgeeks.org/3-way-quicksort-dutch-national-flag/
 */
public class quickSort{
    static int i, j;

    /* This function partitions a[] in three parts
       a) a[l..i] contains all elements smaller than pivot
       b) a[i+1..j-1] contains all occurrences of pivot
       c) a[j..r] contains all elements greater than pivot */
    static void partition(int a[], int l, int r)
    {
        i = l - 1; j = r;
        int p = l - 1, q = r;
        int v = a[r];

        while (true)
        {
            // From left, find the first element greater than
            // or equal to v. This loop will definitely
            // terminate as v is last element
            while (a[++i] < v)
                ;
            // From right, find the first element smaller than
            // or equal to v
            while (v < a[--j])
                if (j == l)
                    break;
            // If i and j cross, then we are done
            if (i >= j)
                break;
            // Swap, so that smaller goes on left greater goes
            // on right
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;

            // Move all same left occurrence of pivot to
            // beginning of array and keep count using p
            if (a[i] == v){
                p++;
                temp = a[i];
                a[i] = a[p];
                a[p] = temp;
            }

            // Move all same right occurrence of pivot to end of
            // array and keep count using q
            if (a[j] == v){
                q--;
                temp = a[q];
                a[q] = a[j];
                a[j] = temp;
            }
        }
        // Move pivot element to its correct index
        int temp = a[i];
        a[i] = a[r];
        a[r] = temp;
        // Move all left same occurrences from beginning
        // to adjacent to arr[i]
        j = i - 1;
        for (int k = l; k < p; k++, j--){
            temp = a[k];
            a[k] = a[j];
            a[j] = temp;
        }

        // Move all right same occurrences from end
        // to adjacent to arr[i]
        i = i + 1;
        for (int k = r - 1; k > q; k--, i++)
        {
            temp = a[i];
            a[i] = a[k];
            a[k] = temp;
        }
    }

    // 3-way partition based quick sort
    static void quicksort(int a[], int l, int r)
    {
        if (r <= l)
            return;
        i = 0; j = 0;
        // Note that i and j are passed as reference
        partition(a, l, r);
        // Recur
        quicksort(a, l, j);
        quicksort(a, i, r);
    }
}
