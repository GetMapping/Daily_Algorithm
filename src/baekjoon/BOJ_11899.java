package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_11899 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] target = bufferedReader.readLine().split("");

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < target.length; i++) {

            if (stack.isEmpty()) {
                stack.push(target[i]);
            } else {
                String peek = stack.peek();

                if (peek.equals("(") && target[i].equals(")")) {
                    stack.pop();
                    continue;
                }

                stack.push(target[i]);
            }
        }

        System.out.println(stack.size());
    }
}

