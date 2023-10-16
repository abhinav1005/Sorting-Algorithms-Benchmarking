import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class SortTest {
    @Test
    public void testInsertionSort() {
        // sorting using insertion sort
        Sort obj = new Sort();
        int[] arr = new int[] { 2, 4, 1, 56, 3, 5, 60 };
        obj.insertionSort(arr);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 56, 60 }, arr);

        // an array with one element is already sorted
        int[] arr2 = new int[] { 3 };
        obj.insertionSort(arr2);
        assertArrayEquals(new int[] { 3 }, arr2);

        // empty array is already sorted
        int[] ar1 = new int[2];
        obj.insertionSort(ar1);
        assertArrayEquals(new int[2], ar1);

        // to test the randomArray
        int[] randomArr = obj.randomArray(5, 10, 100);
        int[] randomCopy = randomArr;
        obj.quickSort(randomArr);
        Arrays.sort(randomCopy);
        assertArrayEquals(randomCopy, randomArr);
    }

    @Test
    public void testQuickSort() {
        // sorting using insertion sort
        Sort obj = new Sort();
        int[] arr = new int[] { 2, 4, 1, 56, 3, 5, 60 };
        obj.quickSort(arr);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 56, 60 }, arr);

        // an array with one element is already sorted
        int[] arr2 = new int[] { 4 };
        obj.quickSort(arr2);
        assertArrayEquals(new int[] { 4 }, arr2);

        // empty array is already sorted
        int[] ar1 = new int[2];
        obj.quickSort(ar1);
        assertArrayEquals(new int[2], ar1);

        // sorting an alread sorted array
        int[] arr3 = new int[] { 1, 2, 3, 4, 5 };
        obj.quickSort(arr3);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, arr3);

        // to test the randomArray
        int[] randomArr = obj.randomArray(5, 10, 100);
        int[] randomCopy = randomArr;
        obj.quickSort(randomArr);
        Arrays.sort(randomCopy);
        assertArrayEquals(randomCopy, randomArr);
    }

    @Test
    public void testMergeSort() {
        // sorting using insertion sort
        Sort obj = new Sort();
        int[] arr = new int[] { 2, 4, 1, 56, 3, 5, 60 };
        obj.quickSort(arr);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 56, 60 }, arr);

        // empty array is already sorted
        int[] ar1 = new int[2];
        obj.mergeSort(ar1);
        assertArrayEquals(new int[2], ar1);

        // an array with one element is already sorted
        int[] arr2 = new int[] { 4 };
        obj.quickSort(arr2);
        assertArrayEquals(new int[] { 4 }, arr2);

        // sorting an alread sorted array
        int[] arr3 = new int[] { 1, 2, 3, 4, 5 };
        obj.quickSort(arr3);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, arr3);

        // to test the randomArray
        int[] randomArr = obj.randomArray(5, 10, 100);
        int[] randomCopy = randomArr;
        obj.quickSort(randomArr);
        Arrays.sort(randomCopy);
        assertArrayEquals(randomCopy, randomArr);

    }

    @Test
    public void testBubbleSort() {
        // sorting using insertion sort
        Sort obj = new Sort();
        int[] arr = new int[] { 2, 4, 1, 56, 3, 5, 60 };
        obj.quickSort(arr);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 56, 60 }, arr);

        // empty array is already sorted
        int[] ar1 = new int[2];
        obj.bubbleSort(ar1);
        assertArrayEquals(new int[2], ar1);

        // an array with one element is already sorted
        int[] arr2 = new int[] { 4 };
        obj.quickSort(arr2);
        assertArrayEquals(new int[] { 4 }, arr2);

        // sorting an alread sorted array
        int[] arr3 = new int[] { 1, 2, 3, 4, 5 };
        obj.quickSort(arr3);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, arr3);

        // to test the randomArray
        int[] randomArr = obj.randomArray(5, 10, 100);
        int[] randomCopy = randomArr;
        obj.quickSort(randomArr);
        Arrays.sort(randomCopy);
        assertArrayEquals(randomCopy, randomArr);

    }

}
