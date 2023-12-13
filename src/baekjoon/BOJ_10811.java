package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] command = bufferedReader.readLine().split(" ");
        int bucketCnt = Integer.parseInt(command[0]);
        int retryCnt = Integer.parseInt(command[1]);

        int[] buckets = new int[bucketCnt + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = i;
        }
        for (int i = 0; i < retryCnt; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            Stack<Integer> stack = new Stack<>();
            for (int j = start; j <= end; j++) {
                stack.push(buckets[j]);
            }
            for (int j = start; j <= end; j++) {
                buckets[j] = stack.pop();
            }
        }

        for (int i = 1; i < buckets.length; i++) {
            System.out.print(buckets[i] + " ");
        }
    }
}
