package com.theironyard;


public class ReversePolishCalc {

    private int topOfStack = -1;

    private String[] tokens;

    // The stack
    private String[] stack;

//    private String[] OPERATORS = new String[]{"+", "-", "*", "/"};

    public double calculate(String input) {

        // 1. Use the String split method to split the string into tokens at the commas
        tokens = input.split(",");

        // 2. Allocate a stack as big as the number of tokens
        stack =  new String[tokens.length];

        // 3. write the algorithm
        for (int i = 0; i < tokens.length; i++) {
            // calls to push() and pop() and do the math here
            String token = tokens[i];
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                double secondOperand = pop();
                double firstOperand = pop();
                if (token.equals("+")) {
                    push(firstOperand + secondOperand);
                } else if (token.equals("-")) {
                    push(firstOperand - secondOperand);
                } else if (token.equals("*")) {
                    push(firstOperand * secondOperand);
                } else if (token.equals("/")) {
                    push(firstOperand / secondOperand);
                }
            } else {
                push(token);
            }
        }

        // 4. return the result
        return pop();
    }

    private void push(String number) {
        topOfStack++;
        stack[topOfStack] = number;
    }

    private void push(double d) {
        String pushString = String.valueOf(d);
        push(pushString);
    }

    private double pop() {
        double popString = Double.parseDouble(stack[topOfStack]);
        stack[topOfStack] = null;
        if (topOfStack != 0) {
            topOfStack--;
        }
        return popString;
    }
}