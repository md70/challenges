package numbers;

public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(maxBinaryGapOf(10));
    }

    private static int maxBinaryGapOf(int n) {
        int maxGap = 0;
        int currentGap = 0;

        while (n > 0 && n % 2 == 0)
            n /= 2;

        while(n > 0) {
            int remainder = n % 2;
            if (remainder == 0) {
                currentGap++;
            } else if (currentGap != 0) {
                maxGap = (currentGap > maxGap) ? currentGap : maxGap;
                currentGap = 0;
            }
            n /= 2;
        }

        return maxGap;
    }
}
