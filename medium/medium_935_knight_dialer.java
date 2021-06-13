import java.util.*;

class Solution {
    
    public int knightDialer(int n) {

        if (n == 1) {
            return 10;
        }
        int[][] dials = { { 1, 2, 3 }, { 4, 5, 6, }, { 7, 8, 9 }, { -1, 0, -1 }};    

        HashMap<Integer, ArrayList<Integer>> dialstoNextDial = new HashMap<>();
        Queue<Integer> nextDialqueue = new LinkedList<>();
        
        for (int i = 0; i < dials.length; i++) {
            for (int j = 0; j < dials[i].length; j++) {
                if (dials[i][j] < 0) {
                    continue;
                }

                ArrayList<Integer> nextDials = new ArrayList<Integer>();
                //8가지 경우 체크해보기
  
                // -2 up + 1 right
                checkNextDialPossible(dials, i - 2, j + 1, nextDials);
                // -1 up + 2 right
                checkNextDialPossible(dials, i - 1, j + 2, nextDials);

                // 2 up + 1 right
                checkNextDialPossible(dials, i + 2, j + 1, nextDials);
                // 1 up + 2 right
                checkNextDialPossible(dials, i + 1, j + 2, nextDials);

                // -2 up - 1 right
                checkNextDialPossible(dials, i - 2, j - 1, nextDials);
                // -1 up - 2 right
                checkNextDialPossible(dials, i - 1, j - 2, nextDials);
                // 2 up - 1 right
                checkNextDialPossible(dials, i + 2, j - 1, nextDials);
                // 1 up - 2 right
                checkNextDialPossible(dials, i + 1, j - 2, nextDials);

                nextDialqueue.addAll(nextDials);

                dialstoNextDial.put(dials[i][j], nextDials);

            }
        }

       
        for (int k = 3; k <= n; k++) {
            int queueSize=nextDialqueue.size();
            for (int i = 0; i < queueSize; i++) {
                nextDialqueue.addAll(dialstoNextDial.get(nextDialqueue.remove()));
            }
        }
        int divideVal=1000000007;
        return nextDialqueue.size() % divideVal;
    }
    
    public void checkNextDialPossible(int[][] dials, int horizonIdx, int verticalIdx,
            ArrayList<Integer> nextPossibleDials) {
        if (horizonIdx >= 0 && horizonIdx<dials.length && verticalIdx>=0 && verticalIdx < dials[0].length) {
            int nextDial = dials[horizonIdx][verticalIdx];
            if (nextDial >= 0) {
                nextPossibleDials.add(nextDial);
            }
        }
    }


    public int knightDialer2(int n) {

        if (n == 1) {
            return 10;
        }
        int[][] dials = { { 1, 2, 3 }, { 4, 5, 6, }, { 7, 8, 9 }, { -1, 0, -1 } };

        //HashMap<Integer, ArrayList<Integer>> dialstoNextDial = new HashMap<>();
        //Queue<Integer> nextDialqueue = new LinkedList<>();

        int count = 0;
        int divideVal = 1000000007;
        for (int i = 0; i < dials.length; i++) {
            for (int j = 0; j < dials[i].length; j++) {
                if (dials[i][j] < 0) {
                    continue;
                }
                count+=dfsNextDial(dials, i, j, n, 1)% divideVal;
            }
        }

        return count;
    }

    public int dfsNextDial(int[][] dials, int horizonIdx, int verticalIdx, int n, int curTime) {
        
        
        if (horizonIdx >= 0 && horizonIdx < dials.length && verticalIdx >= 0 && verticalIdx < dials[0].length
                && dials[horizonIdx][verticalIdx] >= 0) {
            if (curTime == n) {
                return 1;
            } else {
                return dfsNextDial(dials, horizonIdx - 2, verticalIdx + 1, n, curTime + 1)
                        + dfsNextDial(dials, horizonIdx - 1, verticalIdx + 2, n, curTime + 1)
                        + dfsNextDial(dials, horizonIdx + 2, verticalIdx + 1, n, curTime + 1)
                        + dfsNextDial(dials, horizonIdx + 1, verticalIdx + 2, n, curTime + 1)
                        + dfsNextDial(dials, horizonIdx - 2, verticalIdx - 1, n, curTime + 1)
                        + dfsNextDial(dials, horizonIdx - 1, verticalIdx - 2, n, curTime + 1)
                        + dfsNextDial(dials, horizonIdx + 2, verticalIdx - 1, n, curTime + 1)
                        + dfsNextDial(dials, horizonIdx + 1, verticalIdx - 2, n, curTime + 1);
            }
        }
        return 0;       
    }
}