class Solution {

    private static final int BUCKET_COUNT = 10;

    public int[] topKFrequent(int[] nums, int k) {

        int maxCount = Integer.MIN_VALUE;
        int minCount = Integer.MAX_VALUE;
        Map<Integer, Integer> countersStore = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = countersStore.merge(num, 1, Integer::sum);

            maxCount = Math.max(count, maxCount);
            minCount = Math.min(count, minCount);
        }

        return topKFrequent(countersStore, minCount, maxCount, k);
    }

    private int[] topKFrequent(Map<Integer, Integer> countersStore,
                               int minCount, int maxCount, Integer k) {
        List<List<NumToCount>> buckets = new ArrayList<>();

        for (int i = 1; i <= BUCKET_COUNT; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : countersStore.entrySet()) {
            NumToCount nc = new NumToCount(entry.getKey(), entry.getValue());
            int idx = bucketIndex(nc, minCount, maxCount);
            var bucket = buckets.get(idx);
            bucket.add(nc);
        }

        int[] result = new int[k];
        for (int i = BUCKET_COUNT - 1; i >= 0; i--) {
            var bucket = buckets.get(i);
            bucket.sort(Comparator.comparing(NumToCount::count));
            for (int j = bucket.size() - 1; j >= 0; j--) {
                result[k - 1] = bucket.get(j).num();
                k--;
                if (k <= 0) {
                    return result;
                }
            }
        }

        return result;
    }

    record NumToCount(Integer num, Integer count) {}

    private int bucketIndex(NumToCount nc, Integer min, Integer max) {
        return (int) (((long) nc.count() - min) * BUCKET_COUNT / (max - min + 1L));
    }
}
