package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2609 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int gcd = gcd(a, b);
        int lcm = lcm(a, b, gcd);

        System.out.println(gcd);
        System.out.println(lcm);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        int remain = Math.max(a, b) % Math.min(a, b);

        return gcd(Math.min(a, b), remain);
    }

    public static int lcm(int a, int b, int divide) {
        return a * b / divide;
    }

}

