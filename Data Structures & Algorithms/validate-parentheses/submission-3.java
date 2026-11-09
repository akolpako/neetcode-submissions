class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        
        char[] brackets = new char[s.length()];

        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
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
                } else if (c == '}' && prev != '{') {
                    return false;
                }
            }
        }
        return i == 0;
    }
}
