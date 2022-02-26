package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String target = bufferedReader.readLine();
        String bomb = bufferedReader.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < target.length(); i++) {
            stack.push(target.charAt(i));
            if (stack.size() >= bomb.length()) {
                boolean flag = true;
                for (int j = 0; j < bomb.length(); j++) {
                    if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (char character : stack) {
            answer.append(character);
        }

        if (answer.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(target);
        }
    }
}

