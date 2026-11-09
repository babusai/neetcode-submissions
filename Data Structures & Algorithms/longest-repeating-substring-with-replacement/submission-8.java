class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> frequency = new HashMap<>();

        int start = 0;
        Character mostFrequentChar = s.charAt(0);

        Character current;

        int maxLength = 0;
        int windowLength;
        Character begin = s.charAt(0);
        for (int index = 0; index < s.length(); index++) {
            current = s.charAt(index);
            frequency.put(current, frequency.getOrDefault(current, 0) + 1);
            if (!current.equals(mostFrequentChar)
                && frequency.get(current) > frequency.get(mostFrequentChar)) {
                mostFrequentChar = current;
            }
            windowLength = index - start + 1;
            if (windowLength - frequency.get(mostFrequentChar) > k) {
                if (k != 0) {
                    frequency.put(begin, frequency.get(begin) - 1);
                    start++;
                    begin = s.charAt(start);
                    mostFrequentChar = frequentChar(frequency, mostFrequentChar);
                } else {
                    frequency.remove(mostFrequentChar);
                    // frequency.put(current, 1);
                    start = index;
                    begin = s.charAt(start);
                    mostFrequentChar = begin;
                }
            } else {
                maxLength = Math.max(maxLength, windowLength);
            }
        }

        return maxLength;
    }

    Character frequentChar(Map<Character, Integer> frequency, Character mostFrequentChar) {
        Character leader = mostFrequentChar;
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() > frequency.get(mostFrequentChar)) {
                leader = entry.getKey();
                break;
            }
        }

        return leader;
    }
}
