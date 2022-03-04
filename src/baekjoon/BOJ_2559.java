package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2559 {

    private static int N;
    private static int K;
    private static int[] temperature;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        temperature = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            temperature[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int max = 0;
        for (int i = 0; i < (N - K) + 1; i++) {
            int sum = 0;
            for (int j = i; j < K + i; j++) {
                sum += temperature[j];
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}

