package com.wiki.fundamentals.sort;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * //TODO javadocs.
 *
 * @author Ivan Pronin
 * @since 09.11.2022
 */
public class InsertionSort {

    static int[] insertionSort(int[] input) {
        var length = input.length;
        for (int i = 1; i < length; i++) {
            var key = input[i];
            int j = i - 1;
            while (j >= 0 && input[j] > key) {
                input[j + 1] = input[j];
                j = j - 1;
            }
            input[j + 1] = key;
        }
        return input;
    }

    @Test
    void test1() {
        int[] input = new int[]{5, 2, 4, 6, 1, 3};
        var sorted = Arrays.copyOf(input, input.length);
        Arrays.sort(sorted);
        Assertions.assertArrayEquals(sorted, insertionSort(input));
    }

    @Test
    void test2() {
        int[] input = new int[]{31, 41, 59, 41, 26, 58};
        var sorted = Arrays.copyOf(input, input.length);
        Arrays.sort(sorted);
        Assertions.assertArrayEquals(sorted, insertionSort(input));
    }
}
