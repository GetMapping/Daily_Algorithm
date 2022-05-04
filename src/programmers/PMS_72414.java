package programmers;

public class PMS_72414 {

    private static int maxBound;
    private static int advTime;

    public String solution(String play_time, String adv_time, String[] logs) {
        maxBound = formatToSec(play_time);
        advTime = formatToSec(adv_time);

        int[] seeTimes = new int[360000];

        for (String log : logs) {
            String[] times = log.split("-");

            int startTime = formatToSec(times[0]);
            int endTime = formatToSec(times[1]);

            for (int i = startTime; i < endTime; i++) {
                seeTimes[i]++;
            }
        }

        int answer = 0;
        long maxSum = 0;
        long sum = 0;
        for (int i = 0; i < advTime; i++) {
            sum += seeTimes[i];
        }
        maxSum = sum;
        for (int i = advTime; i < maxBound; i++) {
            sum += seeTimes[i] - seeTimes[i - advTime];
            if (sum > maxSum) {
                maxSum = sum;
                answer = i - advTime + 1;
            }
        }

        return secToFormat(answer);
    }

    public static int formatToSec(String time) {
        String[] numbers = time.split(":");

        int hh = Integer.parseInt(numbers[0]) * 3600;
        int mm = Integer.parseInt(numbers[1]) * 60;
        int ss = Integer.parseInt(numbers[2]);

        return hh + mm + ss;
    }

    public static String secToFormat(int time) {
        int tmp = time;

        int hh = (int) (tmp / 3600);
        tmp %= 3600;
        int mm = (int) tmp / 60;
        tmp %= 60;
        int ss = (int) tmp;

        return String.format("%02d:%02d:%02d", hh, mm, ss);
    }

}

