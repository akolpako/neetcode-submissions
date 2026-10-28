class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var values = Arrays.stream(strs)
                .collect(Collectors.groupingBy(
                        this::anagramKey
                )).values();
        return List.copyOf(values);
    }

    public String anagramKey(String s) {
        char[] key = new char[26];
        for (int i = 0; i < s.length(); i++) {
            int alphabetIndex = s.charAt(i) - 'a';
            key[alphabetIndex]++;
        }
        return new String(key);
    }
}
