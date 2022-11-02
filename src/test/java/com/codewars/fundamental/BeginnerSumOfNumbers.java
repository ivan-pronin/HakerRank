package com.codewars.fundamental;

import java.util.stream.IntStream;

/**
 * //TODO javadocs.
 *
 * @author Ivan Pronin
 * @since 02.11.2022
 */
public class BeginnerSumOfNumbers {

    public int GetSum(int a, int b)
    {
        IntStream.range(Math.min(a,b), Math.max(a,b) + 1)
                .sum();
        return 0;
    }

}
