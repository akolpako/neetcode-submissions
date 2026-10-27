class Solution {

    private static final String EMPTY_STRING = "";
    private static final char SEPARATOR = '#';

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str.length()).append(SEPARATOR).append(str);
        }

        return builder.toString();
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
