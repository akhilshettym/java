package java.dsa.a_sorts;

import java.util.Scanner;

// Insertion Sort - shifting

// Time complexity - 
// Best Case - O(n); For already sorted elements.
// Average Case - O(n2); Occurs when elements are randomly arranged.
// Worst Case - O(n2); Occurs when elements are in reverse order.

// Space Complexity - O(n); Due to call Stack.

public class insertionSort {

    public static void insertion(int[] arr) {
        for (int i = 1; i <= arr.length - 1; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        System.out.print("After Sorting: ");
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }

    public static void insertionRecursive(int i, int[] arr) {
        if (i >= arr.length) {
            return;
        }

        int key = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;

        insertionRecursive(i + 1, arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        int[] arr2 = new int[size];

        System.out.print("Enter " + size + " elements: ");
        for (int i = 0; i < size; i++) {
            int input = sc.nextInt();
            arr[i] = input;
            arr2[i] = input;
        }

        insertion(arr);

        System.out.println();

        int i = 1;
        insertionRecursive(i, arr2);

        System.out.print("After Recursive Sorting: ");
        for (int n : arr2) {
            System.out.print(n + " ");
        }

        sc.close();
    }
}