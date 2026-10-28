class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var values = Arrays.stream(strs)
                .collect(Collectors.groupingBy(
                        this::anagramKey
                )).values();
        return List.copyOf(values);
    }

    public Map<Character, Integer> anagramKey(String s) {
        Map<Character, Integer> key = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Integer counter = key.computeIfAbsent(c, k -> 0);
            key.put(c, ++counter);
        }
        return key;
    }
}
