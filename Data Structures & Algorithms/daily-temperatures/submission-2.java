class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        int[] nonResolved = new int[temperatures.length];
        int head = -1;

        for (int i = 0; i < temperatures.length; i++) {
            int curr = temperatures[i];
            for (int j = head; j >= 0; j--) {
                int toCheckIndex = nonResolved[j];
                int toCheck = temperatures[toCheckIndex];
                if (curr > toCheck) {
                    result[toCheckIndex] = i - toCheckIndex;
                    head--;
                } else {
                    break;
                }
            }
            head++;
            nonResolved[head] = i;
        }

        return result;
    }
}
