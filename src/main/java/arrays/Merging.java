package arrays;

import java.util.Arrays;

public class Merging {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 6, 7};
        int[] arr2 = {5, 8};
        int[] concatArr = concat(arr1, arr2);
        System.out.println(Arrays.toString(concatArr));
        int[] mergeArr = merge(arr1, arr2);
        System.out.println(Arrays.toString(mergeArr));
    }

    /**
     * Concatenate an array to another at the end of it
     * @param a any array
     * @param b any array
     * @return
     */
    private static int[] concat(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        for (int i = 0; i< c.length; i++)
            c[i] = (i<a.length) ? a[i] : b[i-a.length];
        return c;
    }

    /**
     * Merge two ordered arrays into each other
     * @param a ordered array
     * @param b ordered array
     * @return
     */
    public static int[] merge(int[] a, int[] b) {
        int i = 0, j = 0, k = 0;
        int[] c = new int[a.length + b.length];

        while (i < a.length && j < b.length)
            if (a[i] < b[j])
                c[k++] = a[i++];
            else
                c[k++] = b[j++];

        while (i < a.length)
            c[k++] = a[i++];

        while (j < b.length)
            c[k++] = b[j++];

        return c;
    }


}
