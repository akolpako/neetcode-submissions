class Solution {
    public int characterReplacement(String s, int k) {

        int[] seen = new int[26];
        int windowStart = 0;
        int mostFreq = 0;
        int replacements = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            mostFreq = add(seen, c, mostFreq);
            replacements = i - windowStart - mostFreq + 1;

            while(k - replacements < 0) {
                char cToExtract = s.charAt(windowStart);
                extract(seen, cToExtract);
                windowStart++;
                replacements = i - windowStart - mostFreq + 1;
            }

            max = Math.max(max, mostFreq + replacements);
        }

        return max;
    }

    private void extract(int[] seen, char c) {
        seen[c - 'A']--;
    }

    private int add(int[] seen, char c, int mostFreq) {
        return Math.max(mostFreq, ++seen[c - 'A']);
    }
}
