import java.util.Arrays;
import java.util.HashSet;

/*
Given an array of events where events[i] = [startDayi, endDayi].
Every event i starts at startDayi and ends at endDayi.

You can attend an event i at any day d where startTimei <= d <= endTimei.

notice that you can only attend one event at any time d.

Return the maximum number of events you can attend.

Input: events = [[1,2],[2,3],[3,4]]
Output: 3
Explanation: You can attend all the three events.
One way to attend them all is as shown.
Attend the first event on day 1.
Attend the second event on day 2.
Attend the third event on day 3.

*/

// [[1,2],[2,3],[3,4],[1,2]]
/*
[[1,2],[1,2]], [2,3],[3,4]


*/

class Solution {
    public int maxEvents(int[][] events) {

        Arrays.sort(events, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        // boolean[] occupied = new boolean[100001];
        HashSet<Integer> occupied = new HashSet<>();

        for (int i = 0; i < events.length; i++) {
            for (int j = events[i][0]; j <= events[i][1]; j++) {
                if (!occupied.contains(j)) {
                    occupied.add(j);
                    break;
                }

            }
        }
        return occupied.size();
    }
}