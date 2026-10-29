class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charsCount = new int[26];

        countChars(s, charsCount, amount -> amount + 1);
        countChars(t, charsCount, amount -> amount - 1);

        for (Integer amount : charsCount) {
            if (amount != 0) {
                return false;
            }
        }

        return true;
    }

    private void countChars(String s, 
                            int[] charsCount,
                            CountFunc countFunc) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int indexOfChar = c - 'a';
            charsCount[indexOfChar] = countFunc.apply(
                charsCount[indexOfChar]
            );
        }
    }

    private static interface CountFunc {
        Integer apply(Integer in);
    }
}
