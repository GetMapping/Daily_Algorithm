package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String target = bufferedReader.readLine();
        String bomb = bufferedReader.readLine();

        while (target.contains(bomb)) {
            target = target.replaceAll(bomb, "");
        }

        if (target.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(target);
        }
    }
}

