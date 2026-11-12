class Solution {
    public int evalRPN(String[] tokens) {
        
        Deque<Integer> stack = new ArrayDeque<>();

        Integer first;
        Integer second;
        Integer result = Integer.valueOf(tokens[0]);
        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                second = stack.pop();
                first = stack.pop();

                if ("+".equals(token)) {
                    result = first + second;
                } else if ("-".equals(token)) {
                    result = first - second;
                } else if ("*".equals(token)) {
                    result = first * second;
                } else if ("/".equals(token)) {
                    result = first / second;
                }
                stack.push(result);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return result;
    }
}
