package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        int count = 0;
        while (n != 1) {
            if (n % 3 == 0) {
                n = n / 3;
                count++;
                continue;
            }

            if (n % 2 == 0) {
                n = n / 2;
                count++;
                continue;
            }

            n--;
            count++;
        }

        System.out.println(count);
    }
}
