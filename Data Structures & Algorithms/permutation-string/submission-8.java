class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] missing = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            missing[s1.charAt(i) - 'a']++;
        }

        int missingCount = s1.length();
        int windowStart = 0;
        int i = 0;

        do {
            char c = s2.charAt(i);
            if (missing[c - 'a'] > 0) {
                missing[c - 'a']--;
                missingCount--;
                if (missingCount == 0) {
                    return true;
                }
                i++;
            } else {
                if (i != windowStart) {
                    missingCount++;
                    missing[s2.charAt(windowStart) - 'a']++;
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
