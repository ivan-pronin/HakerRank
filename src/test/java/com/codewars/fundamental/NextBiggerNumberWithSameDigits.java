package com.codewars.fundamental;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * //TODO javadocs.
 *
 * @author Ivan Pronin
 * @since 05.11.2022
 */
public class NextBiggerNumberWithSameDigits {

    //1st solution
    public static long nextBiggerNumber(long n) {
        char[] s = String.valueOf(n).toCharArray();
        for (int i = s.length - 2; i >= 0; i--) {
            for (int j = s.length - 1; j > i; j--) {
                if (s[i] < s[j]) {
                    char tmp = s[i];
                    s[i] = s[j];
                    s[j] = tmp;
                    Arrays.sort(s, i + 1, s.length);
                    return Long.valueOf(String.valueOf(s));
                }
            }
        }
        return -1;
    }

    // 2nd solution
//    public static long nextBiggerNumber(long n) {
//        char[] digits = String.valueOf(n).toCharArray();
//        for (int i = digits.length-1; i > 0; i--) {
//            if (digits[i] > digits[i-1]) {
//                int nBiggerIndex = i;
//                for (int j = digits.length-1; j > i; j--) {
//                    if (digits[j] > digits[i-1]) {
//                        nBiggerIndex = j;
//                        break;
//                    }
//                }
//                char temp = digits[nBiggerIndex];
//                digits[nBiggerIndex] = digits[i-1];
//                digits[i-1] = temp;
//                Arrays.sort(digits, i, digits.length);
//                return Long.parseLong(new String(digits));
//            }
//        }
//        return -1;
//    }

    // 3. My solution
//    public static long nextBiggerNumber(long n) {
//        List<Integer> digits = Arrays.stream(String.valueOf(n).split(""))
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//        int tail = digits.size() - 1;
//        for (int offset = 1; offset <= tail; offset++) {
//            var lastDigits = digits.subList(tail - offset, tail + 1);
//            var coreDigits = digits.subList(0, tail - offset);
//            Set<List<Integer>> permutations = new HashSet<>();
//            heapCollectionsAlgoPrintAllPermutations(lastDigits.size(), lastDigits, permutations);
//            List<Long> tmpResults = new ArrayList<>();
//            for (List<Integer> list : permutations) {
//                var newNumberStr = Stream.of(coreDigits, list)
//                        .flatMap(Collection::stream)
//                        .map(String::valueOf)
//                        .collect(Collectors.joining());
//                var newNumber = Long.parseLong(newNumberStr);
//                if (newNumber > n) {
//                    tmpResults.add(newNumber);
//                }
//            }
//            if (!tmpResults.isEmpty()) {
//                tmpResults.sort(Comparator.naturalOrder());
//                return tmpResults.get(0);
//            }
//        }
//        return -1;
//    }

    private static void swap(List<Integer> input, int i, int j, Set<List<Integer>> results) {
        Collections.swap(input, i, j);
        System.out.println("swapped: " + input);
    }

    static void heapCollectionsAlgoPrintAllPermutations(int n, List<Integer> elements, Set<List<Integer>> results) {
        if (n==1) {
            addPermutation(elements, results);
        } else {
            for (int i = 0; i < n - 1; i++) {
                heapCollectionsAlgoPrintAllPermutations(n - 1, elements, results);
                if (n % 2==0) {
                    swap(elements, i, n - 1, results);
                } else {
                    swap(elements, 0, n - 1, results);
                }
            }
            heapCollectionsAlgoPrintAllPermutations(n - 1, elements, results);
        }
    }

    static void proofHeapCollectionsAlgoPrintAllPermutations(int n, List<Integer> elements, Set<List<Integer>> results) {
        if (n==1) {
            addPermutation(elements, results);
        } else {
            for (int i = 0; i < n; i++) {
                proofHeapCollectionsAlgoPrintAllPermutations(n - 1, elements, results);
                if (n % 2==0) {
                    swap(elements, i, n - 1, results);
                } else {
                    swap(elements, 0, n - 1, results);
                }
            }
//            heapCollectionsAlgoPrintAllPermutations(n - 1, elements, results);
        }
    }

    private static void addPermutation(List<Integer> input, Set<List<Integer>> results) {
        results.add(new ArrayList<>(input));
    }

    public static void main(String[] args) {
//        NextBiggerNumberWithSameDigits.permute(java.util.Arrays.asList(3,4,6,2,1), 0);
//        NextBiggerNumberWithSameDigits.permute(java.util.Arrays.asList(3,4,6), 0, results);
//        NextBiggerNumberWithSameDigits.permute(java.util.Arrays.asList(1,2), 0, results);
//        findPermutation(new int[]{3,6,4}, results);
//        int[] input = new int[]{3,6,4};
//        heapAlgoPrintAllPermutations(input.length, input, results);
        Set<List<Integer>> results = new HashSet<>();
        List<Integer> input = new ArrayList<>(List.of(3, 6, 4));
//        heapCollectionsAlgoPrintAllPermutations(input.size(), input, results);
//        System.out.println(results);
//        results.clear();
        proofHeapCollectionsAlgoPrintAllPermutations(input.size(), input, results);
        System.out.println(results);
    }


    @Test
    public void basicTests() {
        assertEquals(1191302713, NextBiggerNumberWithSameDigits.nextBiggerNumber(1191302371));
//        assertEquals(21, NextBiggerNumberWithSameDigits.nextBiggerNumber(12));
//        assertEquals(531, NextBiggerNumberWithSameDigits.nextBiggerNumber(513));
//        assertEquals(2071, NextBiggerNumberWithSameDigits.nextBiggerNumber(2017));
//        assertEquals(441, NextBiggerNumberWithSameDigits.nextBiggerNumber(414));
//        assertEquals(414, NextBiggerNumberWithSameDigits.nextBiggerNumber(144));
//        assertEquals(19009, NextBiggerNumberWithSameDigits.nextBiggerNumber(10990));
    }
}
