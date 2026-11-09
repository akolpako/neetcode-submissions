class Solution {
    public boolean isValid(String s) {
        char[] brackets = new char[s.length()];

        int i = 0;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                brackets[i++] = c;
            } else if (i == 0) {
                return false;
            } else {
                char prev = brackets[--i];
                if (c == ')' && prev != '(') {
                    return false;
                } else if (c == ']' && prev != '[') {
                    return false;
                } if (c == '}' && prev != '{') {
                    return false;
                }
            }
        }
        return i == 0;
    }
}
