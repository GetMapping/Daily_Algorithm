package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_22864 {

    private static int A;
    private static int B;
    private static int C;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");

        A = Integer.parseInt(input[0]); // 피로도
        B = Integer.parseInt(input[1]); // 일의 처리량
        C = Integer.parseInt(input[2]); // break
        M = Integer.parseInt(input[3]); // 피로도의 최대치

        int sum = 0;
        int success = 0;

        for (int i = 0; i < 24; i++) {
            if (sum + A <= M) {
                sum += A;
                success += B;
            } else {
                if (sum - C < 0) {
                    sum = 0;
                } else {
                    sum -= C;
                }
            }
        }

        System.out.println(success);

    }
}

