/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
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
public class DS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Parser parser = new Parser();
        String filePath = "E:\\Files\\Data Structure Files\\New-File-5.xml";
        String prefix = parser.parseXML(filePath);

        System.out.println("prefix expression:" + prefix);

        PrefixEvaluator evaluator = new PrefixEvaluator();
        PrefixToInfix pretoin = new PrefixToInfix();
        String infix = pretoin.convertPrefixToInfix(prefix);
        System.out.println("infix expression = " + infix);

        int result = evaluator.evaluatePrefix(prefix);
        System.out.println("result = " + result);
//

    }

}
