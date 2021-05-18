class Solution {
    public int maxProfit(int[] prices) {

        // 21201
        int profitSum = 0;

        int buyPrirce = -1;
        for (int i = 0; i < prices.length; i++) {

            if (buyPrirce == -1) { // 아직 구매 안함
                // 마지막 인덱스가 아니고, 다음 가격이 현재 가격보다 높아질 경우 구매
                if (i < prices.length - 1 && prices[i] < prices[i + 1]) {
                    buyPrirce = prices[i];
                }
            } else { // 구매 후. 팔지 체크
                // 마지막 인덱스 이거나, 다음 가격이 현재 가격보다 낮아질 경우 팔기
                if (i == prices.length - 1 || prices[i] > prices[i + 1]) {
                    profitSum = profitSum + prices[i] - buyPrirce;
                    buyPrirce = -1;
                }
            }
        }
        return profitSum;
    }
}