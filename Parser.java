/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;

/**
 *
 * @author LENOVO
 */
public class Parser {
//

    private static final String EXPRESSION_TAG = "expr";
    private static final String OPERATOR_TAG = "operator";
    private static final String ATOM_TAG = "atom";
    private static final String VALUE_ATTRIBUTE = "value";
//

    public static String parseXML(String filePath) {
        StringBuilder parsedValues = new StringBuilder();
        String postfix = null; //inirialize as null
        try {

            FileReader reader = new FileReader(filePath);

            StringBuilder xmlContent = new StringBuilder();
            int data;
            while ((data = reader.read()) != -1) { // while there is sth to read
//                System.out.println( (char) data);
                xmlContent.append((char) data);
            }

            reader.close();
            postfix = parseExpression(xmlContent.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return postfix;
    }

    public static String parseExpression(String xmlContent) {
        StringBuilder parsedValues = new StringBuilder();
        int index = 0;
        while (index < xmlContent.length()) { // while in the string
            index = xmlContent.indexOf(EXPRESSION_TAG, index); // finds the pccurence of the tag
            if (index == -1) {
                break;
            }
            index = xmlContent.indexOf("<", index + 1); // Move to the next '<'
            if (index == -1) {
                break;
            }
            String tag = extractTag(xmlContent, index); //finds the tag to know if operand or operator
            String value = extractValue(xmlContent, index); //finds the operator or operand
            if (OPERATOR_TAG.equals(tag)) { //if operator
                parsedValues.append(value).append(" ");
            } else if (ATOM_TAG.equals(tag)) {//if operand
                parsedValues.append(value).append(" ");
            }

        }
        return parsedValues.toString();
    }

    private static String extractTag(String xmlContent, int index) {
        int start = xmlContent.indexOf("<", index); //finds the tag
        int end = xmlContent.indexOf(" ", start); //find the index of the next space, if no space then no attribute
        if (end == -1) { //if no space
            end = xmlContent.indexOf(">", start); //empty, find closing tag
        }
        return xmlContent.substring(start + 1, end); //returns what's  the tag
    }

    private static String extractValue(String xmlContent, int index) { //same process as extrsct tag, using the quotations to find the value inside
        int start = xmlContent.indexOf("\"", index);
        int end = xmlContent.indexOf("\"", start + 1);
        return xmlContent.substring(start + 1, end);
    }

}
