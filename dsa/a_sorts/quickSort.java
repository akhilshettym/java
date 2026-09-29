package akhilshettyym.java.dsa.a_sorts;

import java.util.Scanner;

// Time complexity - 
// Best Case - O(nlogn); pivot divides and roughly two equal halves each time.
// Average Case - O(nlogn); pivot divides and roughly two equal halves each time.
// Worst Case - O(n2); Occurs when pivot consistently picks smallest or largest element.

// Space Complexity - 
// O(logn); Dosen't need seperate temporary arrays like merge sort.
// O(n); If partitions are completely unbalanced.

public class quickSort {

    public static void sorter(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            sorter(arr, low, pi - 1);
            sorter(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
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

        sorter(arr, 0, arr.length - 1);

        System.out.print("After Sorting: ");
        for (int n : arr) {
            System.out.print(n + " ");
        }

        sc.close();
    }
}
