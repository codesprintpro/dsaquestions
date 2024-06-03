package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacterWithKUniqueCharacter {
    public static void main(String[] args) {
        String str = "aabacbebebe";
        int uniqueCharacterK = 3;
        Map<Character, Integer> uniqueCharactersMap = new HashMap<>();
        int longestStrWithoutRepeatingCharacterWithKUniqueCharacter = 0;

        int i = 0, j = 0;
        while (j < str.length()) {
            //adding or updating character count
            uniqueCharactersMap.put(str.charAt(j), uniqueCharactersMap.getOrDefault(str.charAt(j), 0) + 1);
            j++;
            if (uniqueCharactersMap.size() == j - i) {
                //if the unique character count reached given k, check the size and compare with existing isze of the sub array which was having those unique characters and take max.
                longestStrWithoutRepeatingCharacterWithKUniqueCharacter = Math.max(longestStrWithoutRepeatingCharacterWithKUniqueCharacter, j - i);
            } else if (uniqueCharactersMap.size() < j - i) {
                //if the unique character count becomes more then k iterate and remove from map till unique character count becomes equal or less than k
                while (uniqueCharactersMap.size() < j - i) {
                    uniqueCharactersMap.put(str.charAt(i), uniqueCharactersMap.get(str.charAt(i)) - 1);
                    if (uniqueCharactersMap.get(str.charAt(i)) == 0) {
                        uniqueCharactersMap.remove(str.charAt(i));
                    }
                    i++;
                }
            }
        }

        System.out.println(longestStrWithoutRepeatingCharacterWithKUniqueCharacter);
    }
}
