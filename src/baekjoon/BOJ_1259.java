package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1259 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!(input = bufferedReader.readLine()).equals("0")) {
            int center = input.length() / 2;
            String before = input.substring(0, center);
            String after = new StringBuilder(input.substring(center + 1)).reverse().toString();
            if (input.length() % 2 == 0) {
                after = new StringBuilder(input.substring(center)).reverse().toString();
            }

            if (before.equals(after)) {
                System.out.println("yes");
                continue;
            }
            System.out.println("no");
        }
    }

}
