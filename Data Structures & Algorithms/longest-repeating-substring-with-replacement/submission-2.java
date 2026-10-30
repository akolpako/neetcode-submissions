class Solution {
    public int characterReplacement(String s, int k) {

        Map<Character, Integer> seen = new HashMap<>();
        int windowStart = 0;
        Character mostFreq = null;
        int replacements = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            mostFreq = add(seen, c);
            replacements = i - windowStart - seen.get(mostFreq) + 1;

            while(k - replacements < 0) {
                Character cToExtract = s.charAt(windowStart);
                mostFreq = extract(seen, cToExtract);
                windowStart++;
                replacements = i - windowStart - seen.get(mostFreq) + 1;
            }

            max = Math.max(max, seen.get(mostFreq) + replacements);
        }

        return max;
    }

    private Character extract(Map<Character, Integer> seen, Character c) {
        Integer count = seen.get(c);
        seen.put(c, --count);
        return mostFreq(seen);
    }

    private Character add(Map<Character, Integer> seen, Character c) {
        Integer count = seen.computeIfAbsent(c, k -> 0);
        seen.put(c, ++count);
        return mostFreq(seen);
    }

    private Character mostFreq(Map<Character, Integer> seen) {
        int max = 0;
        Character mostFreqC = null;

        for (Character c : seen.keySet()) {
            int currCount = seen.get(c);
            if (currCount > max) {
                max = currCount;
                mostFreqC = c;
            }
        }

        return mostFreqC;
    }
}
