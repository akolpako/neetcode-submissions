class TimeMap {

    private static final String NO_RESULT = "";
    private final Map<String, List<TimeToVal>> keysToVals;

    public TimeMap() {
        keysToVals = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        var values = keysToVals.computeIfAbsent(key, k -> new ArrayList<>());
        values.addLast(new TimeToVal(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        var values = keysToVals.get(key);
        if (values == null) {
            return NO_RESULT;
        }
        var floorIndex = floor(values, timestamp);
        if (floorIndex < 0) {
            return NO_RESULT;
        }
        return values.get(floorIndex).value();
    }
      

    private int floor(List<TimeToVal> values, int target) {
        int l = 0, r = values.size() - 1;

        while(l <= r) {
            int m = (r - l) / 2 + l;

            int mTime = values.get(m).timestamp();
            if (mTime == target) {
                return m;
            } else if (mTime > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return r;
    }

    private record TimeToVal(int timestamp, String value){};
}
