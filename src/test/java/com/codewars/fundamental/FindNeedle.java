package com.codewars.fundamental;

import java.util.Random;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * //TODO javadocs.
 *
 * @author Ivan Pronin
 * @since 01.11.2022
 */
public class FindNeedle {

    public static String findNeedle(Object[] haystack) {
        return String.format("found the needle at position %d", java.util.Arrays.asList(haystack).indexOf("needle"));
    }

    @Test
    public void basicTests() {
        String msg = "Make sure your basic example test cases work";
        Object[] haystack1 = {"3", "123124234", null, "needle", "world", "hay", 2, "3", true, false};
        Object[] haystack2 = {"283497238987234", "a dog", "a cat", "some random junk", "a piece of hay", "needle", "something somebody lost a while ago"};
        Object[] haystack3 = {1,2,3,4,5,6,7,8,8,7,5,4,3,4,5,6,67,5,5,3,3,4,2,34,234,23,4,234,324,324,"needle",1,2,3,4,5,5,6,5,4,32,3,45,54};
        assertEquals( "found the needle at position 3", FindNeedle.findNeedle(haystack1), msg);
        assertEquals("found the needle at position 5", FindNeedle.findNeedle(haystack2),   msg);
        assertEquals( "found the needle at position 30", FindNeedle.findNeedle(haystack3), msg);
    }

    @Test
    public void randomTests() {
        Random randGen = new Random();
        System.out.println("Testing 25 random haystacks...");
        for (int i = 0; i < 25; i++) {
            Object[] junk = new Object[25];
            int randI = randGen.nextInt(25);
            for (int e = 0; e < 25; e++) {
                if (e == randI)
                    junk[e] = "needle";
                else
                    junk[e] = randGen.nextInt(301);
            }
            var msg = "Try again, didn't find the needle in the right place";
            assertEquals( "found the needle at position " + randI, FindNeedle.findNeedle(junk), msg);
        }
    }

}
