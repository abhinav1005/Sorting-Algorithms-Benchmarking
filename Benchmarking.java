import java.util.*;

public class Benchmarking {

    public static void main(String[] args) {

        Sort sortObj = new Sort();

        // array to store input sizes
        int[] input_size = new int[] { 10, 20, 50, 100, 200, 500, 1000, 2000, 5000 };

        // arrays to store the final values
        long[] insertionSortResults = new long[9];
        long[] quickSortResults = new long[9];
        long[] mergeSortResults = new long[9];
        long[] bubbleSortResults = new long[9];
        long[] arraysSortResults = new long[9];

        for (int size = 0; size < input_size.length; size++) {
            int index_store = size;

            // this is the input size for which we are benchmarking
            int input = input_size[size];

            // temp array to store the 5 iteration values of timing
            long[] temp = new long[5];

            // create a random array
            int[] arr = sortObj.randomArray(input, 10, 1000000);

            // run insertion sort
            for (int i = 0; i < 5; i++) {
                int[] insertionArr = Arrays.copyOf(arr, arr.length);
                long start = System.nanoTime();
                sortObj.insertionSort(insertionArr);
                long end = System.nanoTime();
                long time_taken = end - start;
                temp[i] = time_taken;

            }

            // insert the average into the table
            insertionSortResults[index_store] = sortObj.findAvg(temp);

            // run quick sort
            for (int i = 0; i < 5; i++) {
                int[] quickArr = Arrays.copyOf(arr, arr.length);
                long start = System.nanoTime();
                sortObj.quickSort(quickArr);
                long end = System.nanoTime();
                long time_taken = end - start;
                temp[i] = time_taken;

            }
            quickSortResults[index_store] = sortObj.findAvg(temp);

            // run merge sort
            for (int i = 0; i < 5; i++) {
                int[] mergeArr = Arrays.copyOf(arr, arr.length);
                long start = System.nanoTime();
                sortObj.mergeSort(mergeArr);
                long end = System.nanoTime();
                long time_taken = end - start;
                temp[i] = time_taken;

            }
            mergeSortResults[index_store] = sortObj.findAvg(temp);

            // run bubble sort
            for (int i = 0; i < 5; i++) {
                int[] bubbleArr = Arrays.copyOf(arr, arr.length);
                long start = System.nanoTime();
                sortObj.bubbleSort(bubbleArr);
                long end = System.nanoTime();
                long time_taken = end - start;
                temp[i] = time_taken;

            }
            bubbleSortResults[index_store] = sortObj.findAvg(temp);

            // java internal Arrays.sort
            for (int i = 0; i < 5; i++) {
                int[] javaArr = Arrays.copyOf(arr, arr.length);
                long start = System.nanoTime();
                // sortObj.insertionSort(insertionArr);
                Arrays.sort(javaArr);
                long end = System.nanoTime();
                long time_taken = end - start;
                temp[i] = time_taken;

            }
            arraysSortResults[index_store] = sortObj.findAvg(temp);
        }

        System.out.println("Insertion Sort Results");
        for (int i = 0; i < insertionSortResults.length; i++) {
            System.out.print(insertionSortResults[i] + " ");
        }
        System.out.println("");

        System.out.println("Quick Sort Results");
        for (int i = 0; i < quickSortResults.length; i++) {
            System.out.print(quickSortResults[i] + " ");
        }
        System.out.println("");

        System.out.println("Merge Sort Results");
        for (int i = 0; i < mergeSortResults.length; i++) {
            System.out.print(mergeSortResults[i] + " ");
        }
        System.out.println("");

        System.out.println("Bubble Sort Results");
        for (int i = 0; i < bubbleSortResults.length; i++) {
            System.out.print(bubbleSortResults[i] + " ");
        }
        System.out.println("");

        System.out.println("In Built Java Sort Results");
        for (int i = 0; i < arraysSortResults.length; i++) {
            System.out.print(arraysSortResults[i] + " ");
        }
        System.out.println("");

    }
}