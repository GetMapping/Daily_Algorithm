package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] command = bufferedReader.readLine().split(" ");
        int bucketCnt = Integer.parseInt(command[0]);
        int inputCnt = Integer.parseInt(command[1]);

        int[] buckets = new int[bucketCnt + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = i;
        }

        for (int i = 0; i < inputCnt; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int first = Integer.parseInt(input[0]);
            int second = Integer.parseInt(input[1]);

            int temp;
            temp = buckets[first];
            buckets[first] = buckets[second];
            buckets[second] = temp;
        }

        for (int i = 1; i < buckets.length; i++) {
            System.out.print(buckets[i] + " ");
        }
    }
}
