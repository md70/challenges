package array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Searching {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(indexOf4(arr, 7));
    }


    /**
     * Binary search simple implementation
     * @param a sorted array
     * @param key to find it
     * @return the index of key
     */
    public static int indexOf1(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;              // === lo + (hi - lo) / 2  === (lo + hi) / 2
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }


    /**
     * Java Built-in binary search
     * @param a
     * @param key
     * @return
     */
    private static int indexOf2(int[] a, int key) {
        return Arrays.binarySearch(a, key);
    }

    /**
     * Traditional/way to search for
     * @param a
     * @param key
     * @return
     */
    private static int indexOf3(int[] a, int key) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == key) return i;
        return -1;
    }

    /**
     * Modern way to search for element using linear search
     * @param a an array of ordered/unordered
     * @param key the element to search for it
     * @return the index of key if found or -1 if not found
     */
    private static int indexOf4(int[] a, int key) {
        return IntStream.range(0, a.length)
                    .parallel()
                    .filter(i -> a[i] == key)
                    .findFirst()
                    .orElse(-1);
    }
}
