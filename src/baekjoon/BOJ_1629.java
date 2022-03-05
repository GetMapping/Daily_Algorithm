package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1629 {

        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String[] input = bufferedReader.readLine().split(" ");
            double number = Double.parseDouble(input[0]);
            double pow = Double.parseDouble(input[1]);
            int divide = Integer.parseInt(input[2]);
            long answer = ((long) Math.pow(number, pow)) % divide;
            System.out.println(answer);
        }
    }

