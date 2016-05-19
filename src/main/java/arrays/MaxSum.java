package arrays;

public class MaxSum {
    public static void main(String[] args) {
        int[] arr = {-2, -3, -8, -1, -2, -4, -2, -3};
        System.out.println(getMaxSum(arr));
    }

    private static int getMaxSum(int[] a) {
        int maxsum = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (maxsum < sum)
                maxsum = sum;
            else if (sum < 0)
                sum = 0;
        }

        return maxsum;
    }
}
