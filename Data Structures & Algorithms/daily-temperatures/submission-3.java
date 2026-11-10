class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        int[] nonResolved = new int[temperatures.length];
        int head = -1;

        for (int i = 0; i < temperatures.length; i++) {
            int curr = temperatures[i];

            while(head >= 0 && curr > temperatures[nonResolved[head]]) {
                int j = nonResolved[head--];
                result[j] = i - j;
            }

            nonResolved[++head] = i;
        }

        return result;
    }
}
