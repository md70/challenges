package arrays;

/**
 * These are different ways to get the max num in an array
 * Using traditional java and Java 8 new APIs
 */

import java.util.*;
import java.util.stream.IntStream;

public class MaxNum {
    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 7};
        System.out.println(getMax1(arr));
    }

    /**
     * Traditional/Old way to get the max number in an array
     * @param arr
     * @return
     */
    private static int getMax1(int[] arr) {
        int max = arr[1];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    /**
     * Modern way to get the max number in an array
     * Using Java 8
     * @param arr
     * @return
     */
    private static int getMax2(int[] arr) {
        return Optional.of(Arrays.stream(arr).parallel().max()).get().getAsInt();
    }

    /**
     * Another way using Java 8
     * @param arr
     * @return
     */
    private static int getMax3(int[] arr) {
        return IntStream.of(arr).max().getAsInt();
    }

    /**
     * Another way using Java Collections utils
     * @param arr
     * @return
     */
    private static int getMax4(Integer[] arr) {
        return Collections.max(Arrays.asList(arr));
    }

}
