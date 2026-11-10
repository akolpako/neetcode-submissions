class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> nums = new ArrayDeque<>();

        for (String token : tokens) {
            switch (token) {
                case "+": {
                    int n1 = nums.pop();
                    int n2 = nums.pop();
                    nums.push(n2 + n1);
                    break;
                }
                case "-": {
                    int n1 = nums.pop();
                    int n2 = nums.pop();
                    nums.push(n2 - n1);
                    break;
                }
                case "*": {
                    int n1 = nums.pop();
                    int n2 = nums.pop();
                    nums.push(n2 * n1);
                    break;
                }
                case "/": {
                    int n1 = nums.pop();
                    int n2 = nums.pop();
                    nums.push(n2 / n1);
                    break;
                }
                default: {
                    nums.push(Integer.parseInt(token));
                    break;
                }
            }
        }

        return nums.poll();
    }
}
