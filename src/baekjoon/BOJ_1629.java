package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        long number = Long.parseLong(input[0]);
        long exponent = Long.parseLong(input[1]);
        long divide = Integer.parseInt(input[2]);
        long answer = cal(number, exponent, divide);
        System.out.println(answer);
    }

    public static long cal(long number, long exponent, long divide) {
        if (exponent == 0) {
            return 1;
        }

        if (exponent == 1) {
            return number;
        }

        if (exponent % 2 == 0) {
            long n = cal(number, exponent / 2, divide) % divide;

            return (n * n) % divide;
        } else {
            long n = cal(number, exponent / 2, divide) % divide;

            return (((n * n) % divide) * number) % divide;
        }
    }
}

