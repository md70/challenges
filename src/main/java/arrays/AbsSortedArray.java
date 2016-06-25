package arrays;

import static java.lang.Math.abs;

/**
 * This is another solution for the EPI problem 11.4
 *
 * This is the EPI solution: http://bit.ly/28V9PZ6
 *
 */

public class AbsSortedArray {

    public static void main(String[] args) {
        int[] arr = {-49, 75, 103, -147, 164, -197, -238, 314, 348, -422};  // abs-sorted array
        int[] pair = findPairSumK(arr, 167);
        System.out.println("{" + pair[0] + ", " + pair[1] + "}");
    }


    /**
     * My Solution by make use of Binary Search
     * It's O(n) time and O(1) space
     * @param a
     * @param k
     * @return
     */
    private static int[] findPairSumK(int[] a, int k) {
        int max = a.length-1;

        int lo = 0;
        int hi = max-1;

        while(max > 0) {
            if (lo <= hi) {
                int diff = k - a[max];
                int mid = (lo + hi) >>> 1;

                if (abs(a[mid]) < abs(diff)) {
                    lo = mid + 1;
                } else if (abs(a[mid]) > abs(diff)) {
                    hi = mid - 1;
                } else if (mid != max && a[mid] == diff){     // Number found
                    return new int[]{mid, max};
                } else {
                    lo = 0;
                    hi = --max;
                }
            } else {
                lo = 0;
                hi = --max;
            }
        }
        return new int[]{-1, -1};
    }


    /**
     * The EPI Book solution
     * it's O(n^2) time and O(1) space
     * @param arr
     * @param k
     * @return
     */
    private static int[] findPosNegPair(int[] arr, int k) {

        // first for positive, and second for negative.
        int first = arr.length - 1;
        int second = arr.length - 1;

        // Find the last positive or zero.
        while (first >= 0 && arr[first] < 0) {
            first--;
        }

        // Find the last negative.
        while (second >= 0 && arr[second] >= 0) {
            second--;
        }

        while (first >= 0 && second >= 0) {
            if (arr[first] + arr[second] == k) {
                return new int[] {first, second};
            } else if (arr[first] + arr[second] > k) {
                do {
                    first--;
                } while (first >= 0 && arr[first] < 0);
            } else {
                do {
                    second--;
                } while (second >= 0 && arr[second] >= 0);
            }
        }
        return new int[] {-1, -1}; // No answer.
    }

}
