package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrenceAnagram {
    public static void main(String[] args) {

        String str = "aabaabaa";
        String strOccu = "aaba";
        int k = strOccu.length();
        Map<Character, Integer> map = new HashMap<>();
        int distinctCount = 0;
        int occuCount = 0;
        for (int i = 0; i < strOccu.length(); i++) {
            if (!map.containsKey(strOccu.charAt(i))) {
                distinctCount++;
            }
            map.put(strOccu.charAt(i), map.getOrDefault(strOccu.charAt(i), 0) + 1);
        }

        int i = 0, j = 0;
        while (j < str.length()) {
            if (map.containsKey(str.charAt(j))) {
                map.put(str.charAt(j), map.get(str.charAt(j)) - 1);
                if (map.get(str.charAt(j)) == 0) {
                    distinctCount--;
                }
            }
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (distinctCount == 0) {
                    occuCount++;
                }
                if (map.containsKey(str.charAt(i))) {
                    map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
                    if (map.get(str.charAt(i)) == 1)
                        distinctCount++;
                }
                i++;
                j++;
            }
        }
        System.out.println(occuCount);
    }
}
