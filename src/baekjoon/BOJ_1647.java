package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_1647 {

    private static int houseQuantity;
    private static int roadQuantity;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        houseQuantity = Integer.parseInt(input[0]);
        roadQuantity = Integer.parseInt(input[1]);

        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));

        for (int i = 0; i < roadQuantity; i++) {
            input = bufferedReader.readLine().split(" ");
            int targetA = Integer.parseInt(input[0]);
            int targetB = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            queue.add(new Edge(Math.min(targetA, targetB), Math.max(targetA, targetB), weight));
        }

        parent = new int[houseQuantity + 1];
        for (int i = 1; i <= houseQuantity; i++) {
            parent[i] = i;
        }

        int answer = 0;
        int last = 0;
        while (!queue.isEmpty()) {
            Edge poll = queue.poll();
            int a = poll.getStart();
            int b = poll.getEnd();
            int weight = poll.getWeight();

            int rootA = find(a);
            int rootB = find(b);

            if (rootA != rootB) {
                union(a, b);
                answer += weight;
                last = weight;
            }
        }

        System.out.println(answer - last);
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = a;
        }
    }

    public static int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    static class Edge {

        private int start;
        private int end;
        private int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getWeight() {
            return weight;
        }
    }
}
