package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10822 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int answer = Arrays.stream(bufferedReader.readLine().split(","))
            .mapToInt(Integer::parseInt)
            .sum();

        System.out.println(answer);
    }

}
