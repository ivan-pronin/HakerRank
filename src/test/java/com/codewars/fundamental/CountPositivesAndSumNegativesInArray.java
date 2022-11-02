/*
 * Copyrights 2020 Playtika Ltd., all rights reserved to Playtika Ltd.
 * privacy+e17bb14d-edc1-4d26-930d-486fcc1ab8fe@playtika.com
 */

package com.codewars.fundamental;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * //TODO javadocs.
 *
 * @author Ivan Pronin
 * @since 01.11.2022
 */
public class CountPositivesAndSumNegativesInArray {

    public static int[] countPositivesSumNegatives(int[] input)
    {
        if (input == null || input.length == 0) return new int[] {};
        int count = 0,sum = 0;
        for (int i : input) {
            if (i > 0) count ++;
            if (i < 0) sum += i;
        }

        String[] words = "ss".split(" ");
        Arrays.stream(words)
                .mapToInt(String::length)
                .min()
                .getAsInt();
        return new int[] {count,sum};
    }
    @Test
    public void countPositivesSumNegatives_BasicTest() {
        int[] expectedResult = new int[] {10, -65};
        assertArrayEquals(expectedResult, CountPositivesAndSumNegativesInArray.countPositivesSumNegatives(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15}));
    }

    @Test
    public void countPositivesSumNegatives_InputWithZeroes() {
        int[] expectedResult = new int[] {8, -50};
        assertArrayEquals(expectedResult, CountPositivesAndSumNegativesInArray.countPositivesSumNegatives(new int[] {0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14}));
    }

    @Test
    public void countPositivesSumNegatives_InputNull() {
        int[] expectedResult = new int[] { };
        assertArrayEquals(expectedResult, CountPositivesAndSumNegativesInArray.countPositivesSumNegatives(null));
    }

    @Test
    public void countPositivesSumNegatives_InputEmpty() {
        int[] expectedResult = new int[] { };
        assertArrayEquals(expectedResult, CountPositivesAndSumNegativesInArray.countPositivesSumNegatives(new int[] {}));
    }

    @Test
    public void countPositivesSumNegatives_RandomTests() {
        for(int i = 0; i < 20; i++)
        {
            int elementsNumber = (int)Math.floor(Math.random() * 100);
            int[] input = new int[elementsNumber];
            for(int j = 0; j < elementsNumber; j++)
            {
                input[j] = (int)Math.floor(Math.random() * 1000) - 500;
            }

            int[] expected = new int[0];
            if(elementsNumber > 0)
            {
                int countPositives = 0;
                int sumNegatives = 0;
                for(int ti=0;ti<input.length;ti++)
                {
                    if(input[ti] > 0)
                    {
                        countPositives++;
                    }
                    if(input[ti] < 0)
                    {
                        sumNegatives += input[ti];
                    }
                }
                expected = new int[] { countPositives, sumNegatives };
            }

            assertArrayEquals(expected, CountPositivesAndSumNegativesInArray.countPositivesSumNegatives(input));
        }
    }
}
