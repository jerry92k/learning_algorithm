import java.util.HashMap;

class Logger {

    /** Initialize your data structure here. */

    private HashMap<String, Integer> workTimestamps;

    public Logger() {
        workTimestamps = new HashMap<String, Integer>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp,
     * otherwise returns false. If this method returns false, the message will not
     * be printed. The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {

        if (workTimestamps.containsKey(message)) {
            int lastTimestamp = workTimestamps.get(message);
            if (timestamp < lastTimestamp) {
                return false;
            }
        }

        workTimestamps.put(message, timestamp + 10);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such: Logger obj = new
 * Logger(); boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */