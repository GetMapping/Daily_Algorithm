package programmers.kakao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class PMS_64064 {

    private static HashSet<List<String>> result;

    public static void main(String[] args) {
        int answer = solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
            new String[]{"*rodo", "*rodo", "******"});
        System.out.println(answer);
    }

    public static int solution(String[] user_id, String[] banned_id) {
        ArrayList<HashSet<String>> realIds = new ArrayList<>();

        for (int i = 0; i < banned_id.length; i++) {
            HashSet<String> set = new HashSet<>();
            set.addAll(getBannedID(user_id, banned_id[i]));
            realIds.add(set);
        }

        result = new HashSet<>();
        dfs(realIds, new ArrayList<>(), 0);

        return result.size();
    }

    public static void dfs(ArrayList<HashSet<String>> realIds, List<String> tmp, int depth) {
        if (depth == realIds.size()) {
            tmp.sort(Comparator.naturalOrder());
            result.add(new ArrayList<>(tmp));
            return;
        }

        HashSet<String> ids = realIds.get(depth);
        for (String id : ids) {
            if (!tmp.contains(id)) {
                tmp.add(id);
                dfs(realIds, tmp, depth + 1);
                tmp.remove(id);
            }
        }
    }

    public static List<String> getBannedID(String[] userId, String bannedId) {
        ArrayList<String> realIds = new ArrayList<>();
        String[] banned = bannedId.split("");

        for (int i = 0; i < userId.length; i++) {
            String[] target = userId[i].split("");

            if (target.length != bannedId.length()) {
                continue;
            }

            realIds.add(userId[i]);

            for (int j = 0; j < target.length; j++) {
                if (banned[j].equals("*")) {
                    continue;
                }

                if (!banned[j].equals(target[j])) {
                    realIds.remove(userId[i]);
                }
            }
        }

        return realIds;
    }
}
