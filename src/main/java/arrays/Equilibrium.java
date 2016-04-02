package arrays;

/**
 *  This is a solution for the Equilibrium challenges (the middle element where leftSum == rightSum)
 *
 *  Steps:
 *   - calculate the summation from the 3rd element to the end of the array ( rightSum )
 *   - the 1st element will be the ( leftSum )
 *   - the 2nd element will be the Equilibrium element index to be checked its (leftSum == rightSum)
 *   - if equal, return the Equilibrium element index.
 *   - if not equal, then add the element of that index to the leftSum and move to the next index,
 *     then subtract that next index from the rightSum and check again in the loop
 *
 *  Big-O Notation:
 *   - rightSum calculation: O(n)
 *   - Equilibrium index searching: O(n)
 *   - All: O(n+n) which in fact is the same as O(n)
 *
 *  Hint:
 *   - rightSum calculation: used java 8 parallel stream to increase the performance
 *
 *  Test Samples:
 *   - {10, 4, 17, 2, 1, 6, 3, 9, 2, 13}
 *   - {-7, 1, 5, 2, -4, 3, 0}
 */

import java.util.Arrays;

public class Equilibrium {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2};
        System.out.println(getEquilibriumIndex(arr));
    }

    private static int getEquilibriumIndex(int[] arr) {
        int leftSum = arr[0];
        int i = 1;
        int rightSum = Arrays.stream(arr).parallel().sum() - (arr[0] + arr[1]);
        while (i < arr.length-1) {
           if (leftSum == rightSum) {
               return i;
           } else {
               leftSum += arr[i];
               rightSum -= arr[++i];
           }
        }
        return -1;
    }
}
