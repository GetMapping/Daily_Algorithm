package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13305 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine()); // 도시의 개수
        long[] dist = new long[N - 1];
        long[] price = new long[N];

        String[] input = bufferedReader.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            dist[i] = Integer.parseInt(input[i]);
        }

        input = bufferedReader.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            price[i] = Integer.parseInt(input[i]);
        }

        long minPrice = Long.MAX_VALUE;
        long answer = 0;

        for (int i = 0; i < N - 1; i++) {
            if (minPrice > price[i]) {
                answer += dist[i] * price[i];
                minPrice = price[i];
            } else {
                answer += dist[i] * minPrice;
            }
        }

        System.out.println(answer);
    }
}

