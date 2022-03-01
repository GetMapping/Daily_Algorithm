package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10816 {

    private static int N;
    private static int M;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());

        numbers = new int[N];

        String[] input = bufferedReader.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        M = Integer.parseInt(bufferedReader.readLine());

        input = bufferedReader.readLine().split(" ");

        Arrays.sort(numbers);

        for (int i = 0; i < M; i++) {
            int targetNumber = Integer.parseInt(input[i]);
            System.out.print(upperBound(targetNumber) - lowerBound(targetNumber) + " ");
        }
    }

    public static int lowerBound(int targetNumber) {
        int left = 0;
        int right = N;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (targetNumber <= numbers[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static int upperBound(int targetNumber) {
        int left = 0;
        int right = N;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (targetNumber < numbers[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }


}
