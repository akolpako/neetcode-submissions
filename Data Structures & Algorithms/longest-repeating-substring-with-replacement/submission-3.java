class Solution {
    public int characterReplacement(String s, int k) {

        int[] seen = new int[26];
        int windowStart = 0;
        int mostFreq = 0;
        int replacements = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            mostFreq = add(seen, c, mostFreq);
            replacements = i - windowStart - mostFreq + 1;

            while(k - replacements < 0) {
                Character cToExtract = s.charAt(windowStart);
                extract(seen, cToExtract);
                windowStart++;
                replacements = i - windowStart - mostFreq + 1;
            }

            max = Math.max(max, mostFreq + replacements);
        }

        return max;
    }

    private void extract(int[] seen, Character c) {
        Integer count = seen[c - 'A'];
        seen[c - 'A'] = --count;
    }

    private int add(int[] seen, Character c, int mostFreq) {
        Integer count = seen[c - 'A'];
        seen[c - 'A'] = ++count;
        return Math.max(mostFreq, seen[c - 'A']);
    }

    private char toChar(int i) {
        return (char) ('A' + i);
    }
}
