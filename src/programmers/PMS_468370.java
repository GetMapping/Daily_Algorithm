package programmers;

import java.util.HashSet;
import java.util.Set;

class PMS_468370 {

    public static int solution(String message, int[][] spoiler_ranges) {
        // 1.spoiler_ranges에 속하는 단어 구하기
        String[] words = message.split(" ");
        StringBuilder sb = new StringBuilder(message);
        for (int[] spoilerRange : spoiler_ranges) {
            int start = spoilerRange[0];
            int end = spoilerRange[1];

            for (int i = start; i <= end; i++) {
                if (sb.charAt(i) != ' ') {
                    sb.setCharAt(i, '-');
                }
            }
        }
        Set<String> targetWords = new HashSet<>();
        Set<Object> notTargetWords = new HashSet<>();
        String[] blindWords = sb.toString().split(" ");
        for (int i = 0; i < blindWords.length; i++) {
            if (blindWords[i].contains("-")) {
                targetWords.add(words[i]);
            } else {
                notTargetWords.add(words[i]);
            }
        }

        // 2. 범위에 속하는 단어가 중복된게 있는지 확인하기
        int answer = 0;
        for (String targetWord : targetWords) {
            if (!notTargetWords.contains(targetWord)) {
                answer++;
            }
        }

        return answer;
    }
}
