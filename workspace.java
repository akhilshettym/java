class Workspace {

    /* --- SEARCH --- */
    // Linear Search
    public static int linearSearch(int[] nums, int target) {
        for (int i = 0; i <= nums.length - 1; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    // Recursive Binary Search
    public static int recursiveBinarySearch(int[] nums, int target, int left, int right) {
        if (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                return recursiveBinarySearch(nums, target, mid + 1, right);
            } else {
                return recursiveBinarySearch(nums, target, left, mid - 1);
            }
        }
        return -1;
    }

    /* --- SORT --- */
    // Bubble Sort
    public static void bubbleSort(int[] nums) {
        System.out.print("Bubble Sort: ");

        for (int i = 0; i <= nums.length - 1; i++) {
            for (int j = 0; j <= nums.length - 2; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    // Selection Sort
    public static void selectionSort(int[] nums) {
        System.out.print("Selection Sort: ");
        int min = -1;

        for (int i = 0; i <= nums.length - 1; i++) {
            min = i;
            for (int j = i + 1; j <= nums.length - 2; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }

            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
        }

        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    // Insertion Sort
    public static void insertionSort(int[] nums) {

        System.out.print("Insertion Sort: ");

        for (int i = 1; i <= nums.length - 1; i++) {
            int key = nums[i];
            int j = i - 1;

            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j++;
            }
            nums[j + 1] = key;
        }

        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    // Quick Sort (divide n conquer) (nlogn)
    public static void quickSort(int[] nums) {
        System.out.print("Quick Sort: ");
        quickSorter(nums, 0, nums.length - 1);

        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    public static void quickSorter(int[] nums, int low, int high) {
        if (low < high) {

            int pi = partition(nums, low, high);

            quickSorter(nums, low, pi - 1);
            quickSorter(nums, pi + 1, high);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[i + 1];
        nums[i + 1] = nums[high];
        nums[high] = temp;

        return i + 1;
    }

    // Merge Sort (divide n conquer) (nlogn)
    public static void mergeSort(int[] nums) {
        System.out.println("Merge Sort: ");
        mergeSorter(nums, 0, nums.length - 1);

        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    public static void mergeSorter(int[] nums, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSorter(nums, low, mid);
            mergeSorter(nums, mid + 1, high);

            merge(nums, low, mid, high);
        }
    }

    private static void merge(int[] nums, int low, int mid, int high) {

        int n1 = mid - low + 1;
        int n2 = high - mid;

        int lArr[] = new int[n1];
        int rArr[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            lArr[i] = nums[low + i];
        }
        for (int i = 0; i < n2; i++) {
            rArr[i] = nums[mid + 1 + i];
        }

        int i = 0, j = 0, k = low;

        while (i < n1 && j < n2) {
            if (lArr[i] <= rArr[j]) {
                nums[k] = lArr[i];
                i++;
            } else {
                nums[k] = rArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            nums[k] = lArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            nums[k] = rArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int nums2[] = { 8, 4, 7, 1, 9, 3 };

        int nums[] = { 5, 7, 9, 11, 13 };
        int target = 11;

        int result1 = linearSearch(nums, target);
        int result2 = binarySearch(nums, target);
        int result3 = recursiveBinarySearch(nums, target, 0, nums.length - 1);

        System.out.println("Linear Search Element found at index :" + result1);
        System.out.println("Binary Search Element found at index :" + result2);
        System.out.println("Binary Search Element found at index :" + result3);

        bubbleSort(nums2);
        selectionSort(nums2);
        insertionSort(nums2);
        quickSort(nums2);
        mergeSort(nums2);
    }
}