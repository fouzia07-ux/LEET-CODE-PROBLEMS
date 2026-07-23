import java.util.*;

class Solution {
    public List<String> commonChars(String[] words) {
        int[] min = new int[26];
        Arrays.fill(min, Integer.MAX_VALUE);

        for (String word : words) {
            int[] count = new int[26];
            for (char c : word.toCharArray())
                count[c - 'a']++;

            for (int i = 0; i < 26; i++)
                min[i] = Math.min(min[i], count[i]);
        }

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            while (min[i]-- > 0)
                ans.add("" + (char)(i + 'a'));
        }

        return ans;
    }
}
