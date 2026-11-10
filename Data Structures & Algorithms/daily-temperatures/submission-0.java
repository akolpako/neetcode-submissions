class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        int daysDecreasing = 0;
        for (int i = 1; i < temperatures.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (result[j] == 0 && temperatures[i] > temperatures[j]) {
                    result[j] = i - j;
                }
            }
        }

        return result;
    }

    private boolean isDecreasing(int[] temperatures, int i) {
        if (i > 0) {
            return temperatures[i] <= temperatures[i - 1];
        }
        return true;
    }
}
