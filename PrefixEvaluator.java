package ds;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
import java.util.Stack;

public class PrefixEvaluator {

    // Function to evaluate a prefix expression
    public static int evaluatePrefix(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split("\\s+");

        // Iterate through the expression in reverse order(bc in prefix operators b4 operands)
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            if (isOperand(token)) {  // Operand
                stack.push(Integer.parseInt(token));
            } else if (isOperator(token)) {  // Operator
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression");
                }
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                int result = applyOperator(token, operand1, operand2); //apply the function
                stack.push(result);
            } else {
                throw new IllegalArgumentException("Invalid token: " + token);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression");
        }

        return stack.pop();
    }

    //  check if a token is an operand
    private static boolean isOperand(String token) {
        return Character.isDigit(token.charAt(0));
    }

    // check if a token is an operator
    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    // method to apply an operator to two operands
    private static int applyOperator(String operator, int operand1, int operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
