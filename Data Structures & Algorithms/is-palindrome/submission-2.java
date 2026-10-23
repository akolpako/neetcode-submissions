class Solution {

    private static final int NOT_FOUND_ALPHANUMERIC = -1;

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();

        int i = -1;
        int j = chars.length;

        do {
            i = getNextAlphanumericIndex(chars, i);
            j = getPrevAlphanumericIndex(chars, j);
        } while(i < j && sameChar(chars[i], chars[j]));

        return i >= j || i == NOT_FOUND_ALPHANUMERIC;
    }

    private int getNextAlphanumericIndex(char[] chars, int i) {
        do {
            i++;
            if (i >= chars.length) {
                return NOT_FOUND_ALPHANUMERIC;
            }
        } while(isNotAlphanumeric(chars[i]));
        return i;
    }

    private int getPrevAlphanumericIndex(char[] chars, int i) {
        do {
            i--;
            if (i < 0) {
                return NOT_FOUND_ALPHANUMERIC;
            }
        } while(isNotAlphanumeric(chars[i]));
        return i;
    }

    private boolean isNotAlphanumeric(char c) {
        return !Character.isAlphabetic(c) && !Character.isDigit(c);
    }

    private boolean sameChar(char a, char b) {
        if (Character.isDigit(a)) {
            return a == b;
        }
        return (a == b) || (a + 32 == b) || (b + 32 == a);
    }
}
