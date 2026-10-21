class Solution {

    private static final String SEPARATOR = ";;";
    private static final String ESCAPED_SEPARATOR = "%;";
    private static final String EMPTY_STRING_PLACEHOLDER = "&&";
    private static final String ESCAPED_EMPTY_STRING_PLACEHOLDER = "%&";
    private static final String EMPTY_STRING = "";

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return EMPTY_STRING;
        }
        return strs
            .stream()
            .map(this::escapeSeparators)
            .map(this::escapeEmptyStringPlaceHolders)
            .map(this::placeholdEmptyStrings)
            .collect(Collectors.joining(SEPARATOR));
    }

    public List<String> decode(String str) {
        if (EMPTY_STRING.equals(str)) {
            return List.of();
        }
        return Arrays.stream(str.split(SEPARATOR))
            .map(this::restoreEmptyStrings)
            .map(this::unescapeEmptyStringPlaceHolders)
            .map(this::unescapeSeparators)
            .toList();
    }

    private String escapeSeparators(String s) {
        return s.replaceAll(SEPARATOR, ESCAPED_SEPARATOR);
    }

    private String escapeEmptyStringPlaceHolders(String s) {
        return s.replaceAll(EMPTY_STRING_PLACEHOLDER, ESCAPED_EMPTY_STRING_PLACEHOLDER);
    }

    private String unescapeSeparators(String s) {
        return s.replaceAll(ESCAPED_SEPARATOR, SEPARATOR);
    }

    private String unescapeEmptyStringPlaceHolders(String s) {
        return s.replaceAll(ESCAPED_EMPTY_STRING_PLACEHOLDER, EMPTY_STRING_PLACEHOLDER);
    }

    private String placeholdEmptyStrings(String s) {
        if (s.isEmpty()) {
            return EMPTY_STRING_PLACEHOLDER;
        }
        return s;
    }

    private String restoreEmptyStrings(String s) {
        if (EMPTY_STRING_PLACEHOLDER.equals(s)) {
            return EMPTY_STRING;
        }
        return s;
    }
}
