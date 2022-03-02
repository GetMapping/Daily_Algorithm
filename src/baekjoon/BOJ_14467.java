package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

class BOJ_14467 {

    private static HashMap<Integer, ArrayList<Integer>> cows;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        cows = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            cows.put(i, new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int cowNumber = Integer.parseInt(input[0]);
            int location = Integer.parseInt(input[1]);

            cows.get(cowNumber).add(location);
        }

        answer = 0;
        count();

        System.out.println(answer);
    }

    public static void count() {
        for (int i = 1; i <= 10; i++) {
            ArrayList<Integer> locations = cows.get(i);
            if (locations.size() == 0) {
                continue;
            }

            Stack<Integer> stack = new Stack<>();

            for (int j = 0; j < locations.size(); j++) {
                if (stack.isEmpty()) {
                    stack.push(locations.get(j));
                } else {
                    if (!stack.peek().equals(locations.get(j))) {
                        answer++;
                        stack.push(locations.get(j));
                    }
                }
            }
        }
    }
}

