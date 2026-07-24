class Solution {
    public String firstPalindrome(String[] words) {
        for (String s : words) {
            int i = 0, j = s.length() - 1;
            while (i < j && s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }
            if (i >= j) return s;
        }
        return "";
    }
}
