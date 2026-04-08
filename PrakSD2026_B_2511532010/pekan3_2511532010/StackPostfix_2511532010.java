package pekan3_2511532010;

import java.util.Scanner;
import java.util.Stack;

public class StackPostfix_2511532010 {

    public static int postfixEvaluate_2511532010(String expression) {
        Stack<Integer> s = new Stack<>();
        Scanner input = new Scanner(expression);

        while (input.hasNext()) {
            if (input.hasNextInt()) {
                s.push(input.nextInt());
            } else {
                String operator = input.next();
                int operand1 = s.pop();
                int operand2 = s.pop();

                if (operator.equals("+")) {
                    s.push(operand2 + operand1);
                } else if (operator.equals("-")) {
                    s.push(operand2 - operand1);
                } else if (operator.equals("*")) {
                    s.push(operand2 * operand1);
                } else if (operator.equals("/")) {
                    s.push(operand2 / operand1);
                }
            }
        }

        input.close();
        return s.pop();
    }

    public static void main(String[] args) {
        System.out.println("hasil postfix= " + postfixEvaluate_2511532010("5 2 4 * + 7 -"));
    }
}