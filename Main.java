package com.theironyard;


import java.util.Arrays;

/**
 * Test Driven Development (TDD)
 * Write your tests first and watch them fail.
 * Then write the algorithm and watch the tests pass.
 */
public class Main {
    public static void main(String[] args) {
        ReversePolishCalc rpc = new ReversePolishCalc();
        testRPC(rpc);

        Bubble bubble = new Bubble();
        testBubbleInt(bubble);
        testBubbleString(bubble);
    }

    private static void testRPC(ReversePolishCalc rpc) {
        // Simple test for +
        String rpnExpression = "2.5,4.8,+";
        double expectedResult = 7.3;
        double actualResult = rpc.calculate(rpnExpression);
        checkRPCResult(rpnExpression, expectedResult, actualResult);
        // Simple test for -
        rpnExpression = "18.1,4.8,-";
        expectedResult = 13.3;
        actualResult = rpc.calculate(rpnExpression);
        checkRPCResult(rpnExpression, expectedResult, actualResult);
        // Simple test for *
        rpnExpression = "3.7,5.0,*";
        expectedResult = 18.5;
        actualResult = rpc.calculate(rpnExpression);
        checkRPCResult(rpnExpression, expectedResult, actualResult);
        // Simple test for /
        rpnExpression = "21.0,0.75,/";
        expectedResult = 28.0;
        actualResult = rpc.calculate(rpnExpression);
        checkRPCResult(rpnExpression, expectedResult, actualResult);

        // Test which has many operators
        rpnExpression = "5,1,2,+,4,*,+,3,-";
        expectedResult = 14.0;
        actualResult = rpc.calculate(rpnExpression);
        checkRPCResult(rpnExpression, expectedResult, actualResult);
    }

    private static void checkRPCResult(String expression, double expected, double actual) {
        if (expected == actual) {
            System.out.println("SUCCESS: " + expression + " is " + expected);
        } else {
            System.out.println("ERROR: " + expression + " expected " + expected + " actual " + actual);
        }
    }

    private static void testBubbleInt(Bubble bubble) {
        // Test proper sort of int array
        int[] unsortedInts = {7,6,3,5};
        int[] expectedResult = {3,5,6,7};
        int[] actualResult = bubble.sort(unsortedInts);
        checkBubbleIntResult(unsortedInts, expectedResult, actualResult);
    }

    private static void testBubbleString(Bubble bubble) {
        String[] unsortedStrings = {"A","B","F","D"};
        String[] expectedResult = {"A","B","D","F"};
        String[] actualResult = bubble.sort(unsortedStrings);
        checkBubbleStringResult(unsortedStrings, expectedResult, actualResult);

        unsortedStrings = new String[]{"Zebra", "Giraffe", "Octopus", "Monkey", "Whale", "Bear"};
        expectedResult = new String[]{"Bear", "Giraffe", "Monkey", "Octopus", "Whale", "Zebra"};
        actualResult = bubble.sort(unsortedStrings);
        checkBubbleStringResult(unsortedStrings, expectedResult, actualResult);
    }

    private static void checkBubbleStringResult(String[] unsorted, String[] expected, String[] actual) {
        if (Arrays.equals(expected, actual)) {
            System.out.println("SUCCESS: " + Arrays.deepToString(unsorted) + " sorts to " +
                    Arrays.deepToString(expected));
        } else {
            System.out.println("ERROR: " + Arrays.deepToString(unsorted) + " expected " + Arrays.deepToString(expected)
                    + " -- actual " + Arrays.deepToString(actual));
        }
    }

    private static void checkBubbleIntResult(int[] unsorted, int[] expected, int[] actual) {
        if (Arrays.equals(expected, actual)) {
            System.out.println("SUCCESS: " + Arrays.toString(unsorted) + " sorts to " + Arrays.toString(expected));
        } else {
            System.out.println("ERROR: " + Arrays.toString(unsorted) + " expected " + Arrays.toString(expected) +
                    " -- actual " + Arrays.toString(actual));
        }
    }
}