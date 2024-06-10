package programmers.kakao;

import java.util.HashMap;
import java.util.Map;

public class PMS_258712 {

    public static int solution(String[] friends, String[] gifts) {
        HashMap<String, Friend> map = new HashMap<>();
        for (String friend : friends) {
            map.put(friend, new Friend(friend));
        }

        for (String gift : gifts) {
            String[] splited = gift.split(" ");
            String giveName = splited[0];

            map.get(giveName).addGiveList(splited[1]);
            map.get(splited[1]).addHaveAmount();
        }

        for (int i = 0; i < friends.length; i++) {
            String target1 = friends[i];
            Friend giveFriend = map.get(target1);
            for (int j = i + 1; j < friends.length; j++) {
                String target2 = friends[j];
                Friend haveFriend = map.get(target2);

                if (giveFriend.containsFriend(target2)) { //t1 ->  t2 선물한적 있는 경우
                    if (haveFriend.containsFriend(target1)) { //서로 선물한적 있는 경우
                        int t1GiveAmount = giveFriend.getGiveList().get(target2);
                        int t2GiveAmount = haveFriend.getGiveList().get(target1);

                        if (t1GiveAmount > t2GiveAmount) { // t1 선물준 적 많은 경우
                            giveFriend.addWill();
                        } else if (t1GiveAmount == t2GiveAmount) { // 서로 선물준 횟수 같을 경우
                            if (giveFriend.getTotalAmount() > haveFriend.getTotalAmount()) {
                                giveFriend.addWill();
                            } else if (giveFriend.getTotalAmount() < haveFriend.getTotalAmount()) {
                                haveFriend.addWill();
                            }
                        } else { // t2 선물 준 적 많은 경우
                            haveFriend.addWill();
                        }
                    } else {  //t1만 선물한적 있는 경우
                        giveFriend.addWill();
                    }
                } else {
                    if (haveFriend.containsFriend(target1)) {
                        haveFriend.addWill();
                    } else {
                        if (giveFriend.getTotalAmount() > haveFriend.getTotalAmount()) {
                            giveFriend.addWill();
                        } else if (giveFriend.getTotalAmount() < haveFriend.getTotalAmount()) {
                            haveFriend.addWill();
                        }
                    }
                }
            }
        }

        int answer = 0;
        for (String friend : friends) {
            Friend target = map.get(friend);
            if (answer < target.getWill()) {
                answer = target.getWill();
            }
        }

        return answer;
    }
}

class Friend {

    private String name;
    private int giveAmount = 0;
    private int haveAmount = 0;
    private Map<String, Integer> giveList = new HashMap<>();
    private int will = 0;

    public Friend(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getTotalAmount() {
        return this.giveAmount - this.haveAmount;
    }

    public Map<String, Integer> getGiveList() {
        return giveList;
    }

    public int getWill() {
        return will;
    }

    public void addGiveList(String name) {
        giveList.putIfAbsent(name, 0);
        giveList.put(name, giveList.get(name) + 1);
        this.giveAmount++;
    }

    public void addHaveAmount() {
        this.haveAmount++;
    }

    public boolean containsFriend(String name) {
        return giveList.containsKey(name);
    }

    public void addWill() {
        this.will++;
    }
}
