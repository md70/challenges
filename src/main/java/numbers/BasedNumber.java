package numbers;

import java.util.Arrays;
import java.util.stream.Stream;

import static numbers.BasedNumber.Base.contains;

public class BasedNumber {

    enum Base {
        HEX(16), OCT(8), BIN(2), DEC(10);

        int base;

        Base(int base) {
            this.base = base;
        }

        public static boolean contains(int base) {
            for (Base b : Base.values())
                if (b.base == base)
                    return true;
            return false;

//            Using Java 8
//            return Stream.of(Base.values()).anyMatch(b -> b.base == base);
        }
    }

    public static void main(String[] args) {
        String hex = "7f";    // = 127
        String oct = "47";    // = 39
        String bin = "11";    // = 3
        String dec = "12";    // = 12
        System.out.println(decimalOf(hex, 16));
        System.out.println(decimalOf(oct, 8 ));
        System.out.println(decimalOf(bin, 2 ));
        System.out.println(decimalOf(dec, 10));
    }

    private static int decimalOf(String number, int base) {
        if (!contains(base)) return -1;
        int value = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = valueOf(number.charAt(i));
            if (digit == -1)
                return -1;
            int exp = number.length() - 1 - i;
            value += digit * Math.pow(base, exp);
        }
        return value;
    }

    /**
     * convert the character to a valid number
     * @param c a character represents a number in numeral system
     * @return return numbers from 1 - 9 as it and characters from a - f as 10 - 15
     */
    private static int valueOf(char c) {
        int charValue = (int) c;
        if (charValue >= 48 && charValue <= 57)
            return charValue - 48;
        if (charValue >= 97 && charValue <= 102)
            return charValue - 87;
        return -1;
    }
}
