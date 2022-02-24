package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_1922 {
    private static int N;
    private static int M;
    private static PriorityQueue<Edge> edges;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());
        M = Integer.parseInt(bufferedReader.readLine());

        edges = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));
        parent = new int[N + 1];

        for (int i = 0; i < M; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            edges.add(new Edge(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])));
        }

        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        int answer = 0;

        while (!edges.isEmpty()) {
            Edge edge = edges.poll();
            int a = edge.getStart();
            int b = edge.getEnd();

            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) {
                continue;
            }

            union(a, b);
            answer += edge.getWeight();
        }

        System.out.println(answer);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
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
