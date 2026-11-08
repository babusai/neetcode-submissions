class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();

        int start = 0;
        int maxLength = 0;
        for (int index = 0; index < s.length();) {
            if (window.contains(s.charAt(index))) {
                window.remove(s.charAt(start));
                start++;
            } else {
                window.add(s.charAt(index));
                maxLength = Math.max(maxLength, index - start + 1);
                index++;
            }
        }

        return maxLength;
    }
}
