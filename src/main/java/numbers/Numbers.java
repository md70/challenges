package numbers;

public class Numbers {

    public static void main(String[] args) {
        System.out.println(sumOf(8, 3));
        swapInplace1(1, 3);
    }

    /**
     * Calculate sum without using of sum operator (+)
     * @param a
     * @param b
     * @return the sum of two integers
     */
    private static int sumOf(int a, int b) {
        if (b == 0) return a;
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return sumOf(sum, carry);
    }

    /**
     * Counts the number of ones in the number's binary representation
     * @param x
     * @return
     */
    private static int numOfOnes(int x) {
        return Integer.bitCount(x);
    }

    private static void swapInplace1(int a, int b) {
        System.out.println("Before swap: a=" + a + ",  b=" + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After  swap: a=" + a + ",  b=" + b);
    }

    private static void swapInplace2(int a, int b) {
        System.out.println("Before swap: a=" + a + ",  b=" + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("After  swap: a=" + a + ",  b=" + b);
    }
}
