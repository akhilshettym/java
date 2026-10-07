package java.dsa.a_sorts;

import java.util.Scanner;

// Time complexity - 
// Best Case - O(n2); Must scan the entire remaining array even if sorted.
// Average Case - O(n2); Elements are in random order; full scans still required.
// Worst Case - O(n2); Reverse-sorted order; full scans still required.

// Space Complexity - O(1); Swaps completely in-place using a single swap varibale.

public class selectionSort {

    public static void selection(int size, int[] arr) {
        if (size <= 1) {
            return;
        }

        int min = -1;

        for (int i = 0; i < size - 1; i++) {
            min = i;

            for (int j = i + 1; j < size; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

        System.out.print("After Sorting: ");
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }

    public static void selectionRecursive(int i, int size, int[] arr) {
        if (i >= size - 1) {
            return;
        }

        int min = i;

        for (int j = i + 1; j < size; j++) {
            if (arr[min] > arr[j]) {
                min = j;
            }
        }

        int temp = arr[min];
        arr[min] = arr[i];
        arr[i] = temp;

        selectionRecursive(i + 1, size, arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] arr1 = new int[size];
        int[] arr2 = new int[size];

        System.out.print("Enter " + size + " elements: ");
        for (int i = 0; i < size; i++) {
            int input = sc.nextInt();
            arr1[i] = input;
            arr2[i] = input;
        }

        selection(size, arr1);

        int i = 0;
        selectionRecursive(i, size, arr2);

        System.out.println();
        System.out.print("After Recursive Sorting: ");
        for (int n : arr2) {
            System.out.print(n + " ");
        }
        System.out.println();

        sc.close();
    }
}