package programmers.kakao;

import java.util.HashMap;

public class PMS_81301 {
    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
        System.out.println(solution("23four5six7"));
        System.out.println(solution("2three45sixseven"));
        System.out.println(solution("123"));
    }
    public static int solution(String s) {
        String answer = s;
        HashMap<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");

        for (String key : map.keySet()) {
            if (answer.contains(key)) {
                answer = answer.replace(key, map.get(key));
            }
        }

        return Integer.parseInt(answer);
    }
}
