
let reverse = function(x) {
    
    //let maxVal=Math.pow(2, 31) => 양수 최대값 : 2^31 -1 = 2147483647
    let maxVal = 2147483647; // 시간단축을 위해 위의 제곱근 계산 대신 바로 최대값을 할당해줌. java 같은 경우는 int max값을 const 한 값으로 가지고 있지만 javascript 경우에는 int의 쵀대값이 명시적으로 없기 때문에 별도로 할당해줌
    let minusMaxVal=(maxVal*-1) -1; // 음수 최소값 : -2^31
    let isMinus=false;
    if(x<0) // if minus
    {
        if (x <= minusMaxVal) {
            return 0;
        }
        /*
         처음에 위의 if문으로 필터를 한 이유는, 음수의 최소값 2147483648이 양수화되면서 overflow가 나는걸 체크하려고 생각해보았는데, 
         음수가 2147483648 보다 작거나 같은 경우는 값이 2147483648인 경우밖에 없고,(그것보다 작으면 overflow로 존재할수 없음) 
         이 경우에는 리버스하는 경우 8이 제일 큰 자리수가 되므로 overflow 되어 로직을 더 수행하지 않아도 됨.
        */
        x=x*-1 // 계산 편의를 위해 양수로 치환한후 마지막에 부호를 바꿔주자
        isMinus=true;
        maxVal=maxVal+1; // 음수인경우 +1
    }
  
    let revVal=0;
    let rest=0;

    for(let i=0; x/10>=1; i++){
        
        rest=x%10; // 끝에서 부터 10으로 리버스할 1의 자리를 만듬
        revVal=revVal*10 + rest; // 이전에 변환된건 10을 곱해서 쉬프트해주고
        x=Math.trunc(x/10); // 소수점 이하 절사
 
    }
 

    let maxRest=maxVal%10;


    /* overflow 방지를 위해 다음을 체크해야함. revVal*10 + x > maxVal 
     ==> revVal > maxVal/10  && x> maxRest  : 십의자리 먼저 비교한후, 동일한 경우 일의자리도 비교하도록 체크.
         10의자리와 1의 자리를 나눠서 체크하는 이유 ? ex) 2454 1, 2450 7 인 경우에 revVal + x > maxVal/10  + maxRest 로 하면 잘못된 계산됨.
    */

    if(revVal < maxVal/10 || (revVal == maxVal/10 && x<=maxRest)){
        revVal=revVal*10+x // 이전에 변환된건 10을 곱해서 쉬프트해주고 마지막 1의 자리를 더함
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