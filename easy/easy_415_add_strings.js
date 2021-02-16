/**
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 */
let addStrings = function(num1, num2) {
    
    let sum = '';
    let i = num1.length - 1;
    let j = num2.length - 1;

    let carrige = 0;
    for (; i >= 0 || j >= 0;){
        let x = i >= 0 ? num1[i] - '0' : 0;
        let y = j >= 0 ? num2[j] - '0' : 0;
        
        let tempSum = carrige + x + y;
        sum = (tempSum % 10) + sum;
        
        //carrige = Math.trunc(tempSum / 10);
        carrige = (tempSum / 10)>>0; //소수점 제거 비트 연산. Math.trunc(tempSum / 10) 보다 빠름
        i--;
        j--;
    }

    return sum;
};

console.log(addStrings(
    "9333852702227987", "85731737104263"));