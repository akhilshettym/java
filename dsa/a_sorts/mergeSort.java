package java.dsa.a_sorts;

import java.util.Scanner;

// Time complexity - 
// Best Case - O(nlogn); Always splits and merges regardless of initial order.
// Average Case - O(nlogn); Splits array in half recursively and merges sorted halves.
// Worst Case - O(nlogn); Consistent performance even on reverse-sorted data.

// Space Complexity - O(n); Temporary arrays/buffers needed during merge step.

public class mergeSort {

    public static void merger(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            merger(arr, low, mid);
            merger(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int lArr[] = new int[n1];
        int rArr[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            lArr[i] = arr[low + i];
        }

        for (int i = 0; i < n2; i++) {
            rArr[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = low;

        while (i < n1 && j < n2) {
            if (lArr[i] <= rArr[j]) {
                arr[k] = lArr[i];
                i++;
            } else {
                arr[k] = rArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = lArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.print("Enter " + size + " elements: ");
        for (int i = 0; i < size; i++) {
            int input = sc.nextInt();
            arr[i] = input;
        }

        merger(arr, 0, arr.length - 1);

        System.out.print("After Sorting: ");
        for (int n : arr) {
            System.out.print(n + " ");
        }

        sc.close();
    }
}
