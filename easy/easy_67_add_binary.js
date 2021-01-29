/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
let addBinary = function(a, b) {
    
    let i=a.length-1;
    let j=b.length-1;

    let carrige=0;
    let sum='';
    for(; i>=0 || j>=0; ){

        let subSum=carrige;
        if(i>=0){
            subSum=subSum+(a[i] -'0');
            i--;
        }
        if(j>=0){
            subSum=subSum+(b[j]-'0');
            j--;
        }

        if(subSum>1){
            carrige=1;
            subSum=subSum%2;
        }
        else{
            carrige=0;
        }
        sum=subSum+sum;
    }
    if(carrige>0){
        sum='1'+sum;
    }
    return sum;
};

addBinary('1010','1011');