class Solution {
    public int largestRectangleArea(int[] heights) {
        TreeMap<Integer, Integer> localMax = new TreeMap<>();
        int max = 0;

        int prevH = 0;
        for (int h : heights) {
            if (h < prevH) {
                int len = 0;
                while(!localMax.isEmpty() && localMax.lastKey() > h) {
                    len = Math.max(len, localMax.lastEntry().getValue());
                    max = Math.max(max, localMax.lastEntry().getKey() * len);
                    localMax.remove(localMax.lastKey());
                }
                final int fLen = len;
                localMax.computeIfAbsent(h, k -> fLen);
            }
            localMax.computeIfAbsent(h, k -> 0);
            for (var e : localMax.entrySet()) {
                if (e.getKey() <= h) {
                    localMax.put(e.getKey(), e.getValue() + 1);
                }
            }

            prevH = h;
        }

        for (var e : localMax.entrySet()) {
            max = Math.max(max, e.getKey() * e.getValue());
        }

        return max;
    }
}
