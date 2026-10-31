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
        int windowStart = -1;

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);

            if (s1Chars.containsKey(c)) {
                if (windowStart < 0) {
                    windowStart = i;
                }
                boolean extracted = extractFromLeft(left, c);
                if (extracted) {
                    if (left.isEmpty()) {
                        return true;
                    }
                } else {
                    while(c != s2.charAt(windowStart)) {
                        windowStart = moveForwardWindow(windowStart, s2.charAt(windowStart), left);
                    }
                    windowStart++;
                }
            } else {
                clearLeft(s1Chars, left);
                windowStart = -1;
            }   
        }
        return false;
    }

    private int moveForwardWindow(int windowStart, char windowsStartChar, Map<Character, Integer> left) {
        addToLeft(left, windowsStartChar);
        return windowStart + 1;
    }

    private void clearLeft(Map<Character, Integer> s1Chars,
                           Map<Character, Integer> left) {
        left.clear();
        left.putAll(s1Chars);
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
