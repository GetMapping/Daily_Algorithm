package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1924 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");

        int month = Integer.parseInt(input[0]);
        int day = Integer.parseInt(input[1]);

        int[] maxDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 0;

        for (int i = 1; i < month; i++) {
            days += maxDays[i];
        }
        days += day;

        int target = days % 7;
        String[] list = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        System.out.println(list[target]);
    }
}
