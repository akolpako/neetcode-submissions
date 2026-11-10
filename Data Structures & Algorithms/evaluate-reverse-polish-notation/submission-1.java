class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> nums = new ArrayDeque<>();

        for (String token : tokens) {
            switch (token) {
                case "+": {
                    var n1 = nums.poll();
                    var n2 = nums.poll();
                    nums.push(n2 + n1);
                    break;
                }
                case "-": {
                    var n1 = nums.poll();
                    var n2 = nums.poll();
                    nums.push(n2 - n1);
                    break;
                }
                case "*": {
                    var n1 = nums.poll();
                    var n2 = nums.poll();
                    nums.push(n2 * n1);
                    break;
                }
                case "/": {
                    var n1 = nums.poll();
                    var n2 = nums.poll();
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
