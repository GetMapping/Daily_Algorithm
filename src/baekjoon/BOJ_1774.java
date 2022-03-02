package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1774 {

    static int[] parent;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        Node[] nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            nodes[i] = new Node(i, x, y);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            union(start, end);
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingDouble(x -> x.weight));
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                double weight = distance(nodes[i], nodes[j]);
                queue.add(new Edge(nodes[i].number, nodes[j].number, weight));
            }
        }

        double answer = 0;

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();

            if (find(edge.start) != find(edge.end)) {
                answer += edge.weight;
                union(edge.start, edge.end);
            }
        }

        bw.write(String.format("%.2f", answer) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static double distance(Node nodeA, Node nodeB) {
        return Math.sqrt(Math.pow(nodeA.x - nodeB.x, 2) + Math.pow(nodeA.y - nodeB.y, 2));
    }

    public static int find(int a) {
        if (a == parent[a]) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    static class Edge {

        int start;
        int end;
        double weight;

        Edge(int start, int end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static class Node {

        int number;
        double x;
        double y;

        Node(int number, double x, double y) {
            this.number = number;
            this.x = x;
            this.y = y;
        }
    }
}
