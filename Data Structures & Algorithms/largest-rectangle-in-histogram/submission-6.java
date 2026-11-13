class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Bar> bars = new ArrayDeque<>();
        int max = 0;

        int prevH = 0;
        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int start = i;
            
            Bar top = top(bars);
            while(top != null && top.h > h) {
                start = top.start;
                max = Math.max(max, top.square(i));
                bars.removeFirst();
                top = top(bars);
            }

            if (top == null || top.h != h) {
                bars.addFirst(new Bar(h, start));
            }

            prevH = h;
        }

        for (var bar : bars) {
            max = Math.max(max, bar.square(heights.length));
        }

        return max;
    }

    private Bar top(Deque<Bar> deque) {
        if (deque.isEmpty()) {
            return null;
        }
        return deque.getFirst();
    }

    private record Bar(int h, int start) {
        private int square(int currIndex) {
            return h * (currIndex - start);
        }
    }
}
