import java.util.*;

public class Sort {

    public Sort() {
        ;
    }

    // ***********************Insertion
    // Sort*********************************************************
    // sorts the input array arr using the insertion sort algorithm

    /**
     * Insertion sort algorithm
     * 
     * @param arr the array to be sorted
     *            The program assumes that after each iteration, the element will be
     *            placed at right index
     *            The unsorted part of the array will decrease and sorted part will
     *            increase
     */
    public void insertionSort(int[] arr) {
        // case when the array contains one element or less ie 0 hence the array is
        // alreadys sorted

        if (arr.length <= 1) {
            return;
        }
        // variable i is to iterate over the array
        for (int i = 1; i < arr.length; ++i) {

            int toInsert = arr[i];
            // variable j is the index before the element to be inserted
            int j = i - 1;

            // shift elements that are greater than the toInsert and update j everytime
            while (j >= 0 && arr[j] > toInsert) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            // put in the toInsert where the condition satisfies
            arr[j + 1] = toInsert;
        }
    }

    // ****************************Quick
    // Sort***********************************************************
    // sorts the input array arr using the quick sort algorithm.

    public void quickSort(int[] arr) {
        if (arr.length < 1) {
            return;
        }
        qSort(arr, 0, arr.length - 1);
    }

    public static void qSort(int[] arr, int first, int last) {
        if (arr.length == 1) {
            return;
        }
        int split = partition(arr, first, last);
        if (first < split - 1) {
            qSort(arr, first, split - 1);
        }
        if (split < last) {
            qSort(arr, split, last);
        }

    }

