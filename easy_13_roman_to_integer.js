/**
 * @param {string} s
 * @return {number}
 */
let romanToInt = function(s) {

    let romanMap=new Map();

    romanMap.set('I',1);
    romanMap.set('V',5);
    romanMap.set('X',10);
    romanMap.set('L',50);
    romanMap.set('C',100);
    romanMap.set('D',500);
    romanMap.set('M',1000);

    let len=s.length;
    let sum=romanMap.get(s[len-1]);
    for(let i=len-2; i>=0; i--){
        let preVal=romanMap.get(s[i+1]);
        let curVal=romanMap.get(s[i]);
        if(curVal<preVal) // 앞의 수가 뒤의 수보다 작으면
        {
            sum=sum-curVal;
        }
        else {
            sum=sum+curVal;
        }
    }
    return sum;
};