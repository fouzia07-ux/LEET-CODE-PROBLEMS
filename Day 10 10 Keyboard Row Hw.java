class Solution {
    public String[] findWords(String[] words) {
        String[] row = {
            "qwertyuiop",
            "asdfghjkl",
            "zxcvbnm"
        };

        java.util.ArrayList<String> ans = new java.util.ArrayList<>();

        for (String word : words) {
            String s = word.toLowerCase();
            String r = "";

            for (String x : row) {
                if (x.indexOf(s.charAt(0)) != -1) {
                    r = x;
                    break;
                }
            }

            boolean ok = true;
            for (char c : s.toCharArray()) {
                if (r.indexOf(c) == -1) {
                    ok = false;
                    break;
                }
            }

            if (ok) ans.add(word);
        }

        return ans.toArray(new String[0]);
    }
}
