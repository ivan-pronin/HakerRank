package com.wiki.fundamentals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * //TODO javadocs.
 *
 * @author Ivan Pronin
 * @since 02.11.2022
 */
public class SortTheOdd {

    public static int[] sortArray(int[] array) {
        var oddValues = Arrays.stream(array)
                .filter(i -> i % 2!=0)
                .boxed()
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new));
        for (int i = 0; i < array.length; i++){
            if (array[i] % 2 !=0){
                array[i] = oddValues.poll();
            }
        }
        return array;
    }

    @Test
    public void exampleTest1() {
        assertArrayEquals(new int[]{ 1, 3, 2, 8, 5, 4 }, SortTheOdd.sortArray(new int[]{ 5, 3, 2, 8, 1, 4 }));
    }

    @Test
    public void exampleTest2() {
        assertArrayEquals(new int[]{ 1, 3, 5, 8, 0 }, SortTheOdd.sortArray(new int[]{ 5, 3, 1, 8, 0 }));
    }

    @Test
    public void exampleTest3() {
        assertArrayEquals(new int[]{}, SortTheOdd.sortArray(new int[]{}));
    }
}
