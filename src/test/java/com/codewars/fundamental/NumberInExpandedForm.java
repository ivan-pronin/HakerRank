package com.codewars.fundamental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * //TODO javadocs.
 *
 * @author Ivan Pronin
 * @since 03.11.2022
 */
public class NumberInExpandedForm {

    public static String expandedForm(int num){
        String outs = "";
        for (int i = 10; i < num; i *= 10) {
            int rem = num % i;
            outs = (rem > 0) ? " + " + rem + outs : outs;
            num -= rem;
        }
        outs = num + outs;

        return outs;
    }

//    public static String expandedForm(int num)
//    {
//        return IntStream.range(0, String.valueOf(num).length())
//                .mapToObj(x -> String.valueOf( Character.getNumericValue(String.valueOf(num).charAt(x) ) * (int)Math.pow(10, String.valueOf(num).substring(x).length()-1)))
//                .filter(x -> !x.equals("0"))
//                .collect(Collectors.joining(" + "));
//    }

    @Test
    public void basicTests() {
        assertEquals("2", NumberInExpandedForm.expandedForm(2));
        assertEquals("10 + 2", NumberInExpandedForm.expandedForm(12));
        assertEquals("40 + 2", NumberInExpandedForm.expandedForm(42));
        assertEquals("4000000 + 900000 + 80000 + 2000 + 300 + 40 + 2", NumberInExpandedForm.expandedForm(4982342));
    }
    @Test
    public void zerosTests() {
        assertEquals("400000000 + 20000000 + 300000 + 70000 + 20 + 2", NumberInExpandedForm.expandedForm(420370022));
        assertEquals("70000 + 300 + 4", NumberInExpandedForm.expandedForm(70304));
        assertEquals("9000000", NumberInExpandedForm.expandedForm(9000000));
    }

    @Test
    public void bigNumbersTests() {
        assertEquals("400000000 + 3000000 + 30000 + 4000 + 500 + 70 + 3", NumberInExpandedForm.expandedForm(403034573));
    }
}
