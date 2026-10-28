class Solution {

    private static final int BUCKET_COUNT = 10;

    public int[] topKFrequent(int[] nums, int k) {

        int maxCount = Integer.MIN_VALUE;
        Map<Integer, Integer> countersStore = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = countersStore.merge(num, 1, Integer::sum);

            maxCount = Math.max(count, maxCount);
        }

        return topKFrequent(countersStore, maxCount, k);
    }

    private int[] topKFrequent(Map<Integer, Integer> countersStore,
                               int maxCount, Integer k) {
        List<Integer>[] buckets = new List[maxCount + 1];

        for (Map.Entry<Integer, Integer> entry : countersStore.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            List<Integer> bucket = buckets[count];

            if (bucket == null) {
                bucket = new ArrayList<>();
                buckets[count] = bucket;
            }

            bucket.add(num);
        }

        int[] result = new int[k];
        
        for (int i = buckets.length - 1; i >= 0; i --) {
            List<Integer> bucket = buckets[i];
            if (bucket != null) {
                for (Integer num : bucket) {
                    result[--k] = num;
                    if (k == 0) {
                        return result;
                    }
                }
            }
        }

        return result;
    }
}
