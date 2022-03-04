package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12933 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split("");

        String[] target = {"q", "u", "a", "c", "k"};
        boolean flag = true;
        int answer = 0;

        while (flag) {
            flag = false;
            int index = 0;

            for (int i = 0; i < input.length; i++) {
                if (input[i].equals("o")) {
                    continue;
                }

                if (target[index].equals(input[i])) {
                    input[i] = "o";
                    index++;
                }

                if (index == 5) {
                    flag = true;
                    index = 0;
                }
            }

            if (flag) {
                answer++;
            }
        }

        if (answer == 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}
