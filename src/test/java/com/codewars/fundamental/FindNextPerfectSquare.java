/*
 * Copyrights 2020 Playtika Ltd., all rights reserved to Playtika Ltd.
 * privacy+e17bb14d-edc1-4d26-930d-486fcc1ab8fe@playtika.com
 */

package com.codewars.fundamental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * //TODO javadocs.
 *
 * @author Ivan Pronin
 * @since 01.11.2022
 */
public class FindNextPerfectSquare {

    public static long findNextSquare(long sq) {
        var sqrt = Math.sqrt(sq);
        if (sqrt % 1 != 0){
            return -1;
        }

        int nextInt = (int) sqrt + 1;
        return (long) Math.pow(nextInt, 2);
    }

    @Test
    public void test1() {
        assertEquals(144, FindNextPerfectSquare.findNextSquare(121));
    }

    @Test
    public void test2() {
        assertEquals(676, FindNextPerfectSquare.findNextSquare(625));
    }

    @Test
    public void test3() {
        assertEquals(-1, FindNextPerfectSquare.findNextSquare(114));
    }

}
