/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */

 class ListNode{
     constructor(val){
         this.val= val===undefined ? null : val;
         this.next=null;
     }

    //  setNext(nextOne){
    //      this.next=nextOne;
    //  }
 }

var reverseList = function(head) {
    
   let reverseNode=new ListNode();
    for(; head!=null; ){
        let newNode=new ListNode(head.val);
        newNode.next=reverseNode;
        reverseNode=
    }
};

