/*
 * Copyrights 2020 Playtika Ltd., all rights reserved to Playtika Ltd.
 * privacy+e17bb14d-edc1-4d26-930d-486fcc1ab8fe@playtika.com
 */

package com.wiki.fundamentals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * //TODO javadocs.
 *
 * @author Ivan Pronin
 * @since 29.10.2022
 */
public class HexConverter {

    @Test
    void test(){
//        assertEquals("A", toHex(10));
//        assertEquals("F", toHex(15));
//        assertEquals("100", toHex(256));
//        assertEquals("21", toHex(33));
        assertEquals("FDA", toHex(4058));
//        assertEquals("5EB52", toHex(387922));
    }

    private static String toHex(int value) {
        var result = value % 16;
        if (value - result == 0) {
            return ""+toChar(result);
        }
        System.out.println("value= "+value+ " result= "+ result + " value-result= " +(value - result));
        return toHex((value - result) / 16) + toChar(result);
    }

    private static char toChar(int index) {
      var alpha = "0123456789ABCDEF";
        var c = alpha.charAt(index);
        System.out.println("char: " + c);
        return c;
    }

}
