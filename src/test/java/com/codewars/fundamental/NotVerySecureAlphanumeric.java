package com.codewars.fundamental;

import java.util.regex.Pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * //TODO javadocs.
 *
 * @author Ivan Pronin
 * @since 05.11.2022
 */
public class NotVerySecureAlphanumeric {

    public static boolean alphanumeric(String s) {
        if (null==s || s.isBlank()) {
            return false;
        }
        Pattern p = Pattern.compile("[^a-zA-Z[0-9]]");
        return !p.matcher(s).find();
    }

//    public static boolean alphanumeric(String s) {
//        return s.matches("[A-Za-z0-9]+");
//    }

    @Test
    void testValidInput2() {
        Pattern p = Pattern.compile("[a-zA-Z0-9]");
        Pattern p2 = Pattern.compile("[^a-zA-Z]");
        System.out.println(p.matcher("aS1!").matches());
        System.out.println(p.matcher("aS1").matches());
        System.out.println(p.matcher("aS").matches());
        System.out.println(p2.matcher("abc").find());
    }

    @Test
    @DisplayName("Valid input")
    void testValidInput() {
        assertTrue(NotVerySecureAlphanumeric.alphanumeric("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"));
    }

    @DisplayName("Invalid character")
    @ParameterizedTest(name = "Should return false for \"{0}\"")
    @ValueSource(strings = {"", "with space", "with_underscore", "punctuation.", "naïve", "１strangedigit", "emoji😊"})
    void testInvalidChars(String input) {
        assertFalse(NotVerySecureAlphanumeric.alphanumeric(input));
    }
}
