/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function(n) {
    
    /*
        이전에 나왔던 숫자가 반복되면 loop인걸 확인할수 있음
    */
    let map=new  Map();

    for(; map.get(n)==null; ){ 
        map.set(n,1);

        let number=n;

        let tempSum=0;
        for(; number>0; ){
            let rest= number%10;
            tempSum=tempSum+Math.pow(rest,2);
           // tempSum=tempSum+ (rest*rest)
            number=(number/10)>>0; //10으로 나눈 몫에 비트연산으로 소수점 절사
        }
        if(tempSum==1){
            return true;
        }
        n=tempSum;
    }
    return false;

};