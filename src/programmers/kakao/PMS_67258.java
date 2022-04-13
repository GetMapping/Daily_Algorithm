package programmers.kakao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PMS_67258 {

    private static HashSet<String> kinds;
    private static int[] answer;

    public static void main(String[] args) {
        int[] answer = solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
        int[] answer2 = solution(new String[]{"AA", "AB", "AC", "AA", "AC"});
        int[] answer3 = solution(new String[]{"XYZ", "XYZ", "XYZ"});
        int[] answer4 = solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"});
        System.out.println(answer[0] + " " + answer[1]);
        System.out.println(answer2[0] + " " + answer2[1]);
        System.out.println(answer3[0] + " " + answer3[1]);
        System.out.println(answer4[0] + " " + answer4[1]);
    }

    public static int[] solution(String[] gems) {
        kinds = new HashSet<>(List.of(gems));
        answer = new int[2];
        answer[0] = 1;
        answer[1] = gems.length;
        int[] solve = solve(gems);
        return answer;
    }

    public static int[] solve(String[] gems) {
        for (int slice = kinds.size(); slice <= gems.length; slice++) {
            if (isIn(gems, slice)) {
                return answer;
            }
        }

        return answer;
    }

    public static boolean isIn(String[] gems, int size) {
        for (int i = 0; i < gems.length - size; i++) {
            ArrayList<String> list = new ArrayList<>(kinds);
            for (int j = i; j < i + size; j++) {
                list.remove(gems[j]);
            }
            if (list.isEmpty()) {
                answer[0] = i + 1;
                answer[1] = i + size;
                return true;
            }
        }
        return false;
    }
}
