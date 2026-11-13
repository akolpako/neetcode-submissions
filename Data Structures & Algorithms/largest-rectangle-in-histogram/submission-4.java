class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Bar> localMax = new ArrayDeque<>();
        int max = 0;

        int prevH = 0;
        for (int h : heights) {
            int w = 0;
            if (h < prevH) {
                while(!localMax.isEmpty() && localMax.getFirst().h > h) {
                    w = localMax.getFirst().w;
                    max = Math.max(max, localMax.getFirst().square());
                    localMax.removeFirst();
                }
            }

            if (localMax.isEmpty() || localMax.getFirst().h != h) {
                localMax.addFirst(new Bar(h, w));
            } else if (localMax.isEmpty()) {
                localMax.addFirst(new Bar(h, w));
            }
            
            for (var bar : localMax) {
                bar.w++;
            }

            prevH = h;
        }

        for (var bar : localMax) {
            max = Math.max(max, bar.square());
        }

        return max;
    }

    private class Bar {
        int h;
        int w;

        private Bar(int h, int w) {
            this.h = h;
            this.w = w;
        }

        private int square() {
            return h * w;
        }
    }
}