    /**
     * The function places the pivot at the right place where i and j cross
     * places smaller elements than pivot to the left of the pivot
     * places larger elements than pivot to the right of the pivot
     * 
     * @param arr   the array
     * @param first the first index
     * @param last  the last index
     * @return
     */
    public static int partition(int arr[], int first, int last) {

        // variable i starts from the first array of the array
        // variable j starts from the last index of the array
        int i = first, j = last;
        int temp;
        int pivot = arr[(first + last) / 2];

        // keeps iterating over the array using i and j and wherever i and j cross, that
        // index is the pivot
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            // swaps if the current element is smaller than the pivot
            if (i <= j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }

    // *******************************************Merge
    // Sort***************************
    // sorts the input array arr using the merge sort algorithm.

    /**
     * the method first breaks down the array into two halves till the size of each
     * becomes 1
     * once the size is 1 the merge process is called and arrays merge till the
     * complete array is formed
     * 
     * @param arr
     */
    public void mergeSort(int[] arr) {
        // case when array has 1 element then it is already sorted
        if (arr.length <= 1) {
            return;
        }
        // temp array
        int[] temp = new int[arr.length];

        // calls mSort
        mSort(arr, temp, 0, arr.length - 1);
    }

    // breaks down the array into smaller arrays
    public static void mSort(int[] arr, int[] temp, int start, int end) {
        if (start == end) {
            return;
        }
        //
        int middle = (start + end) / 2;
        mSort(arr, temp, start, middle);
        mSort(arr, temp, middle + 1, end);
        merge(arr, temp, start, middle, middle + 1, end);
    }

    /**
     * merges the smaller arrays back into a fully sorted array by comparison
     * 
     * @param arr
     * @param temp
     * @param leftStart
     * @param leftEnd
     * @param rightStart
     * @param rightEnd
     */
    public static void merge(int[] arr, int[] temp, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        // index for the first array
        int i = leftStart;

        // index for the second array
        int j = rightStart;

        // index to store
        int k = leftStart;

        // compares the arrays and gets the smaller of the two and puts it into the temp
        // array
        while (i <= leftEnd && j <= rightEnd) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // puts the rest of the elements in the first array into the temp array
        // these are already sorted
        while (i <= leftEnd) {
            temp[k++] = arr[i++];
        }

        // puts the rest of the elements in the second array into the temp array
        // these are already sorted
        while (j <= rightEnd) {
            temp[k++] = arr[j++];
        }

        // replaces the original array values with the sorted temp array values
        for (i = leftStart; i <= rightEnd; i++) {
            arr[i] = temp[i];
        }

    }

    // ********************************Bubble
    // Sort****************************************************
    public void bubbleSort(int[] arr) {
        // if arr length is just one element the arr is sorted
        if (arr.length <= 1) {
            return;
        }
        // i iterates through the array
        // j iterates through the array till the sorted part
        // swaps whenever the next element is smaller than the current one
        // this way elements get sorted in ascending order
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // returns an array of n random integers in the interval [a,b].
    public int[] randomArray(int n, int a, int b) {
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            int random_int = (int) Math.floor(Math.random() * (b - a + 1) + a);
            newArr[i] = random_int;
        }
        return newArr;
    }

    public long findAvg(long[] arr) {
        long sum = 0;
        for (int index = 0; index < arr.length; index++) {
            sum += arr[index];
        }
        return (long) ((long) sum / (long) arr.length);
    }

    public static void main(String[] args) {
        Sort a = new Sort();

        System.out.println("Demonstration for Sorting");
        System.out.println("*****************Merge Sort************");
        int[] arr = new int[] { 3, 5, 2, 67, 4, 8, 9 };
        System.out.println("Original Array:" + " " + Arrays.toString(arr));
        System.out.println("Sorted Array");
        a.mergeSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = new int[] { 2, 4, 1, 3, 7, 54, 8 };
        System.out.println("****Quick Sort*********");
        System.out.println(" Original Array: " + " " + Arrays.toString(arr1));
        a.quickSort(arr1);
        System.out.println("Sorted Array: ");
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = new int[] { 5, 4, 2, 1, 5, 7, 4, 89, 90 };
        System.out.println("********Insertion Sort*********");
        System.out.println("Original Array: " + " " + Arrays.toString(arr2));
        a.insertionSort(arr2);
        System.out.println("Sorted Array: ");
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = new int[] { 2, 9, 7, 5, 6, 8, 9, 3, 34, 54 };
        System.out.println("****Bubble Sort for Extra Credit*********");
        System.out.println("Original Array: " + " " + Arrays.toString(arr3));
        a.bubbleSort(arr3);
        System.out.println("Sorted Array: ");
        System.out.println(Arrays.toString(arr3));

        System.out.println("RandomArray between 20 and 100");
        System.out.println("Random Array " + Arrays.toString(a.randomArray(10, 20, 100)));

        /*
         * Sort sortObj = new Sort();
         * 
         * int[] input_size = new int[] { 10, 20, 50, 100, 200, 500, 1000, 2000, 5000 };
         * 
         * long[] insertionSortResults = new long[9];
         * long[] quickSortResults = new long[9];
         * long[] mergeSortResults = new long[9];
         * long[] bubbleSortResults = new long[9];
         * long[] arraysSortResults = new long[9];
         * 
         * for (int size = 0; size < input_size.length; size++) {
         * int index_store = size;
         * 
         * // this is the input size for which we are benchmarking
         * int input = input_size[size];
         * 
         * // run insertion sort
         * Random random = new Random();
         * int[] arr = sortObj.randomArray(input, 10, 1000000);
         * 
         * int[] insertionArr = Arrays.copyOf(arr, arr.length);
         * int[] quickArr = Arrays.copyOf(arr, arr.length);
         * int[] mergeArr = Arrays.copyOf(arr, arr.length);
         * int[] bubbleArr = Arrays.copyOf(arr, arr.length);
         * int[] javaSortArr = Arrays.copyOf(arr, arr.length);
         * 
         * // run insertion sort
         * long start = System.nanoTime();
         * sortObj.insertionSort(insertionArr);
         * long end = System.nanoTime();
         * long time_taken = end - start;
         * insertionSortResults[index_store] = time_taken;
         * 
         * // run quick sort
         * start = System.nanoTime();
         * sortObj.quickSort(quickArr);
         * end = System.nanoTime();
         * time_taken = end - start;
         * quickSortResults[index_store] = time_taken;
         * 
         * // run merge sort
         * 
         * start = System.nanoTime();
         * sortObj.mergeSort(mergeArr);
         * end = System.nanoTime();
         * time_taken = end - start;
         * mergeSortResults[index_store] = time_taken;
         * 
         * // run bubble sort
         * // arr = sortObj.randomArray(input, 10, 100000);
         * start = System.nanoTime();
         * sortObj.bubbleSort(bubbleArr);
         * end = System.nanoTime();
         * time_taken = end - start;
         * bubbleSortResults[index_store] = time_taken;
         * 
         * // run on inBuilt java sorting
         * // arr = sortObj.randomArray(input, 0, 100000);
         * start = System.nanoTime();
         * Arrays.sort(javaSortArr);
         * end = System.nanoTime();
         * time_taken = end - start;
         * arraysSortResults[index_store] = time_taken;
         * // arraysSortResults[index_store] = input;
         * 
         * }
         * 
         * System.out.println("Insertion Sort Results");
         * for (int i = 0; i < insertionSortResults.length; i++) {
         * System.out.print(insertionSortResults[i] + " ");
         * }
         * System.out.println("");
         * 
         * System.out.println("Quick Sort Results");
         * for (int i = 0; i < quickSortResults.length; i++) {
         * System.out.print(quickSortResults[i] + " ");
         * }
         * System.out.println("");
         * 
         * System.out.println("Merge Sort Results");
         * for (int i = 0; i < mergeSortResults.length; i++) {
         * System.out.print(mergeSortResults[i] + " ");
         * }
         * System.out.println("");
         * 
         * System.out.println("Bubble Sort Results");
         * for (int i = 0; i < bubbleSortResults.length; i++) {
         * System.out.print(bubbleSortResults[i] + " ");
         * }
         * System.out.println("");
         * 
         * System.out.println("In Built Java Sort Results");
         * for (int i = 0; i < arraysSortResults.length; i++) {
         * System.out.print(arraysSortResults[i] + " ");
         * }
         * System.out.println("");
         * 
         * }
         */
    }
}