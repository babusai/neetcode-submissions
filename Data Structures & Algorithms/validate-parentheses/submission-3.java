class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Character character;
        for (int index = 0; index < s.length(); index++) {
            character = s.charAt(index);
            if (character == '(' || character == '{' || character == '[') {
                stack.push(character);
            } else if (!stack.isEmpty()
                && ((character == ')' && stack.peek() == '(')
                    || (character == '}' && stack.peek() == '{')
                    || (character == ']' && stack.peek() == '['))) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
