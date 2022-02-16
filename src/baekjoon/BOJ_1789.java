package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1789 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long sum = Long.parseLong(bufferedReader.readLine());

        long temp = 0;
        long n = 1;

        while (true) {
            temp += n;
            if (temp > sum) {
                break;
            }
            n++;
        }

        System.out.println(n - 1);
    }

}
