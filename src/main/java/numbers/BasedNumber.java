package numbers;

import java.util.Arrays;
import java.util.stream.Stream;

import static numbers.BasedNumber.Base.HEX;
import static numbers.BasedNumber.Base.OCT;
import static numbers.BasedNumber.Base.BIN;
import static numbers.BasedNumber.Base.DEC;

public class BasedNumber {

    enum Base {
        HEX(16), OCT(8), BIN(2), DEC(10);
        int base;
        Base(int base) {
            this.base = base;
        }
    }

    public static void main(String[] args) {
        System.out.println(decimalIntValueOf("7f", HEX));       // = 127
        System.out.println(decimalIntValueOf("47", OCT));       // = 39
        System.out.println(decimalIntValueOf("11", BIN));       // = 3
        System.out.println(decimalIntValueOf("12", DEC));       // = 12
    }

    /**
     * convert string number in any representation (HEX, OCT. BIN, DEC) to decimal integer value
     * @param number valid string number
     * @param b the number representation
     * @return decimal integer value or -1 if the number is invalid
     */
    private static int decimalIntValueOf(String number, Base b) {
        int value = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = valueOf(number.charAt(i));
            if (digit < 0) return -1;
            int exp = number.length() - 1 - i;
            value += digit * Math.pow(b.base, exp);
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
