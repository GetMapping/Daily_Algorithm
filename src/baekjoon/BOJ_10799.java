package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split("");

        Stack<String> stack = new Stack<>();

        int answer = 0;
        for (int i = 0; i < input.length; i++) {
            String bracket = input[i];
            if (bracket.equals("(")) {
                stack.push(bracket);
                continue;
            }
            if (bracket.equals(")")) {
                stack.pop();
                if (input[i - 1].equals("(")) {
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
