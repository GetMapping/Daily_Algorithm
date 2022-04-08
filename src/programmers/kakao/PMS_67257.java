package programmers.kakao;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class PMS_67257 {

    private static LinkedList<Long> numbers;
    private static LinkedList<String> operators;
    private static LinkedList<String> sortedOp;
    private static Set<String> containOperators;
    private static long answer;

    public static long solution(String expression) {
        answer = 0;
        parsing(expression);
        sortedOp = new LinkedList<>();
        makeSort();
        return answer;
    }

    public static void makeSort() {
        if (sortedOp.size() == containOperators.size()) {
            answer = Math.max(answer, getMoney());
            return;
        }
        for (String op : containOperators) {
            if (sortedOp.contains(op)) {
                continue;
            }
            sortedOp.add(op);
            makeSort();
            sortedOp.remove(op);
        }
    }

    public static long getMoney() {
        LinkedList<Long> tmpNumbers = new LinkedList<>(numbers);
        LinkedList<String> tmpOperators = new LinkedList<>(operators);

        for (String op : sortedOp) {
            while (tmpOperators.contains(op)) {
                int idx = tmpOperators.indexOf(op);
                Long first = tmpNumbers.get(idx);
                Long second = tmpNumbers.get(idx + 1);

                long calculated = calculate(first, second, op);
                tmpNumbers.remove(idx);
                tmpNumbers.remove(idx);
                tmpNumbers.add(idx, calculated);
                tmpOperators.remove(idx);
            }
        }

        return Math.abs(tmpNumbers.get(0));
    }

    public static long calculate(long a, long b, String op) {
        if (op.equals("+")) {
            return a + b;
        } else if (op.equals("-")) {
            return a - b;
        } else {
            return a * b;
        }
    }

    public static void parsing(String expression) {
        numbers = new LinkedList<>();
        operators = new LinkedList<>();
        containOperators = new HashSet<>();

        String[] split = expression.split("");
        StringBuilder number = new StringBuilder();
        for (String str : split) {
            if (str.matches("[0-9]")) {
                number.append(str);
            } else {
                numbers.add(Long.parseLong(number.toString()));
                number.setLength(0);

                operators.add(str);
                containOperators.add(str);
            }
        }

        numbers.add(Long.parseLong(number.toString()));
    }
}

