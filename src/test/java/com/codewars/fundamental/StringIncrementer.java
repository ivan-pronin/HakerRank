package com.codewars.fundamental;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * //TODO javadocs.
 *
 * @author Ivan Pronin
 * @since 05.11.2022
 */
public class StringIncrementer {

    public static String incrementString(String str) {
        System.out.println(str);
        if (!str.matches(".*\\d")) {
            return str + "1";
        }
        String[] parts = str.split("[^\\d]");
        var start = "";
        BigInteger n = null;
        String cleaned = null;
        if (parts.length!=0) {
            cleaned = parts[parts.length - 1];
            n = new BigInteger(cleaned);
            start = str.substring(0, str.lastIndexOf(cleaned));
        } else {
            cleaned = str;
            n = new BigInteger(cleaned);
            start = "";
        }
        n = n.add(BigInteger.ONE);
        var size = cleaned.length();
        var numberSize = String.valueOf(n).length();

        if (numberSize <= size) {
            cleaned = cleaned.substring(0, size - numberSize) + "" + n;
        } else {
            cleaned = "" + n;
        }
        return start + cleaned;
    }

    private static void doTest(String str, String expected) {
        assertEquals(expected, StringIncrementer.incrementString(str), "input: <" + str + ">");
    }

    @Test
    public void exampleTests() {
        doTest("|K0^!!.17404739996129358935203192", "|K0^!!.17404739996129358935203193");
        doTest("n!YVwd!#ZUP;wblw^7%p}4$F@%z", "n!YVwd!#ZUP;wblw^7%p}4$F@%z1");
        doTest("{{]aMShVaNa*ou#<h?,P29110607494845110643", "{{]aMShVaNa*ou#<h?,P29110607494845110644");
        doTest("fo99obar99", "fo99obar100");
        doTest("foobar000", "foobar001");
        doTest("foo", "foo1");
        doTest("foobar001", "foobar002");
        doTest("foobar99", "foobar100");
        doTest("foobar099", "foobar100");
        doTest("", "1");
        doTest("1", "2");
        doTest("009", "010");
    }
}
