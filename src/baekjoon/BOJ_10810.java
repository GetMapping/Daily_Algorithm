package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] first = bufferedReader.readLine().split(" ");
        int bucketCnt = Integer.parseInt(first[0]);
        int inputCnt = Integer.parseInt(first[1]);

        int[] buckets = new int[bucketCnt + 1];

        for (int i = 0; i < inputCnt; i++) {
            String input = bufferedReader.readLine();
            String[] inputs = input.split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            int ball = Integer.parseInt(inputs[2]);

            for (int j = start; j <= end; j++) {
                buckets[j] = ball;
            }
        }

        for (int i = 1; i < buckets.length; i++) {
            System.out.print(buckets[i] + " ");
        }
    }
}
