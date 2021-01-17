 //ES6 문법으로 자바스크립트에서도 클래스 사용 가능
 class ListNode{
     constructor(val){
         this.val= val===undefined ? null : val;
         this.next=null;
     }
 }

var reverseList = function(head) {
    
    let reverseNode = null; //새로운 연결리스트의 head역활을 할 포인터
    for(; head!=null; ){
        let newNode=new ListNode(head.val); // 새 노드 생성
        newNode.next = reverseNode; // 
        reverseNode = newNode;
        head = head.next; // 다음 연결리스트로 이동
    }
    return reverseNode
};

