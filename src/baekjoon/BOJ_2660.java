package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_2660 {

        static final int INF = 987654321;
        private static int memberCnt;
        private static int[][] map;
        private static int[] score;
        private static int readerScore;

        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            memberCnt = Integer.parseInt(bufferedReader.readLine());

            map = new int[memberCnt + 1][memberCnt + 1];
            score = new int[memberCnt + 1];

            for (int i = 1; i <= memberCnt; i++) {
                for (int j = 1; j <= memberCnt; j++) {
                    if (i != j) {
                        map[i][j] = INF;
                    }
                }
            }

            String input;
            while (!(input = bufferedReader.readLine()).equals("-1 -1")) {
                String[] nodes = input.split(" ");
                int friendA = Integer.parseInt(nodes[0]);
                int friendB = Integer.parseInt(nodes[1]);

                map[friendA][friendB] = 1;
                map[friendB][friendA] = 1;
            }

            for (int skip = 1; skip <= memberCnt; skip++) {
                for (int i = 1; i <= memberCnt; i++) {
                    for (int j = 1; j <= memberCnt; j++) {
                        if (map[i][j] > map[i][skip] + map[skip][j]) {
                            map[i][j] = map[i][skip] + map[skip][j];
                        }
                    }
                }
            }

            readerScore = INF;

            for (int i = 1; i <= memberCnt; i++) {
                int max = 0;
                for (int j = 1; j <= memberCnt; j++) {
                    if (map[i][j] != INF) {
                        max = Math.max(max, map[i][j]);
                    }
                }

                score[i] = max;
                readerScore = Math.min(readerScore, max);
            }

            ArrayList<Integer> readers = new ArrayList<>();
            for (int i = 1; i < score.length; i++) {
                if (score[i] == readerScore) {
                    readers.add(i);
                }
            }

            System.out.println(readerScore + " " + readers.size());
            for (int i = 0; i < readers.size(); i++) {
                System.out.print(readers.get(i) + " ");
            }
        }
    }

