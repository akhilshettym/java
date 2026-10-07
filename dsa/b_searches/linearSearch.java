package java.dsa.b_searches;

import java.util.Scanner;

// Time complexity - 
// Best Case - O(1); Target is found at the first position.
// Average Case - O(N); Target is found somewhere in the middle.
// Worst Case - O(N); Target is at the end or missing completely.

// Space Complexity - O(1); No extra memory or data structures needed.

public class linearSearch {

    public static void linear(int target, int size, int[] arr) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == target) {
                System.out.print("Element " + target + " found in index: " + i);
            }
        }
        System.out.println();
    }

    public static void linearRecursion(int i, int target, int size, int[] arr) {
        if (i >= size) {
            return;
        }
        if (arr[i] == target) {
            System.out.print("Recursive! Element " + target + " found in index: " + i);
        }

        linearRecursion(i + 1, target, size, arr);
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

        linear(target, size, arr);

        int i = 0;
        linearRecursion(i, target, size, arr);

        sc.close();
    }
}