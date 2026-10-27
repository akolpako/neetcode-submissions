class Solution {

    private static final String EMPTY_STRING = "";
    private static final char SEPARATOR = '#';
    private static final String SEPARATOR_STR = "#";

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return EMPTY_STRING;
        }

        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(encode(str));
        }

        return builder.toString();
    }

    private String encode(String str) {
        var len = str.length();
        return len + SEPARATOR_STR + str;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        char[] chars = str.toCharArray();

        int i = 0;

        while(i < chars.length) {
            StringBuilder lenStr = new StringBuilder();

            while(chars[i] != SEPARATOR) {
                lenStr.append(chars[i]);
                i++;
            }

            i++;

            int len = Integer.parseInt(lenStr.toString());
            int strEndIndex = i + len;
            StringBuilder decodedString = new StringBuilder(len);

            for (; i < strEndIndex; i++) {
                decodedString.append(chars[i]);
            }
            result.add(decodedString.toString());
        }

        return result;
    }


}
