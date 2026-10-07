package java.dsa.a_sorts;

import java.util.Scanner;

// Time complexity - 
// Transforming unsorted array of size n into a min/max heap takes O(n) time. 
// Best Case - O(nlogn);
// Average Case - O(nlogn);
// Worst Case - O(nlogn);

// Space Complexity - O(1); in-place.

public class heapSort {

    public static void sorter(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;

        int left = (2 * i) + 1;
        int right = (2 * i) + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            heapify(arr, n, largest);
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
