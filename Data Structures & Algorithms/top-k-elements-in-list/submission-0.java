class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, AtomicInteger> countersStore = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            var counter = countersStore.computeIfAbsent(num, n -> new AtomicInteger(0));
            counter.incrementAndGet();
        }

        var sortedNumsToCountersDesc = countersStore.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparingInt(AtomicInteger::get).reversed()))
                .toList();
        
        return sortedNumsToCountersDesc.subList(0, k)
                .stream()
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
