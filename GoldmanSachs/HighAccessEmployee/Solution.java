package GoldmanSachs.HighAccessEmployee;

// https://leetcode.com/problems/high-access-employees/
import java.util.*;

class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<Integer>> map = new HashMap<>();

        for (List<String> a : access_times) {
            if (!map.containsKey(a.get(0))) {
                map.put(a.get(0), new ArrayList<>());
            }
            char[] s = a.get(1).toCharArray();
            int h = (s[0] - '0') * 10 + s[1] - '0';
            int m = (s[2] - '0') * 10 + s[3] - '0';
            map.get(a.get(0)).add(h * 60 + m);
        }
        List<String> ans = new ArrayList<>();
        for (String key : map.keySet()) {
            List<Integer> val = map.get(key);
            Collections.sort(val);

            for (int i = 0; i < val.size() - 2; i++) {

                if (val.get(i + 2) - val.get(i) <= 59) {
                    ans.add(key);
                    break;
                }
            }
        }

        return ans;
    }
}