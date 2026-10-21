class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var values = Arrays.stream(strs)
                .collect(Collectors.groupingBy(
                        this::anagramKey
                )).values();
        return List.copyOf(values);
    }

    public String anagramKey(String s) {
        char[] sChars = s.toCharArray();

        Arrays.sort(sChars);
        
        return new String(sChars);
    }
}
