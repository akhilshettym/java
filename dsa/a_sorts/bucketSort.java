package akhilshettyym.java.dsa.a_sorts;

import java.util.ArrayList;
import java.util.Collections;

// Time complexity - 
// Algorithm used when inp array has items that are uniformly distributed over a range.
// Best Case - O(n + k);
// Average Case - O(n + k);
// Worst Case - O(n2);

// Space Complexity - O(n + k);

public class bucketSort {

    public static void sorter(float[] arr) {
        int size = arr.length;

        if (size <= 0) {
            return;
        }

        @SuppressWarnings("unchecked")
        ArrayList<Float>[] buckets = new ArrayList[size];

        for (int i = 0; i < size; i++) {
            buckets[i] = new ArrayList<Float>();
        }

        for (int i = 0; i < size; i++) {
            int bucketIdx = (int) arr[i] * size;
            buckets[bucketIdx].add(arr[i]);
        }

        for (int i = 0; i < size; i++) {
            Collections.sort(buckets[i]);
        }

        int index = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index] = buckets[i].get(j);
                index++;
            }
        }
    }

    public static void main(String[] args) {

        float[] arr = { (float) 0.45, (float) 0.32, (float) 0.23, (float) 0.52, (float) 0.25, (float) 0.47,
                (float) 0.51 };

        sorter(arr);

        System.out.print("After Sorting: ");
        for (float n : arr) {
            System.out.print(n + " ");
        }
    }
}
