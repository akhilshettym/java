package java.dsa.b_searches;

import java.util.Scanner;

// Time complexity - 
// Best Case - O(1); Found at a midpoint.
// Average Case - O(log3n); divides into three parts.
// Worst Case - O(log3n);

// Space Complexity - Iterative O(1); Recursive O(log3n);

public class ternarySearch {

    public static void ternary(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            if (arr[mid1] == target) {
                System.out.print("Element " + target + " found at index: " + mid1);
                break;
            }

            if (arr[mid2] == target) {
                System.out.print("Element " + target + " found at index: " + mid2);
                break;
            }

            if (target < arr[mid1]) {
                right = mid1 - 1;
            } else if (target > arr[mid2]) {
                left = mid2 + 1;
            } else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }
    }

    public static void ternaryRecursion(int[] arr, int target, int left, int right) {
        if (left > right) {
            System.out.print("Element " + target + " not found.");
            return;
        }

        int mid1 = left + (right - left) / 3;
        int mid2 = right - (right - left) / 3;

        if (arr[mid1] == target) {
            System.out.print("Recursive! Element " + target + " found at index: " + mid1);
            return;
        }

        if (arr[mid2] == target) {
            System.out.print("Recursive! Element " + target + " found at index: " + mid2);
            return;
        }

        if (target < arr[mid1]) {
            ternaryRecursion(arr, target, left, mid1 - 1);
        } else if (target > arr[mid2]) {
            ternaryRecursion(arr, target, mid2 + 1, right);
        } else {
            ternaryRecursion(arr, target, mid1 + 1, mid2 - 1);
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

        ternary(arr, target);

        System.out.println();

        int left = 0;
        int right = arr.length - 1;
        ternaryRecursion(arr, target, left, right);

        sc.close();
    }
}