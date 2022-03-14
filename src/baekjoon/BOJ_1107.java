package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1107 {

    private static int target;
    private static int M;
    private static List<Integer> broken;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        target = Integer.parseInt(bufferedReader.readLine());
        M = Integer.parseInt(bufferedReader.readLine());
        broken = new ArrayList<>();

        if (M > 0) {
            String[] input = bufferedReader.readLine().split(" ");
            for (int i = 0; i < M; i++) {
                broken.add(Integer.parseInt(input[i]));
            }
        }

        int answer = Math.abs(target - 100);
        for (int i = 0; i <= 999999; i++) {
            if (!isBreak(i)) {
                int diff = Math.abs(target - i);
                int length = String.valueOf(i).length();
                answer = Math.min(answer, diff + length);
            }
        }

        System.out.println(answer);
    }

    public static boolean isBreak(int number) {
        String[] tmp = String.valueOf(number).split("");

        for (int i = 0; i < tmp.length; i++) {
            if (broken.contains(Integer.valueOf(tmp[i]))) {
                return true;
            }
        }

        return false;
    }
}

