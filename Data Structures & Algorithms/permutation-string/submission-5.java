class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> s1Chars = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            Integer value = s1Chars.computeIfAbsent(s1.charAt(i), k -> 0) + 1;
            s1Chars.put(s1.charAt(i), value);
        }

        Map<Character, Integer> left = new HashMap<>(s1Chars);
        int windowStart = 0;
        int i = 0;

        do {
            char c = s2.charAt(i);
            boolean extracted = extractFromLeft(left, c);

            if (extracted) {
                if (left.isEmpty()) {
                    return true;
                }
                i++;
            } else {
                if (s1Chars.containsKey(s2.charAt(windowStart))) {
                    addToLeft(left, s2.charAt(windowStart));
                }
                windowStart++;
                if (i < windowStart) {
                    i = windowStart;
                }
            }
        } while(i < s2.length());

        return false;
    }

    private boolean extractFromLeft(Map<Character, Integer> left, Character c) {
        if (left.containsKey(c)) {
            Integer newValue = left.get(c) - 1;
            if (newValue == 0) {
                left.remove(c);
            } else {
                left.put(c, newValue);
            }
            return true;
        } else {
            return false;
        }
    }

    private void addToLeft(Map<Character, Integer> left, Character c) {
        if (left.containsKey(c)) {
            Integer newValue = left.get(c) + 1;
            left.put(c, newValue);
        } else {
            left.put(c, 1);
        }
    }
}
