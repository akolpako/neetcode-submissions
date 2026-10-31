class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Chars = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Chars[s1.charAt(i) - 'a']++;
        }

        int left = s1.length();
        int windowStart = 0;
        int i = 0;

        do {
            char c = s2.charAt(i);
            boolean extracted = false;
            if (s1Chars[c - 'a'] > 0) {
                s1Chars[c - 'a']--;
                left--;
                if (left == 0) {
                    return true;
                }
                extracted = true;
            }

            if (extracted) {
                i++;
            } else {
                if (i != windowStart) {
                    left++;
                    s1Chars[s2.charAt(windowStart) - 'a']++;
                }

                windowStart++;
                if (i < windowStart) {
                    i = windowStart;
                }
            }
        } while(i < s2.length());

        return false;
    }
}
