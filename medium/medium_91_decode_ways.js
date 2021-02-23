/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function(s) {

    let preVal=0;

    let hasZero=false;

    let count=0;
    for(let i=0; i<s.length; s++){

        if(Number(s[i])==0){
            if(preVal==0 || preVal>2){
                return 0;
            }
            hasZero=true;
        }
        else{
            i
            f(preVal==1)
        }
        
    }
    count++;
    if(hasZero){
        count--;
    }
    preVal=s[i];

} ;