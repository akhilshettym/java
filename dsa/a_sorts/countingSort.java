package java.dsa.a_sorts;

import java.util.Scanner;

// Time complexity - 
// Non- Comparison based sorting algorithm, counts frequencies of each elements. 
// Best Case - O(n + k);
// Average Case - O(n + k);
// Worst Case - O(n + k);

// Space Complexity - O(n + k);

public class countingSort {

    public static void sorter(int[] arr) {
        int n = arr.length;

        int[] output = new int[n];

        int max = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int[] aux = new int[max + 1];

        for (int i = 0; i <= max; i++) {
            aux[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            aux[arr[i]]++;
        }

        for (int i = 1; i <= max; i++) {
            aux[i] = aux[i] + aux[i - 1];
        }

        for (int i = 0; i < n; i++) {
            output[aux[arr[i]] - 1] = arr[i];
            aux[arr[i]]--;
        }

        for (int i = 0; i < n; i++) {
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
