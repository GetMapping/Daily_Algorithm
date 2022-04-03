package programmers.kakao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PMS_64065 {

    public int[] solution(String s) {
        List<List<Integer>> lists = parsingInput(s);
        List<Integer> maxLengthArray = makeAnswer(lists);

        return maxLengthArray.stream().mapToInt(i -> i).toArray();
    }

    public List<Integer> makeAnswer(List<List<Integer>> lists) {
        lists.sort(Comparator.comparingInt(List::size));
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < lists.size(); i++) {
            for (Integer number : lists.get(i)) {
                if (!answer.contains(number)) {
                    answer.add(number);
                }
            }
        }
        return answer;
    }

    public List<List<Integer>> parsingInput(String s) {
        String[] split = s.split("");

        StringBuilder sb = new StringBuilder();

        ArrayList<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> tmpList = new ArrayList<>();
        lists.add(tmpList);
        for (int i = 2; i < split.length - 1; i++) {
            String target = split[i];

            if (target.equals("}")) {
                tmpList.add(Integer.valueOf(String.valueOf(sb)));
                sb.setLength(0);

                if (!split[i + 1].equals("}")) {
                    tmpList = new ArrayList<>();
                    lists.add(tmpList);
                }
            }

            if (target.equals(",") && sb.length() != 0) {
                tmpList.add(Integer.valueOf(String.valueOf(sb)));
                sb.setLength(0);
            }

            if (target.matches("[0-9]")) {
                sb.append(target);
                continue;
            }
        }

        return lists;
    }
}

