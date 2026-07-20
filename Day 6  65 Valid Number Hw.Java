class Solution {
    public boolean isNumber(String s) {
        try {
            Double.parseDouble(s.trim());
            return !s.matches(".[dDfF].");
        } catch (Exception e) {
            return false;
        }
    }
}
