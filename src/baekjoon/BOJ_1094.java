package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1094 {

    private static PriorityQueue<Integer> queue;
    private static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        target = Integer.parseInt(bufferedReader.readLine());

        queue = new PriorityQueue<>();
        queue.add(64);

        while (true) {
            int sum = sum();
            if (sum == target) {
                System.out.println(queue.size());
                break;
            }

            Integer poll = queue.poll();
            int half = poll / 2;

            if (half + sum() >= target) {
                queue.add(half);
            } else {
                queue.add(half);
                queue.add(half);
            }
        }
    }

    public static int sum() {
        return queue.stream()
            .mapToInt(i -> i)
            .sum();
    }
}

