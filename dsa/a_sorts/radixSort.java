package akhilshettyym.java.dsa.a_sorts;

import java.util.Arrays;
import java.util.Scanner;

// Time complexity - 
// Best Case - O(d*(n + k));
// Average Case - O(d*(n + k));
// Worst Case - O(d*(n + k));

// Space Complexity - O(n + k);

// 122 431 565 22 1 47 787

public class radixSort {

    public static void sorter(int[] arr) {
        int size = arr.length;

        int max = arr[0];
        for (int i = 0; i < size; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        for (int p = 1; max / p > 0; p *= 10) {
            countingSort(arr, size, p);
        }
    }

    public static void countingSort(int[] arr, int size, int p) {
        int[] output = new int[size];

        int tempcount[] = new int[10];

        Arrays.fill(tempcount, 0);

        for (int i = 0; i < size; i++) {
            tempcount[(arr[i] / p) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            tempcount[i] = tempcount[i] + tempcount[i - 1];
        }

        for (int i = size - 1; i >= 0; i--) {
            output[tempcount[(arr[i] / p) % 10] - 1] = arr[i];
            tempcount[(arr[i] / p) % 10]--;
        }

        for (int i = 0; i < size; i++) {
            arr[i] = output[i];
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

        sorter(arr);

        System.out.print("After Sorting: ");
        for (int n : arr) {
            System.out.print(n + " ");
        }

        sc.close();
    }
}