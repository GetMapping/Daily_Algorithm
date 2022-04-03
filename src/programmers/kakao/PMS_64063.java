package programmers.kakao;

import java.util.HashMap;

public class PMS_64063 {

    private static HashMap<Long, Long> nextMap;

    public long[] solution(long k, long[] room_number) {
        nextMap = new HashMap<>();
        long[] answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            long emptyRoom = findNextRoom(room_number[i]);
            answer[i] = emptyRoom;
        }

        return answer;
    }

    public static long findNextRoom(long wantRoom) {
        if (!nextMap.containsKey(wantRoom)) {
            nextMap.put(wantRoom, wantRoom + 1);
            return wantRoom;
        }

        long nextRoom = nextMap.get(wantRoom);
        long emptyRoom = findNextRoom(nextRoom);
        nextMap.put(wantRoom, emptyRoom);
        return emptyRoom;
    }
}

