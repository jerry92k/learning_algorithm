
let reverse = function(x) {
    
    //let maxVal=Math.pow(2, 31);
    let maxVal=2147483647;
    let isMinus=false;
    if(x<0) // if minus
    {
        // if(x<(maxVal*-1)){ // 양수로 전환했을때 overflow 될 것임
        //     return 0;
        // }
        x=x*-1 // 계산 편의를 위해 양수로 치환한후 마지막에 부호를 바꿔주자
        isMinus=true;
        maxVal=maxVal+1;
    }

    let revVal=0;
    let rest=0;

    for(let i=0; x/10>=1; i++){
        
        rest=x%10; // 끝에서 부터 10으로 리버스할 1의 자리를 만듬
        revVal=revVal*10 + rest; // 이전에 변환된건 10을 곱해서 쉬프트해주고
        x=Math.trunc(x/10); // 소수점 이하 절사
 
    }
 

    let maxRest=maxVal%10;

    // 마지막 일의 자리에 x 더하기. 
    // overflow 방지를 위해 다음을 체크해야함. revVal*10 + x > maxVal 
    // ==> revVal > maxVal/10  && x> maxRest  : 십의자리 먼저 비교한후, 동일한 경우 일의자리도 비교하도록 체크.
    // 나눠서 체크하는 이유 ? ex) 2454 1, 2450 7 인 경우에 revVal + x > maxVal/10  + maxRest 로 하면 잘못된 계산됨.
   

    if(revVal < maxVal/10 || (revVal == maxVal/10 && x<=maxRest)){
        revVal=revVal*10+x // 이전에 변환된건 10을 곱해서 쉬프트해주고 1의 자리에 더함
    }
    else {
        return 0;
    }

    if(isMinus){
        revVal=revVal*-1;
    }

    return revVal;
};

let input=900000;
console.log(reverse(input));