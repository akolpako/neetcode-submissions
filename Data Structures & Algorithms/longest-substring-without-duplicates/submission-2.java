class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int max = 0;
        int windowStart = 0;

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (seen.contains(c)) {
                max = Math.max(seen.size(), max);
                while(s.charAt(windowStart) != c) {
                    seen.remove(s.charAt(windowStart));
                    windowStart++;
                }
                windowStart++;
            }
            seen.add(c);
        }

        return Math.max(seen.size(), max);
    }
}
