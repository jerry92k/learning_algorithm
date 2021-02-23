class Solution {
    public int[][] merge(int[][] intervals) {
        

        //TODO : intervals를 sorting 하자
        ArrayList<int[]> mergeArray= new ArrayList<int[]>();
        // 이전에 저장된 목록중에 겹치게 들어갈수있는게 있는지 확읺본다

        for(int i=0; i<intervals.length; i++){
            int j=0;
            int merLen=mergeArray.size();
            for(; j<merLen; j++){ // 이미 들어가있는 arraylist를 참조함
            int[] mergeItem=mergeArray.get(j);
                // 시작점이 같은경우,  
                if(mergeItem[0]==intervals[i][0] ){
                    if(intervals[i][1]>mergeItem[1]){
                            mergeArray.get(j)[1]=intervals[i][1];
                    }   //같거나 작으면 수정할 필요 없음.
                    break;
                }else if(mergeItem[0]<intervals[i][0] && intervals[i][0]<=mergeItem[1]){ // 시작점보다 큰경우,
                     if(intervals[i][1]>mergeItem[1]){
                            mergeArray.get(j)[1]=intervals[i][1];
                    }   //같거나 작으면 수정할 필요 없음.
                    break;

                }
                else if(mergeItem[0]>intervals[i][0] && intervals[i][1]>=mergeItem[0]){ // 시작점보다 작은경우  
                    mergeArray.get(j)[0]=intervals[i][0];
                    if(intervals[i][1]>mergeItem[1]){
                            mergeArray.get(j)[1]=intervals[i][1];
                    }   //같거나 작으면 수정할 필요 없음.
                    break;
                }     
                // if(mergeItem[1] < intervals[i][0] || mergeItem[0] > intervals[i][1]  ){ // [0] 는 시작점
                //     // 겹치는 부분이 없는 경우
                   
                // }else{
                //     // 겹치는 부분이 있는 경우
                // }
            }
            if(j>=merLen) // 겹치는 부분이 없었음
            {
                mergeArray.add(intervals[i]);
            }
        }
        int[][] mergeArr=new int[mergeArray.size()][2];
        for(int k=0; k<mergeArr.length; k++){
            mergeArr[k][0]=mergeArray.get(k)[0];
            mergeArr[k][1]=mergeArray.get(k)[1];
        }
        return mergeArr;
    }
}