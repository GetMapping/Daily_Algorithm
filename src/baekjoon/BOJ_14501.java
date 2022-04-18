package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14501 {

    private static int maxDay;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        maxDay = Integer.parseInt(bufferedReader.readLine());

        int[] time = new int[maxDay];
        int[] pay = new int[maxDay];
        int[] dp = new int[maxDay + 1];

        for (int i = 0; i < maxDay; i++) {
            String[] input = bufferedReader.readLine().split(" ");

            time[i] = Integer.parseInt(input[0]);
            pay[i] = Integer.parseInt(input[1]);
        }

        for (int i = 0; i < maxDay; i++) {
            if (i + time[i] <= maxDay) {
                dp[i + time[i]] = Math.max(dp[i + time[i]], dp[i] + pay[i]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.println(dp[maxDay]);
    }
}
