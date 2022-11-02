package com.codewars.fundamental;

import java.net.Inet4Address;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * //TODO javadocs.
 *
 * @author Ivan Pronin
 * @since 02.11.2022
 */
public class BinaryAddition {
    public static String binaryAddition(int a, int b){
        return Integer.toBinaryString(a+b);
    }
// or another option
//    public static String binaryAddition(int a, int b) {
//        int sum = a + b;
//        int bit;
//        String result = "";
//        while (sum != 0) {
//            bit = sum % 2;
//            result = bit + result;
//            sum = sum / 2;
//        }
//        return result;
//    }

    @Test
    @DisplayName("Random tests")
    void randomTests() {
        int top = Integer.MAX_VALUE / 2;
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        for(int i = 0; i < 40; i++) {
            int a = rand.nextInt(top), b = rand.nextInt(top);
            assertEquals(Integer.toBinaryString(a+b), BinaryAddition.binaryAddition(a, b), String.format("a = %d, b = %d", a, b));
        }
    }
}
