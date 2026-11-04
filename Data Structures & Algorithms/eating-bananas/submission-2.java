class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int hi = max(piles);

        int lo = 1;

        while(hi - lo > 0) {
            int m = (hi - lo) / 2 + lo;
            if (canConsumeInTime(piles, h, m)) {
                hi = m;
            } else {
                if (lo == m) {
                    break;
                }
                lo = m;
            }
        }
        return hi;
    }

    private int max(int[] piles) {
        int max = piles[0];
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    private boolean canConsumeInTime(int[] piles, int h, int rate) {
        for (int pile : piles) {
            h -= hoursNeededToConsume(pile, rate);
            if (h < 0) {
                return false;
            }
        }
        return true;
    }

    private int hoursNeededToConsume(int pile, int rate) {
        return pile % rate == 0 ? pile / rate : pile / rate + 1;
    }
}
