package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String target = reader.readLine();

        if (target.contains("1") && target.contains("0")) {
            Stack<StringBuilder> stack = new Stack<>();
            String[] split = target.split("");

            for (String number : split) {
                if (stack.isEmpty()) {
                    stack.push(new StringBuilder(number));
                    continue;
                }
                StringBuilder peekNumber = stack.peek();
                if (peekNumber.substring(0, 1).equals(number)) {
                    stack.push(stack.pop().append(number));
                } else {
                    stack.push(new StringBuilder(number));
                }
            }
            System.out.println(stack.size() / 2);
        } else {
            System.out.println(0);
        }
    }
}
