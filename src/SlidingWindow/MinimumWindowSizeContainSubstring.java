package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSizeContainSubstring {
    public static void main(String[] args) {

        String givenStr = "TOTMTAPTAT";
        String subStr = "TAT";
        int k = subStr.length();
        int minStrLength = 0;
        int distinctCount = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < subStr.length(); i++) {
            if (!map.containsKey(givenStr.charAt(i))) {
                distinctCount++;
            }
            map.put(subStr.charAt(i), map.getOrDefault(subStr.charAt(i), 0) + 1);
        }
        System.out.println(map);

        int i = 0, j = 0;

        while (j < givenStr.length()) {

            if (map.containsKey(givenStr.charAt(j))) {
                map.put(givenStr.charAt(j), map.get(givenStr.charAt(j)) - 1);
                if (map.get(givenStr.charAt(j)) == 0) {
                    distinctCount--;
                }
            }
            j++;
            if (distinctCount == 0) {
                while (distinctCount == 0) {
                    if (map.containsKey(givenStr.charAt(i))) {
                        map.put(givenStr.charAt(i), map.get(givenStr.charAt(i)) + 1);
                        if (map.get(givenStr.charAt(i)) > 0) {
                            minStrLength = j - i;
                            distinctCount++;
                        }
                    }
                    i++;
                }
            }
        }
        System.out.println(minStrLength);
    }
}
