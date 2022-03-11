package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BOJ_19532 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");

        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int C = Integer.parseInt(input[2]);
        int D = Integer.parseInt(input[3]);
        int E = Integer.parseInt(input[4]);
        int F = Integer.parseInt(input[5]);

        for (int i = -999; i < 1000; i++) {
            for (int j = -999; j < 1000; j++) {
                if (A * i + B * j == C && D * i + E * j == F) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }

    }
}

