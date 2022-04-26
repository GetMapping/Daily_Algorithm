package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_12834 {

    private static HashMap<Integer, List<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken()); // 팀원 수
        int V = Integer.parseInt(stringTokenizer.nextToken()); // 장소의 수
        int E = Integer.parseInt(stringTokenizer.nextToken()); // 도로의 수

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int KIST = Integer.parseInt(stringTokenizer.nextToken());
        int FOOD = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] home = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            home[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        graph = new HashMap<>();
        for (int i = 0; i < E; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());

            graph.putIfAbsent(start, new ArrayList<>());
            graph.putIfAbsent(end, new ArrayList<>());

            graph.get(start).add(new Edge(end, weight));
            graph.get(end).add(new Edge(start, weight));
        }

        int[] distForKist = new int[graph.size() + 1];
        int[] distForFood = new int[graph.size() + 1];

        dijkstra(KIST, distForKist);
        dijkstra(FOOD, distForFood);

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            if (distForKist[home[i]] == Integer.MAX_VALUE) {
                sum -= 1;
            } else {
                sum += distForKist[home[i]];
            }
            if (distForFood[home[i]] == Integer.MAX_VALUE) {
                sum -= 1;
            } else {
                sum += distForFood[home[i]];
            }

            answer += sum;
        }

        System.out.println(answer);
    }

    public static void dijkstra(int destination, int[] dist) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparing(x -> x.weight));

        queue.add(new Edge(destination, 0));
        dist[destination] = 0;

        while (!queue.isEmpty()) {
            Edge poll = queue.poll();
            if (poll.weight > dist[poll.end]) {
                continue;
            }

            List<Edge> edges = graph.get(poll.end);
            for (Edge edge : edges) {
                if (edge.weight + poll.weight < dist[edge.end]) {
                    dist[edge.end] = edge.weight + poll.weight;
                    queue.add(new Edge(edge.end, dist[edge.end]));
                }
            }
        }
    }


    static class Edge {

        int end;
        int weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}

