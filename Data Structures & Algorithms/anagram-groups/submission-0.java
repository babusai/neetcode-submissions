class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> anagramGroupMap = new HashMap<>();
        List<Integer> frequency;
        List<String> group;

        for (int index = 0; index < strs.length; index++) {
            frequency = new ArrayList<>(Collections.nCopies(26, 0));
            for (char ch : strs[index].toCharArray()) {
                frequency.set(ch - 'a', frequency.get(ch - 'a') + 1);
            }
            if (anagramGroupMap.containsKey(frequency)) {
                anagramGroupMap.get(frequency).add(strs[index]);
            } else {
                group = new ArrayList<String>();
                group.add(strs[index]);
                anagramGroupMap.put(frequency, group);
            }
        }

        List<List<String>> anagramGroup = new ArrayList<>(anagramGroupMap.values());

        return anagramGroup;
    }
}
