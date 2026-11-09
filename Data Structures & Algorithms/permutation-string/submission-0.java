class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] first = new int[26];

        for (int index = 0; index < s1.length(); index++) {
            first[s1.charAt(index) - 'a']++;
        }

        int[] second = new int[26];
        for (int index = 0; index < s1.length(); index++) {
            second[s2.charAt(index) - 'a']++;
        }

        String s1Frequency = Arrays.toString(first);
        for (int index = s1.length(); index < s2.length(); index++) {
            if (s1Frequency.equals(Arrays.toString(second))) {
                return true;
            }
            second[s2.charAt(index) - 'a']++;
            second[s2.charAt(index - s1.length()) - 'a']--;
        }

        return s1Frequency.equals(Arrays.toString(second));
    }
}
