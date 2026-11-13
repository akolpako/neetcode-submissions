class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Bar> localMax = new ArrayDeque<>();
        int max = 0;

        int prevH = 0;
        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int start = i;
            if (h < prevH) {
                while(!localMax.isEmpty() && localMax.getFirst().h > h) {
                    start = localMax.getFirst().start;
                    max = Math.max(max, localMax.getFirst().square(i));
                    localMax.removeFirst();
                }
            }

            if (localMax.isEmpty() || localMax.getFirst().h != h) {
                localMax.addFirst(new Bar(h, start));
            }

            prevH = h;
        }

        for (var bar : localMax) {
            max = Math.max(max, bar.square(heights.length));
        }

        return max;
    }

    private class Bar {
        int h;
        int start;

        private Bar(int h, int start) {
            this.h = h;
            this.start = start;
        }

        private int square(int currIndex) {
            return h * (currIndex - start);
        }
    }
}
