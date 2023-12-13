package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        boolean[] students = new boolean[31];

        for (int i = 0; i < 28; i++) {
            int check = Integer.parseInt(bufferedReader.readLine());
            students[check] = true;
        }

        for (int i = 1; i < students.length; i++) {
            if (!students[i]) {
                System.out.println(i);
            }
        }
    }
}
