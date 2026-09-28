package akhilshettyym.JAVA.dsa.a_sorts;

import java.util.Scanner;

// Time complexity - 
// Best Case - O(n); When elements already sorted.
// Average Case - O(n2); Elements in random order.
// Worst Case - O(n2); Elements sorted in reverse order.

// Space Complexity - O(1); Swaps completely in-place using a single swap varibale.

public class bubbleSort {

    public static void bubble(int size, int[] arr) {
        if (size <= 1) {
            return;
        }

        for (int i = 0; i < size - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

        System.out.print("After Sorting: ");
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }

    public static void bubbleRecursive(int size, int[] arr) {
        if (size <= 1) {
            return;
        }

        boolean swapped = false;

        for (int j = 0; j < size - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;

                swapped = true;
            }
        }

        if (!swapped) {
            return;
        }

        bubbleRecursive(size - 1, arr);
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

        bubble(size, arr1);

        bubbleRecursive(size, arr2);

        System.out.println();
        System.out.print("After Recursive Sorting: ");
        for (int n : arr2) {
            System.out.print(n + " ");
        }
        System.out.println();

        sc.close();
    }
}