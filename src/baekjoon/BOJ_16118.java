package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16118 {

    static int N, M;
    static final int INF = 2000000000;
    static List<Edge>[] list = new ArrayList[4001];
    static int[][] wolf = new int[4001][2];
    static int[] fox = new int[4001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            fox[i] = INF;
            Arrays.fill(wolf[i], INF);
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());

            list[start].add(new Edge(end, weight * 2));
            list[end].add(new Edge(start, weight * 2));
        }

        Dijkstra_fox();
        Dijkstra_wolf();

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (fox[i] < Math.min(wolf[i][1], wolf[i][0])) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static void Dijkstra_wolf() {
        Queue<Edge> queue = new PriorityQueue<>();

        wolf[1][0] = 0;
        queue.add(new Edge(1, 0, 0));

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int end = edge.end;
            int weight = edge.weight;
            int rest = edge.rest;

            if (wolf[end][rest] < weight) {
                continue;
            }

            for (Edge nextEdge : list[end]) {
                int nextEnd = nextEdge.end;
                int nextWeight = weight;
                int nextRest = -1;

                if (rest == 1) {
                    nextWeight += nextEdge.weight * 2;
                    nextRest = 0;
                } else {
                    nextWeight += nextEdge.weight / 2;
                    nextRest = 1;
                }

                if (wolf[nextEnd][nextRest] > nextWeight) {
                    wolf[nextEnd][nextRest] = nextWeight;
                    queue.add(new Edge(nextEnd, nextWeight, nextRest));
                }
            }
        }
    }

    static void Dijkstra_fox() {

        Queue<Edge> queue = new PriorityQueue<>();
        fox[1] = 0;

        queue.add(new Edge(1, 0));

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int end = edge.end;
            int weight = edge.weight;

            if (fox[end] < weight) {
                continue;
            }

            for (Edge nextEdge : list[end]) {
                int nextEnd = nextEdge.end;
                int nextWeight = weight + nextEdge.weight;

                if (fox[nextEnd] > nextWeight) {
                    fox[nextEnd] = nextWeight;

                    queue.add(new Edge(nextEnd, nextWeight));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {

        int end;
        int weight;
        int rest;

        public Edge(int target, int dist) {
            end = target;
            weight = dist;
        }

        public Edge(int target, int dist, int rest) {
            this(target, dist);
            this.rest = rest;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }
}

