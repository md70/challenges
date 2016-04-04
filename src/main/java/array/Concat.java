package array;

import java.util.Arrays;

public class Concat {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {5, 6, 7};
        int[] merged = concat(arr1, arr2);
        System.out.println(Arrays.toString(merged));
    }

    private static int[] concat(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];

        for (int i = 0; i< c.length; i++)
            if (i < a.length)
                c[i] = a[i];
            else
                c[i] = b[i - a.length];

        return c;
    }
}
