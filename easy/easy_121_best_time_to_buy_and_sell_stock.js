var maxProfit = function(prices) {
    
    let lowVal=prices[0]; // 첫번째 할당
    // let highVal = lowVal;
    
    let maxProfit = 0;
    
    for(let i=1; i<prices.length; i++){
        if (prices[i]<lowVal) {  // 최소값보다 작은 숫자면, 이후의 나오는 숫자들과 이전 최소값보다 항상 큰 차이를 가지기 때문에 lowVal을 바꿔줌
            lowVal = prices[i];
        }  
        else if (prices[i] - lowVal > maxProfit) { // if -> else if 로 변경. 최소값이 변경되는 경우에는 항상 "prices[i] - lowVal" 이 0이므로 if 절을  수행할 필요가 없으므로
            maxProfit = prices[i] - lowVal;
        }

    }

    return maxProfit;   
};