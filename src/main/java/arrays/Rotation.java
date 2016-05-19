package arrays;

import java.util.Arrays;

public class Rotation {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(rotate(a, 7)));
    }

    private static int[] rotate(int[] a, int k) {
        int s = k % a.length;
        int[] arr = new int[s];
        for (int i = 0; i < s; i++)
            arr[i] = a[a.length - s + i];
        for (int i = a.length-1; i >= s; i--)
            a[i] = a[i-s];
        for (int i = 0; i < s; i++)
            a[i] = arr[i];
        return a;
    }
}
