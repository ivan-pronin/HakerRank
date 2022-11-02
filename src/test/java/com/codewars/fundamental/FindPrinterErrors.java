/*
 * Copyrights 2020 Playtika Ltd., all rights reserved to Playtika Ltd.
 * privacy+e17bb14d-edc1-4d26-930d-486fcc1ab8fe@playtika.com
 */

package com.codewars.fundamental;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * //TODO javadocs.
 *
 * @author Ivan Pronin
 * @since 02.11.2022
 */
public class FindPrinterErrors {

    public static String printerError(String s) {
        return s.replaceAll("[a-m]", "").length() + "/" + s.length();
        //or
//        public static String printerError(String s) {
//            long errs = s.chars().filter( ch -> ch > 'm').count();
//            return errs+"/"+s.length();
//        }
    }

    // ---------------------------
    private static int randInt(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
    public static String doEx() {
        int i = 0; String res = ""; int n = 0;
        int k = randInt(10, 500);
        while (i < (int)3*k/2) {
            n = randInt(97, 109);
            res += (char)(n);
            i++;
        }
        while (i < 2 * k) {
            if (i % 17 == 0) n = randInt(110, 122); else n = randInt(97, 109);
            res += (char)(n);
            i++;
        }
        return res;
    }
    public static String printerErrorSol(String s) {
        int cnt = 0; int l = s.length();
        for(int i = 0; i < l; i++) {
            int c = (int)s.charAt(i);
            if (c > 109 && c <= 122)
                cnt++;
        }
        return String.valueOf(cnt) + "/" + String.valueOf(l);
    }
    // ---------------------------
    @Test
    public void test() {
        System.out.println("printerError Fixed Tests");
        String s="aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz";
        assertEquals("3/56", FindPrinterErrors.printerError(s));
        s = "kkkwwwaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz";
        assertEquals("6/60", FindPrinterErrors.printerError(s));
        s = "kkkwwwaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyzuuuuu";
        assertEquals("11/65", FindPrinterErrors.printerError(s));
    }
    @Test
    public void test1() {
        System.out.println("100 Random Tests");
        for (int i = 0; i < 200; i++) {
            String s = doEx();
            assertEquals(printerErrorSol(s), FindPrinterErrors.printerError(s));
        }
    }

}
