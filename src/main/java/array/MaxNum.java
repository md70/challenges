package array;

/**
 * These are different ways to get the max num in an array
 * Using traditional java and Java 8 new APIs
 */


import org.apache.commons.lang3.math.NumberUtils;
import rx.Observable;
import rx.observables.MathObservable;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.IntStream;

public class MaxNum {
    public static void main(String[] args) {
        Integer[] arr = {3, 5, 6, 7};
        getMax5(arr);
//        System.out.println(getMax1(arr));
    }

    /**
     * Traditional/Old way to get the max number in an array
     * @param arr of integers
     * @return the max number in the array
     */
    private static int getMax1(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    /**
     * Modern way to get the max number in an array
     * Using Java 8
     * @param arr of integers
     * @return the max number in the array
     */
    private static int getMax2(int[] arr) {
        return Optional.of(Arrays.stream(arr).parallel().max()).get().getAsInt();
    }

    /**
     * Using Java 8
     * @param arr of integers
     * @return the max number in the array
     */
    private static int getMax3(int[] arr) {
        return IntStream.of(arr).max().getAsInt();
    }

    /**
     * Using Java Collections utils
     * @param arr of integers
     * @return the max number in the array
     */
    private static int getMax4(Integer[] arr) {
        return Collections.max(Arrays.asList(arr));
    }

    /**
     * Using RxJava
     * @param arr array of integers
     */
    private static void getMax5(Integer[] arr) {
        Observable<Integer> findMax = Observable.from(Arrays.asList(arr));
        MathObservable.max(findMax).subscribe(System.out::println);
    }

    /**
     * Using Apache Commons
     * @param arr array of integers
     * @return the max number
     */
    private static int getMax6(int[] arr) {
        return NumberUtils.max(arr);
    }
}
