class TimeMap {
    private Map<String, List<Object[]>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!timeMap.containsKey(key)) {
            List<Object[]> values = new ArrayList<>();
            timeMap.put(key, values);
        }
        timeMap.get(key).add(new Object[] {value, timestamp});
    }

    public String get(String key, int timestamp) {
        List<Object[]> values = timeMap.get(key);

        if (values == null) {
            return "";
        }

        if (timestamp < (Integer) values.get(0)[1]) {
            return "";
        }

        if (timestamp >= (Integer) values.get(values.size() - 1)[1]) {
            return (String) values.get(values.size() - 1)[0];
        }

        int start = 0;
        int end = values.size() - 1;

        int mid;

        do {
            mid = start + (end - start) / 2;

            if ((Integer) values.get(mid)[1] < timestamp) {
                start = mid + 1;
            } else if ((Integer) values.get(mid)[1] > timestamp) {
                end = mid - 1;
            }

        } while (start <= end && (Integer) values.get(mid)[1] != timestamp);

        return (String) (((Integer) values.get(mid)[1] == timestamp) ? values.get(mid)[0]
                                                                     : values.get(end)[0]);
    }
}
