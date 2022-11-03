package com.codewars.fundamental;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * //TODO javadocs.
 *
 * @author Ivan Pronin
 * @since 03.11.2022
 */
public class TheSupermarketQueue {

//    public static int solveSuperMarketQueue(int[] customers, int n) {
//        int[] result = new int[n];
//        for(int i = 0; i < customers.length; i++){
//            result[0] += customers[i];
//            Arrays.sort(result);
//        }
//        return result[n-1];
//    }

//    public static int solveSuperMarketQueue(int[] customers, int n) {
//        PriorityQueue<Integer> q = new PriorityQueue<>();
//        for (int i = 0; i < n; i++)
//            q.add(0);
//        for (int t : customers)
//            q.add(q.remove() + t);
//        return Collections.max(q);
//    }

    public static int solveSuperMarketQueue(int[] customers, int n) {
        if (0 == customers.length){
            return 0;
        }
        Map<Integer, Integer> tills = new HashMap<>();
        int[] timeAtEachTill = new int[n];
        int lowestTime = 0;
        // send first customers to their tills
        for (int customer : customers) {
            System.out.println(" In cust: " + customer + " lowesTime= " + lowestTime + " tills = " + tills + " times = " + Arrays.toString(timeAtEachTill));
            for (int t = 0; t < n; t++) {
                if (timeAtEachTill[t] <= lowestTime) {
                    if (!tills.containsKey(t)) {
                        tills.put(t, customer);
                        timeAtEachTill[t] = customer;
                    } else {
                        tills.put(t, tills.get(t) + customer);
                        timeAtEachTill[t] = tills.get(t);
                    }
                    lowestTime = findLowestTime(timeAtEachTill);
                    System.out.println("Out cust: " + customer + " lowesTime= " + lowestTime +" tills = " + tills + " times = " + Arrays.toString(timeAtEachTill));
                    break;
                }
            }
        }
        return tills.values().stream().mapToInt(i -> i).max().getAsInt();
    }

    private static int findLowestTime(int[] timeAtEachTill) {
        return Arrays.stream(timeAtEachTill).min().getAsInt();
    }

    @Test
    public void testNormalCondition() {
        assertEquals(9, TheSupermarketQueue.solveSuperMarketQueue(new int[] { 2, 2, 3, 3, 4, 4 }, 2));
    }

    @Test
    public void test5NormalCondition() {
        assertEquals(19, TheSupermarketQueue.solveSuperMarketQueue(new int[] {3,1,2,7,1,5,3,6,4,5,5,2,3,6,3,3,1,4,4,7,2,2,5}, 5));
    }

    @Test
    public void testEmptyArray() {
        assertEquals(0, TheSupermarketQueue.solveSuperMarketQueue(new int[] {}, 1));
    }

    @Test
    public void testSingleTillManyCustomers() {
        assertEquals(15, TheSupermarketQueue.solveSuperMarketQueue(new int[] { 1, 2, 3, 4, 5 }, 1));
    }
}
