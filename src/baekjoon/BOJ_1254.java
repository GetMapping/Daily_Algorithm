package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1254 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String target = bufferedReader.readLine();
        StringBuilder reversed = new StringBuilder(target).reverse();

        int same = 0;
        for (int start = 0; start < target.length(); start++) {
            if (target.substring(start).equals(reversed.substring(0, reversed.length() - start))) {
                same = reversed.length() - start;
                break;
            }
        }

        int answer = (target.length() - same) * 2 + same;

        System.out.println(answer);
    }
}

