package akhilshettyym.java.dsa.b_searches;

import java.util.Scanner;

// Time complexity - 
// Best Case - O(log(logn)); When data is perfectly uniform, converges exceptionally fast.
// Average Case - O(log(logn));
// Worst Case - O(n); When data distribution is heavily skewed.

// Space Complexity - Iterative O(1); Operates fully in-place using only primitive pointers.

public class interpolationSearch {

    public static void interpolation(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high && target >= arr[low] && target <= arr[high]) {

            if (arr[low] == arr[high]) {
                if (arr[low] == target) {
                    System.out.print("Element " + target + " found at index: " + low);
                    return;
                }
                break;
            }

            int pos = low + (int) (((double) (high - low) / (arr[high] - arr[low])) * (target - arr[low]));

            if (arr[pos] == target) {
                System.out.print("Element " + target + " found at index: " + pos);
            }

            if (arr[pos] < target) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
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

        System.out.print("Enter the target element to search: ");
        int target = sc.nextInt();

        interpolation(arr, target);

        sc.close();
    }
}