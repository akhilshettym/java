package akhilshettyym.java.dsa.b_searches;

import java.util.Scanner;

// Time complexity - 
// Best Case - O(logn);
// Average Case - O(logn);
// Worst Case - O(logn);

// Space Complexity - Iterative O(1);

public class exponentialSearch {

    public static void exponential(int[] arr, int target) {
        int n = arr.length;

        if (arr[0] == target) {
            System.out.print("Element " + target + " found at index: " + 0);
            return;
        }

        int i = 1;
        while (i < n && arr[i] <= target) {
            i = i * 2;
        }

        int left = i / 2;
        int right = Math.min(i, n - 1);

        binarySearch(arr, target, left, right);
    }

    public static void binarySearch(int[] arr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                System.out.print("Element " + target + " found at index: " + mid);
                return;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
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

        exponential(arr, target);

        sc.close();
    }
}