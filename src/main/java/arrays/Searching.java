package arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Searching {
    public static void main(String[] args) {
        int[] arr = {1, 5, 5, 5, 5, 6, 7};
        System.out.println(indexOf(arr, 5));
    }

    /**
     * Returns the index of the specified key in the specified array.
     *
     * @param  a the array of integers, must be sorted in ascending order
     * @param  key the search key
     * @return index of key in array <tt>a</tt> if present; <tt>-1</tt> otherwise
     */
    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else {  // Key Found!
                while (mid > 0 && a[mid] == a[mid-1])
                    mid--;
                return mid;
            }
        }
        return -1;
    }


    /**
     * Binary search simple implementation
     *
     * @param a sorted array
     * @param key to find it
     * @return the index of key
     */
    public static int indexOf1(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;              // = lo + (hi - lo) / 2  = (lo + hi) / 2
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
     *
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
     *
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
