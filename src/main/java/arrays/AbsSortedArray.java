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
     * @param sum
     * @return
     */
    private static int[] findPairSumK(int[] a, int sum) {
        int leftIdx = a.length-1;           // left most index

        int lo = 0;                         // Low / Right index for binary search
        int hi = leftIdx-1;                 // High / Left index for binary search

        while(leftIdx > 0) {
            if (lo <= hi) {                 // Binary search for the difference between the sum and the most left element
                int diff = sum - a[leftIdx];
                int mid = lo + (hi - lo) / 2;

                if (abs(a[mid]) < abs(diff)) {          // Because of the array is Abs-sorted, we are comparing by the the Absolute Values
                    lo = mid + 1;
                } else if (abs(a[mid]) > abs(diff)) {
                    hi = mid - 1;
                } else if (a[mid] == diff && mid != leftIdx){     // Number Found here in this else clause, then we are checking the values are equals (Not Absolute),
                    return new int[]{mid, leftIdx};               // Also checking that is not the same index with the left to return the result as Pair of two different indices
                } else {            // Number Not Found, and starting new binary search for the new difference
                    lo = 0;
                    hi = --leftIdx;
                }
            } else {        // the 'lo' index exceed the 'hi' index of the binary search, mean Number Not Found
                lo = 0;
                hi = --leftIdx;
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
