package com.codewars.fundamental;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an array of integers, find the one that appears an odd number of times.
 *
 * There will always be only one integer that appears an odd number of times.
 *
 * Examples
 * [7] should return 7, because it occurs 1 time (which is odd).
 * [0] should return 0, because it occurs 1 time (which is odd).
 * [1,1,2] should return 2, because it occurs 1 time (which is odd).
 * [0,1,0,1,0] should return 0, because it occurs 3 times (which is odd).
 * [1,2,2,3,3,3,4,3,3,3,2,2,1] should return 4, because it appears 1 time (which is odd).
 *
 */
public class FindOdd {

    public static int findIt(int[] A) {
        int xor = 0;
        for (int j : A) {
            xor ^= j;
        }
        return xor;
    }

    @Test
    public void findTest() {
        Random rng = new Random();
        Random rngLen = new Random();
        int size = rng.nextInt(1000) + 50;
        if (size % 2 == 0) size++;

        ArrayList<Integer> list = new ArrayList<Integer>(size);
        for (int i = 0; i < size - 1; i+=2) {
            int even = rng.nextInt(1000);
            list.add(even);
            list.add(even);
        }

        int oddMan = rng.nextInt(1000);

        list.add(oddMan);
        Collections.shuffle(list);
        int[] randArr = new int[size];
        int j = 0;
        for (int i : list) {
            randArr[j++] = i;
        }
        assertEquals(oddMan, FindOdd.findIt(randArr));
        assertEquals(5, FindOdd.findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));
        assertEquals(-1, FindOdd.findIt(new int[]{1,1,2,-2,5,2,4,4,-1,-2,5}));
        assertEquals(5, FindOdd.findIt(new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5}));
        assertEquals(10, FindOdd.findIt(new int[]{10}));
        assertEquals(10, FindOdd.findIt(new int[]{1,1,1,1,1,1,10,1,1,1,1}));
        assertEquals(1, FindOdd.findIt(new int[]{5,4,3,2,1,5,4,3,2,10,10}));
    }
}
