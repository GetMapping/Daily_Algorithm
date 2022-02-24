package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_1197 {

    private static int[] parent;
    private static int nodeQuantity;
    private static int edgeQuantity;


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        nodeQuantity = Integer.parseInt(input[0]);
        edgeQuantity = Integer.parseInt(input[1]);

        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));
        for (int i = 0; i < edgeQuantity; i++) {
            input = bufferedReader.readLine().split(" ");
            edges.add(new Edge(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])));
        }

        parent = new int[nodeQuantity + 1];
        for (int i = 1; i <= nodeQuantity; i++) {
            parent[i] = i;
        }

        int answer = 0;
        while (!edges.isEmpty()) {
            Edge target = edges.poll();
            int a = target.getStart();
            int b = target.getEnd();
            int rootA = find(a);
            int rootB = find(b);

            if (rootA != rootB) {
                union(a, b);
                answer += target.getWeight();
            }
        }

        System.out.println(answer);
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = parent[rootA];
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

