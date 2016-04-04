package array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class NoDups {
    public static void main(String[] args) {
        Integer[] arr = {2,3,6,6,8,9,10,10,10,12,12};
        int[] noDups = getNoDups1(arr);
        System.out.println(Arrays.toString(noDups));
    }

    /**
     * Traditional/Old way to get NoDups Array
     * Big-O Notation: O(n^2)
     * @param arr array of Integers
     * @return array of distinct values
     */
    private static int[] getNoDups1(Integer[] arr) {
        int nullsCount = 0;
        for (int x = 0; x < arr.length - 1; x++) {
            if (arr[x] != null)
                for (int y = x+1 ; y < arr.length; y++) {
                    if (arr[y] != null) {
                        if (arr[x].equals(arr[y])) {
                            arr[y] = null;
                            nullsCount++;
                        }
                    }
                }
        }

        int[] noDups = new int[arr.length - nullsCount];
        int i = 0;
        for (Integer e : arr) {
            if (e != null)
                noDups[i++] = e;
        }
        return noDups;
    }

    /**
     * Modern way to get NoDups Array
     * Using Java 8
     * @param arr array of Integers
     * @return array of distinct values
     */
    private static int[] getNoDups2(int[] arr) {
        return IntStream.of(arr)
                .distinct()
                .toArray();
    }

    /**
     * Good way to remove duplicates from sorted array
     * Big-O Notation: O(n)
     * Test Sample: {2,3,6,6,8,9,10,10,10,12,12}
     * @param input sorted array
     * @return no dups array
     */
    private static int[] getNoDups3(int[] input){
        int j = 0;
        int i = 1;
        //return if the array length is less than 2
        if(input.length < 2){
            return input;
        }
        while(i < input.length){
            if(input[i] == input[j]){
                i++;
            }else{
                input[++j] = input[i++];
            }
        }
        int[] output = new int[j+1];
        for(int k=0; k<output.length; k++){
            output[k] = input[k];
        }
        return output;
    }
}
