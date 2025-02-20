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

public class PrefixToInfix {

    //  convert prefix expression to infix expression
    public static String convertPrefixToInfix(String prefixExpression) {
        Stack<String> stack = new Stack<>(); // turn it into an array of substrings
        String[] tokens = prefixExpression.split("\\s+"); // \\s+ one or more white space

        // Traverse the prefix expression in reverse order
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            if (isOperand(token)) {  // Operand
                stack.push(token);
            } else if (isOperator(token)) {  // Operator
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression");
                }
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String infixExpression = "(" + operand1 + " " + token + " " + operand2 + ")";
                stack.push(infixExpression);
            } else {
                throw new IllegalArgumentException("Invalid token: " + token);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression");
        }

        return stack.pop();
    }

    // Helper function to check if a token is an operand
    private static boolean isOperand(String token) {
        return Character.isLetterOrDigit(token.charAt(0));
    }

    // Helper function to check if a token is an operator
    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
}
