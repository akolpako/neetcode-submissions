class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        Integer[] tChars = new Integer[52];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (tChars[charIndex(c)] == null) {
                tChars[charIndex(c)] = 0;
            }
            tChars[charIndex(c)]++;
        }

        int missingChars = t.length();
        int r = 0;
        int l = 0;
        int minWindowL = 0;
        int minWindowR = Integer.MAX_VALUE;

        while(r < s.length()) {
            char c = s.charAt(r);
            int ci = charIndex(c);

            int li = charIndex(s.charAt(l));
            if (l < r && (missingChars == 0 || tChars[li] == null || tChars[li] < 0)) {
                if (tChars[li] != null) {
                    if (tChars[li] + 1 > 0) {
                        missingChars++;
                    }
                    tChars[li]++;
                }
                l++;
            } else {
                if (tChars[ci] != null) {
                    if (tChars[ci] - 1 >= 0) {
                        missingChars--;
                    }
                    tChars[ci]--;
                }
                r++;
                if (missingChars == 0) {
                    if (r - l < minWindowR - minWindowL) {
                        minWindowR = r;
                        minWindowL = l;
                    }
                }
            }
        }
        return minWindowR != Integer.MAX_VALUE ? s.substring(minWindowL, minWindowR) : "";
    }

    int charIndex(char c) {
        return c >= 'a' ? c - 'a' : c - 'A' + 26;
    }
}
