package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ_5086 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();

        while (!line.equals("0 0")) {
            List<Integer> numbers = Arrays.stream(line.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

            int first = numbers.get(0);
            int second = numbers.get(1);
            check(first, second);
            line = bufferedReader.readLine();
        }

    }

    public static void check(int first, int second) {
        if (second % first == 0) {
            System.out.println("factor");
        } else if (first % second == 0) {
            System.out.println("multiple");
        } else {
            System.out.println("neither");
        }
    }
}
