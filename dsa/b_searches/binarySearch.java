package java.dsa.b_searches;

import java.util.Scanner;

// Time complexity - 
// Best Case - O(1);
// Average Case - O(logn);
// Worst Case - O(logn);

// Space Complexity - Iterative O(1); Recursive O(logn);

public class binarySearch {

    public static void binary(int target, int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                System.out.print("Element " + target + " found at index: " + mid);
                break;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

    public static void binaryRecursion(int left, int right, int target, int[] arr) {
        if (left > right) {
            System.out.print("Element " + target + " not found.");
            return;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            System.out.print("Recursive! Element " + target + " found at index: " + mid);
            return;
        } else if (arr[mid] > target) {
            binaryRecursion(left, mid - 1, target, arr);
        } else {
            binaryRecursion(mid + 1, right, target, arr);
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

        binary(target, arr);

        System.out.println();

        int left = 0;
        int right = arr.length - 1;
        binaryRecursion(left, right, target, arr);

        sc.close();
    }
}