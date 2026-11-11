class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        if (t.equals(s)) {
            return t;
        }

        Map<Character, Integer> tFrequencyMap = new HashMap<>();
        Character ch;
        for (int index = 0; index < t.length(); index++) {
            ch = t.charAt(index);
            tFrequencyMap.put(ch, tFrequencyMap.getOrDefault(ch, 0) + 1);
        }

        int start;
        for (start = 0; start < s.length(); start++) {
            ch = s.charAt(start);
            if (tFrequencyMap.containsKey(ch)) {
                break;
            }
        }

        if (start == s.length()) {
            return "";
        }

        Map<Character, Integer> sFrequencyMap = new HashMap<>();
        int end = start;
        int keyMatchCount = 0;
        for (; end < s.length(); end++) {
            ch = s.charAt(end);
            sFrequencyMap.put(ch, sFrequencyMap.getOrDefault(ch, 0) + 1);
            if (tFrequencyMap.containsKey(ch)
                && sFrequencyMap.get(ch).equals(tFrequencyMap.get(ch))) {
                keyMatchCount++;
                if (keyMatchCount == tFrequencyMap.size()) {
                    break;
                }
            }
        }

        if (keyMatchCount != tFrequencyMap.size()) {
            return "";
        }

        while (
            sFrequencyMap.get(s.charAt(start)) > tFrequencyMap.getOrDefault(s.charAt(start), 0)) {
            sFrequencyMap.put(s.charAt(start), sFrequencyMap.get(s.charAt(start)) - 1);
            start++;
        }

        String minWindow = s.substring(start, end + 1);

        while (end < s.length()) {
            end++;

            while (end < s.length() && s.charAt(end) != s.charAt(start)) {
                sFrequencyMap.put(s.charAt(end),sFrequencyMap.getOrDefault(s.charAt(end),0) + 1);
                end++;
            }

            if (end == s.length()) {
                return minWindow;
            }

            start++;
            while (!sFrequencyMap.containsKey(s.charAt(start)) ||
                sFrequencyMap.get(s.charAt(start))
                > tFrequencyMap.getOrDefault(s.charAt(start), 0)) {
                if(sFrequencyMap.containsKey(s.charAt(start))){    
                    sFrequencyMap.put(s.charAt(start), sFrequencyMap.get(s.charAt(start)) - 1);
                }
                start++;
            }

            if (end - start + 1 == t.length()) {
                return s.substring(start, end + 1);
            } else if (end - start + 1 < minWindow.length()) {
                minWindow = s.substring(start, end + 1);
            }
        }

        return minWindow;
    }
}
