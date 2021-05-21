// [전략] 원형 큐를 이용하여 문제를 해결해보자

class MovingAverage {

    /** Initialize your data structure here. */

    private int[] circleWindow;
    private int windowSize;
    private int sum = 0;
    private int frontIdx = 0;

    public MovingAverage(int size) {
        circleWindow = new int[size];
        windowSize = size;
    }

    public double next(int val) {

        int devidedFrontIdx = getFrontIdx();
        if (frontIdx >= windowSize) {
            sum -= circleWindow[devidedFrontIdx];
        }

        sum += val;
        circleWindow[devidedFrontIdx] = val;
        frontIdx++;

        return calculateAvg();
    }

    private int getFrontIdx() {
        return frontIdx % windowSize;
    }

    public double calculateAvg() {

        if (frontIdx <= windowSize) {
            return sum / (double) frontIdx;
        }
        return sum / (double) windowSize;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size); double param_1 = obj.next(val);
 */