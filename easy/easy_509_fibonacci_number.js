/**
 * @param {number} n
 * @return {number}
 */

// 재귀로 풀기
let fib2 = function(n) {
    
    if(n==0){
        return 0;
    }
    else if(n==1){
        return 1;
    }
    else{
        return fib(n-1)+fib(n-2);
    }
};


//반복문으로 풀기
let fib = function(n) {
    
    if(n==0){
        return 0;
    }
    else if(n==1){
        return 1;
    }
    else{
        let preVal=1;
        let prepreVal=0;
        let nowVal=1;
       for(let i=2; i<=n; i++ ){
        nowVal=preVal+prepreVal;
        prepreVal=preVal;
        preVal=nowVal;
       }
       return nowVal;
    }
};