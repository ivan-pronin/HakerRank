package com.codewars.fundamental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * //TODO javadocs.
 *
 * @author Ivan Pronin
 * @since 05.11.2022
 */
public class NumberOfTrailingFactorialZeroes {

    public static int zeros(int n) {
        int res = 0;
        for (int i = 5; i <= n; i *= 5) {
            System.out.println(String.format("i=%d, res=%s, n/i=%d", i, res, n / i));
            res += n / i;
        }
        return res;
    }

    @Test
    public void testZeros() {
        assertEquals(0, NumberOfTrailingFactorialZeroes.zeros(0));
        assertEquals(1, NumberOfTrailingFactorialZeroes.zeros(6));
        assertEquals(2, NumberOfTrailingFactorialZeroes.zeros(14));
    }

    @Test
    public void test30() {
        assertEquals(7, NumberOfTrailingFactorialZeroes.zeros(30));
    }

    @Test
    public void test1000() {
        assertEquals(249, NumberOfTrailingFactorialZeroes.zeros(1000));
    }
}
