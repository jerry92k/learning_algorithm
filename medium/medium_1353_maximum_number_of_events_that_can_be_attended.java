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


[,,,,]
[1,1] [2,2] [4,4] [3,4] [1,4]
[[1,2],[2,2],[3,3],[3,4],[3,4]]
[2,2],[3,3] [1,2] [3,4],[3,4]


[[1,3],[1,3],[1,3],[3,4]]


[[1,1][4,5][4,7],[7,9],[11,12],[9,13],[16,16],[16,17],[17,18],[16,18],,,[19,19][18,20][20,21][21,23][19,23],[24,28],[25,26][25,26],,,
,,,,,,,,]
,

*/

class Solution {
    public int maxEvents(int[][] events) {

<<<<<<< HEAD
        /*
        [전략]
        1. startDay로 정렬한다
        2. endDay를 지날 startDay가 나올때까지 

        */
        // Arrays.sort(events, (a,b)->Integer.compare(a[0],b[0]));
        Arrays.sort(events, (a, b) -> // a[0] - b[0]==0 ? a[1]-b[1] : a[0]-b[0]);
        
        {
            if (a[0] >= b[1]) {
                return 1;     
            } else {
                if (a[1] - a[0] < b[1] - b[0]) {
                    return -1;
                } else if (a[1] - a[0] > b[1] - b[0]) {
                    return 1;
                } else {
                    return a[0] - b[0];
                }
            }           
        });

        int numOfAttended = 0;
=======
        Arrays.sort(events, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
>>>>>>> 242b88d4f68b3afccdda09594d401b99fdfc601d

        // boolean[] occupied = new boolean[100001];
        HashSet<Integer> occupied = new HashSet<>();

        for (int i = 0; i < events.length; i++) {
<<<<<<< HEAD
            int j = events[i][0];
            int endDay = events[i][1];
            while (j <= endDay) {
                if (!occupied[j]) {
                    occupied[j] = true;
                    numOfAttended++;
=======
            for (int j = events[i][0]; j <= events[i][1]; j++) {
                if (!occupied.contains(j)) {
                    occupied.add(j);
>>>>>>> 242b88d4f68b3afccdda09594d401b99fdfc601d
                    break;
                }

            }
        }
        return occupied.size();
    }
}