class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenExponent = false;
        boolean seenDot = false;
        boolean seenSignAfterExponentOrStart = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '+' || c == '-') {
                // sign only valid at start, or right after 'e'/'E'
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == 'e' || c == 'E') {
                // must have seen a digit before exponent, and no repeated exponent
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                seenDigit = false; // reset — need digits after exponent too
            } else if (c == '.') {
                // no repeated dot, and dot can't come after exponent
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
            } else {
                return false; // any other character is invalid
            }
        }

        return seenDigit;
    }
}
