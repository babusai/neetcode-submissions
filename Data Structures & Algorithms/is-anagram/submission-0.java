class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] frequency = new int[26];

        for(int index = 0; index < s.length(); index++) {
            frequency[s.charAt(index) - 'a']++;
            frequency[t.charAt(index) - 'a']--;
        }

        for(int count:frequency) {
            if(count != 0) {
                return false;
            }
        }

        return true;
    }
}