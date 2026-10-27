class Solution {

    private static final int NOT_FOUND_ALPHANUMERIC = -1;

    public boolean isPalindrome(String s) {
        int i = -1;
        int j = s.length();

        do {
            i = getNextAlphanumericIndex(s, i);
            j = getPrevAlphanumericIndex(s, j);
        } while(i < j && sameChar(s.charAt(i), s.charAt(j)));

        return i >= j || i == NOT_FOUND_ALPHANUMERIC;
    }

    private int getNextAlphanumericIndex(String s, int i) {
        do {
            i++;
            if (i >= s.length()) {
                return NOT_FOUND_ALPHANUMERIC;
            }
        } while(isNotAlphanumeric(s.charAt(i)));
        return i;
    }

    private int getPrevAlphanumericIndex(String s, int i) {
        do {
            i--;
            if (i < 0) {
                return NOT_FOUND_ALPHANUMERIC;
            }
        } while(isNotAlphanumeric(s.charAt(i)));
        return i;
    }

    private boolean isNotAlphanumeric(char c) {
        return !Character.isAlphabetic(c) && !Character.isDigit(c);
    }

    private boolean sameChar(char a, char b) {
        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }
}
