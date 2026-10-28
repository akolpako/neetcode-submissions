class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> charsCount = new HashMap<>();

        countChars(s, charsCount, amount -> amount + 1);
        countChars(t, charsCount, amount -> amount - 1);

        for (Integer amount : charsCount.values()) {
            if (amount != 0) {
                return false;
            }
        }

        return true;
    }

    private void countChars(String s, 
                            Map<Character, Integer> charsCount,
                            CountFunc countFunc) {
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Integer amount = charsCount.computeIfAbsent(c, k -> 0);
            amount = countFunc.apply(amount);

            charsCount.put(c, amount);
        }
    }

    private static interface CountFunc {
        Integer apply(Integer in);
    }
}
