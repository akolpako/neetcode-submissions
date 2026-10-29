class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charsCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charsCount[s.charAt(i) - 'a']++;
            charsCount[t.charAt(i) - 'a']--;
        }

        for (int amount : charsCount) {
            if (amount != 0) {
                return false;
            }
        }

        return true;
    }
}
