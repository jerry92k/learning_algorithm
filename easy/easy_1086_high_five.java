import java.util.HashMap;
import java.util.PriorityQueue;

/* 
최소힙을 priority queue로 구현
- 내부 자료구조는 힙(완전 이진트리)
- 시간 복잡도: O(NLogN)
*/

class Solution {
    public int[][] highFive(int[][] items) {

        int NUM_OF_SOCORE = 5;
        HashMap<Integer, PriorityQueue<Integer>> topFives = new HashMap<Integer, PriorityQueue<Integer>>();

        for (int i = 0; i < items.length; i++) {
            int id = items[i][0];
            int score = items[i][1];
            PriorityQueue<Integer> maxTopFive = topFives.get(id);

            if (maxTopFive == null) {
                maxTopFive = new PriorityQueue<Integer>();
                maxTopFive.add(score);
                topFives.put(id, maxTopFive);
            } else if (maxTopFive.size() < 5) {
                maxTopFive.add(score);
            } else {
                if (maxTopFive.peek() < score) {
                    maxTopFive.poll();
                    maxTopFive.add(score);
                }
            }

        }

        int[][] topfivesResult = topFives.entrySet().stream().map(x -> {
            int[] element = new int[2];
            element[0] = x.getKey();
            element[1] = x.getValue().stream().reduce(0, Integer::sum) / NUM_OF_SOCORE;
            return element;
        }).toArray(int[][]::new);

        return topfivesResult;
        // return null;
    }
}