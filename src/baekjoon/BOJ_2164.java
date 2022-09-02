package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164 {

    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        boolean flag = true;
        while (queue.size() > 1) {
            if (flag) {
                queue.poll();
                flag = false;
                continue;
            }

            Integer card = queue.poll();
            queue.add(card);
            flag = true;
        }

        System.out.println(queue.poll());
    }
}
