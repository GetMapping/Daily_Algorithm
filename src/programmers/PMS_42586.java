package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PMS_42586 {

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> days = calculateDays(progresses, speeds);
        ArrayList<Integer> answer = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        int target = 0;
        for (Integer day : days) {
            if (stack.isEmpty()) {
                stack.push(day);
                target = day;
            } else if (target >= day) {
                stack.push(day);
            } else {
                answer.add(stack.size());
                target = day;
                stack.clear();
                stack.push(day);
            }
        }
        if (!stack.isEmpty()) {
            answer.add(stack.size());
        }

        return answer.stream().mapToInt(x -> x).toArray();
    }

    public static List<Integer> calculateDays(int[] progresses, int[] speeds) {
        ArrayList<Integer> days = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] == 0) {
                days.add(day);
            } else {
                days.add(day + 1);
            }
        }
        return days;
    }

}
