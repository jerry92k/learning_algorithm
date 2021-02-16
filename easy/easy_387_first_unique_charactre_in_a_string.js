/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
  
    let mapIdx=new Map();

    for(let i=0; i<s.length; i++){
        let temp=mapIdx.get(s[i]);
        if(temp!=null){
            if(temp!=-1){
            mapIdx.set(s[i],-1)
            }
        }else{
            mapIdx.set(s[i],i);
        }
    }

    let mapValues = map.values();
    
    for(let val of mapValues){
        if(val!=-1){
            return val;
        }
    }
    return -1;
};