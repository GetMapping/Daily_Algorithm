package programmers.kakao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PMS_67256 {

    private final static String left = "147*";
    private final static String right = "369#";
    private final static String middle = "2580";

    public static String solution(int[] numbers, String hand) {
        List<String> answer = new ArrayList<>();

        String leftLocation = "*";
        String rightLocation = "#";

        for (int n : numbers) {
            if (left.contains(String.valueOf(n))) {
                answer.add("L");
                leftLocation = String.valueOf(n);
            } else if (right.contains(String.valueOf(n))) {
                answer.add("R");
                rightLocation = String.valueOf(n);
            } else {
                int leftCount = getLeftCount(n, leftLocation);
                int rightCount = getRightCount(n, rightLocation);

                if (leftCount < rightCount) {
                    answer.add("L");
                    leftLocation = String.valueOf(n);
                } else if (leftCount == rightCount) {
                    if (hand.equals("left")) {
                        answer.add("L");
                        leftLocation = String.valueOf(n);
                    } else {
                        answer.add("R");
                        rightLocation = String.valueOf(n);
                    }
                } else {
                    answer.add("R");
                    rightLocation = String.valueOf(n);
                }
            }
        }
        return answer.stream().collect(Collectors.joining()).toString();
    }

    public static int getLeftCount(int n, String location) {
        String nString = String.valueOf(n);
        if (middle.contains(location)) {
            return Math.abs(middle.indexOf(nString) - middle.indexOf(location));
        } else {
            return Math.abs(middle.indexOf(nString) - left.indexOf(location)) + 1;
        }
    }

    public static int getRightCount(int n, String location) {
        String nString = String.valueOf(n);
        if (middle.contains(location)) {
            return Math.abs(middle.indexOf(nString) - middle.indexOf(location));
        } else {
            return Math.abs(middle.indexOf(nString) - right.indexOf(location)) + 1;
        }
    }
}

